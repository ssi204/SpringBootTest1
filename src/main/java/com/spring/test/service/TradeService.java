package com.spring.test.service;

import com.spring.test.model.BuySellIndicator;
import com.spring.test.model.StockListRequested;
import com.spring.test.model.TradeData;
import com.spring.test.repository.BlackListedStocksRepository;
import com.spring.test.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TradeService {

    @Autowired
    TradeRepository traderepo;

    @Autowired
    BlackListedStocksRepository blackListedStocksRepository;

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public StockListRequested readFile(File f) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String line = bf.readLine();
        ArrayList<TradeData> acceptedStocks = new ArrayList<>();
        ArrayList<TradeData> rejectedStocks = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            String[] s = line.split("[|][\\s]*");
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
            Date date1 = sdf1.parse(s[5]);
            java.util.Date date2 = sdf1.parse(s[6]);
            TradeData u = new TradeData(Long.parseLong(s[0]), s[1], s[2], s[3], Integer.parseInt(s[4].trim()), date1, date2, BuySellIndicator.valueOf(s[7]));
            if (!traderepo.existsById(Long.parseLong(s[0]))) {
                if (!blackListedStocksRepository.existsById(s[1])) {
                    if (date1.compareTo(date2) > 0) {
                        if (Integer.parseInt(s[4].trim()) > 0) {
                            traderepo.save(u);
                            acceptedStocks.add(u);
                        } else {
                            rejectedStocks.add(u);
                            System.out.println("quantity is negative");
                        }
                    } else {
                        rejectedStocks.add(u);
                        System.out.println("settlement date is before trade date");
                    }
                } else {
                    rejectedStocks.add(u);
                    System.out.println(s[1] + "is balcklisted");
                }
            } else {
                rejectedStocks.add(u);
                System.out.println("Already existing user");
            }
        }
        StockListRequested list= new StockListRequested(acceptedStocks, rejectedStocks);
      //  ArrayList<ArrayList<TradeData>> list = new ArrayList<>();
       // list.add(acceptedStocks);
       // list.add(rejectedStocks);
        return list;
    }

    public List<TradeData> getBrokerTradeData(String brokerName) {
        return traderepo.findAllBrokers(brokerName);
    }

    public List<String> getTop5Stocks() {
        return traderepo.findTop5Stocks(new PageRequest(0, 5));
    }

}

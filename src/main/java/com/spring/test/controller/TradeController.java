package com.spring.test.controller;

import com.spring.test.model.StockListRequested;
import com.spring.test.service.TradeService;
import com.spring.test.model.BlackList;
import com.spring.test.model.TradeData;
import com.spring.test.repository.BlackListedStocksRepository;
import com.spring.test.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.text.ParseException;
import java.util.*;


@RestController
@RequestMapping("/api")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @Autowired
    TradeRepository repo;

    @Autowired
    BlackListedStocksRepository blackListedStocksRepository;

    @GetMapping("/tradeData/{brokerName}")
    @ResponseBody
    public List<TradeData> tradeData(@PathVariable String brokerName) {
        List<TradeData> brokers = tradeService.getBrokerTradeData(brokerName);
       // return brokers.stream().map(e-> new TradeData(e.getTradeId(), e.getStockName(), e.getBrokerCode())).collect(Collectors.toList());
       return brokers;
    }

    @GetMapping("/top5Stocks")
    @ResponseBody
    public List<String> top5Stocks() {
        //throw new NullPointerException();
        List<String> brokers = tradeService.getTop5Stocks();
        return brokers;
    }

    @PostMapping("/fileUpload")
    @ResponseStatus(value = HttpStatus.CREATED)
    public StockListRequested fileUpload(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        File f = tradeService.convert(file);
        StockListRequested stockList = tradeService.readFile(f);
        return stockList;
    }

    @PostMapping("/blackListStocks")
    @ResponseStatus
    public BlackList[] blockStocks(@RequestBody BlackList[] stock) {
        for (BlackList s : stock
        ) {
            blackListedStocksRepository.save(s);
        }
        return stock;
    }

    @PostMapping("/addTradeData")
    @ResponseBody
    public TradeData addTradeData(@RequestBody @Valid TradeData tradeData){
            if(!repo.existsById(tradeData.getTradeId()) && !blackListedStocksRepository.existsById(tradeData.getStockName()) )
            repo.save(tradeData);
        return tradeData;
    }
    @PostMapping("/addTradeDataSet")
    @ResponseBody
    public TradeData[] addTradeDataSet(@RequestBody @Valid TradeData[] tradeData){
        for (TradeData t: tradeData
             ) {
        if(!repo.existsById(t.getTradeId()) && !blackListedStocksRepository.existsById(t.getStockName()) )
            repo.save(t);
         }
        return tradeData;
    }
}

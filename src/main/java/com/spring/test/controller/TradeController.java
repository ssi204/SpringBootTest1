package com.spring.test.controller;

import com.spring.test.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.test.model.User;

@RestController
@RequestMapping("/api")
public class TradeController {

    /*@GetMapping("/trade/{tradeid}")
    public String  getTrade(@PathVariable int tradeid){
        return "trade"+ tradeid;
    }*/
     //@Autowired
   // TradeRepository repo;

    @PostMapping("/enterData")
    public void enterData(@RequestBody User user){
        System.out.println(user);
    }

}

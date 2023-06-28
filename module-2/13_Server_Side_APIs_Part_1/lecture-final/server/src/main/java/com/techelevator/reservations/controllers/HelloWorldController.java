package com.techelevator.reservations.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//Spring needs this @RestController to recognize this class should be listening for
//HTTP requests
@RestController
public class HelloWorldController {

    @RequestMapping(path="/helloWorld", method= RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(path="today", method=RequestMethod.GET)
    public boolean isDateBeforeToday(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
        if(LocalDate.now().isAfter(date)){
            return true;
        }

        return false;
    }

}

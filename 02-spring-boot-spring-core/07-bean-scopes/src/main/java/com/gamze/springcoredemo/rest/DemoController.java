package com.gamze.springcoredemo.rest;

import com.gamze.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependency

    private Coach myCoach;
    private Coach anotherCoach;


    @Autowired
   public void DemoController(@Qualifier("cricketCoach") Coach theCoach,
                              @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor: "+getClass().getSimpleName());
       myCoach=theCoach;
       anotherCoach=theAnotherCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){

       return "Comparing beans: myCoach == anotherCoach, "+(myCoach == anotherCoach);
    }
}
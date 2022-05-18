package com.example.masksaleforpi.pi_controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioPinImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/19/0:54
 * @Description:
 */

@RestController
public class TestController {


    @PostMapping("test")
    public String test() throws InterruptedException {
        Pin pinout = RaspiPin.GPIO_14;
        long frequency = 50;
        GpioController gpio = GpioFactory.getInstance();
        GpioPinImpl gpioOut = new GpioPinImpl(gpio, new RaspiGpioProvider(), pinout);
        while (true){
            frequency = gpioOut.getPwm();
            System.out.println(frequency);
            Thread.sleep(1000);
            System.out.println("正在转动");
        }
    }

















//
//    // create gpio controller instance
//    final GpioController gpio = GpioFactory.getInstance();
//    GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14,   // PIN NUMBER
//            "My LED",           // PIN FRIENDLY NAME (optional)
//            PinState.LOW);
//    @RequestMapping("/open")
//    @ResponseBody
//    public String open(){
//        // PIN STARTUP STATE (optional)
//        myLed.setState(PinState.HIGH);
//        return "open";
//    }
//
//    @RequestMapping("/close")
//    @ResponseBody
//    public String close(){
//        myLed.setState(PinState.LOW);
//        return "close";
//    }

}
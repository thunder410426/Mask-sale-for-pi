package com.example.masksaleforpi.pi_controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.impl.GpioPinImpl;
import com.pi4j.io.i2c.I2CBus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
        System.out.println("Started");
        GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput motor;
        Pin pin = RaspiPin.GPIO_15;
        motor = gpio.provisionPwmOutputPin(pin);

        com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
        com.pi4j.wiringpi.Gpio.pwmSetRange(1000);
        com.pi4j.wiringpi.Gpio.pwmSetClock(1);

        motor.setPwm(300);
        return "启动成功";
    }

    @PostMapping("test1")
    public String test1(){
        return "连接成功";
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

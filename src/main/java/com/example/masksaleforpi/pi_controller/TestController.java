package com.example.masksaleforpi.pi_controller;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.impl.GpioPinImpl;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
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

        GpioPinDigitalInput button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, "button",
                PinPullResistance.PULL_DOWN);

        //获取与此按钮关联的 GPIO 引脚的显式状态枚举
        PinState state = button.getState();
        // 使用方便的包装方法来审问的按钮状态
        boolean buttonPressed = button.isHigh();
        button.addListener(new GpioUsageExampleListener());


        //输出
        final GpioPinPwmOutput p = gpio.provisionSoftPwmOutputPin(RaspiPin.GPIO_01, "motor", 50);
        p.setShutdownOptions(true, PinState.LOW);
        p.setPwmRange(100);

        //pin关机
//        p.setShutdownOptions(true, PinState.LOW, PinPullResistance.PULL_DOWN);
        //添加触发器
        button.addTrigger(new GpioSyncStateTrigger((GpioPinDigitalOutput) p));


        while (true){
            p.setPwm(200);
            p.setPwm(200);


            Thread.sleep(10000);

            System.out.println("旋转！旋转！");
        }



//
//        Pin pin = RaspiPin.GPIO_15;
//
//        motor = gpio.provisionPwmOutputPin(pin);
//
//        com.pi4j.wiringpi.Gpio.pwmSetMode(com.pi4j.wiringpi.Gpio.PWM_MODE_MS);
//        com.pi4j.wiringpi.Gpio.pwmSetRange(1000);
//        com.pi4j.wiringpi.Gpio.pwmSetClock(1);
//
//        motor.setPwm(300);
//        gpio.setState(true, (GpioPinDigitalOutput) motor);
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
class GpioUsageExampleListener implements GpioPinListenerDigital {
    @Override
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        // 在控制台上显示 pin 状态
        System.out.println(
                " --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());

    }
}

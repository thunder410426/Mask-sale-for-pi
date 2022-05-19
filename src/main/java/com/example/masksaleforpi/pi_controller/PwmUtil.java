package com.example.masksaleforpi.pi_controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/19/10:43
 * @Description:
 */
import com.pi4j.io.gpio.*;

import com.pi4j.util.CommandArgumentParser;

/**

 * 设置轮子的速度

 *

 */

public class PwmUtil {

// public boolean setSpeed(Pin enableAWheel, int speed){

// boolean result = true;

// try{

// GpioController gpio = GpioUtil.getGpioController();

//

// GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(enableAWheel);

// pwm.setPwmRange(100);//默认值

// pwm.setPwm(speed);

// }catch (Exception e){

// result = false;

// }

// return result;

// }

    public static void main(String[] args){

        try{

            GpioController gpio = GpioFactory.getInstance();

//启动
            Pin enableAWheel = CommandArgumentParser.getPin(//A的使能控制

                    RaspiPin.class, // pin provider class to obtain pin instance from

                    RaspiPin.GPIO_29, // default pin if no pin argument found

                    args);

            GpioPinPwmOutput pwm = gpio.provisionSoftPwmOutputPin(enableAWheel);

            pwm.setPwmRange(100);

            pwm.setPwm(200);

            try {

                Thread.sleep(50000);//睡眠2秒

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            pwm.setPwmRange(1000);

            try {

                Thread.sleep(5000);//睡眠2秒

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            pwm.setPwmRange(0);

            try {

                Thread.sleep(5000);//睡眠2秒

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            pwm.setPwmRange(3000);

            try {

                Thread.sleep(5000);//睡眠2秒

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            pwm.setPwmRange(3000);

            try {

                Thread.sleep(2000000);//持续时间久一点

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
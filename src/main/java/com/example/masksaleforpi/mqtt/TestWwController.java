package com.example.masksaleforpi.mqtt;
import com.example.masksaleforpi.mqtt.mqtt_config.MqttGateWay;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestWwController {

    @Resource
    private MqttGateWay mqttGateway;

    @RequestMapping("/sendMqtt")
    public String sendMqtt(){
        String  sendData = "12356";
        System.out.println("消息订阅"+sendData);
        mqttGateway.sendToMqtt(sendData,"hello");
        return "OK";
    }

    @RequestMapping("/test")
    public String test(String  sendData){
        return "testOK";
    }

}
package com.example.masksaleforpi.mqtt.mqtt_config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 刘京毫
 * @Date: 2022/05/12/14:08
 * @Description:
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateWay {
    void sendToMqtt(String data,@Header(MqttHeaders.TOPIC) String topic);
}

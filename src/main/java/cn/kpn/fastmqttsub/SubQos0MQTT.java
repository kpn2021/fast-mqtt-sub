package cn.kpn.fastmqttsub;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.codec.ByteBufferUtil;
import net.dreamlu.iot.mqtt.spring.client.MqttClientSubscribe;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Slf4j
@Component
public class SubQos0MQTT {

    @MqttClientSubscribe("plc001/upload/qwe/#")
    public void subQos0(String topic, ByteBuffer payload) {
        log.info("topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }


    @MqttClientSubscribe("plc001/sensor/#")
    public void sensorTemp(String topic, ByteBuffer payload) {
        log.info("topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }



}

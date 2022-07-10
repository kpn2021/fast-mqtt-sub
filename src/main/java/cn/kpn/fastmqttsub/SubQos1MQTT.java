package cn.kpn.fastmqttsub;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.codec.ByteBufferUtil;
import net.dreamlu.iot.mqtt.codec.MqttQoS;
import net.dreamlu.iot.mqtt.spring.client.MqttClientSubscribe;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Slf4j
@Component
public class SubQos1MQTT {

    @MqttClientSubscribe(value = "plc001/ctrl/#", qos = MqttQoS.AT_LEAST_ONCE)
    public void subQos1(String topic, ByteBuffer payload) {
        log.info("topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

}

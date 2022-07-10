package cn.kpn.fastmqttsub;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.codec.ByteBufferUtil;
import net.dreamlu.iot.mqtt.codec.MqttQoS;
import net.dreamlu.iot.mqtt.spring.client.MqttClientSubscribe;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

@Slf4j
@Component
public class SubQos2MQTT {


    @MqttClientSubscribe(value = "test/once/msg", qos = MqttQoS.EXACTLY_ONCE)
    public void subQos2(String topic, ByteBuffer payload) {
        log.info("topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }
}

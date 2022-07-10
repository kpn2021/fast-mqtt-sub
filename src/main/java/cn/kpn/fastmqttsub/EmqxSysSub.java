package cn.kpn.fastmqttsub;

import lombok.extern.slf4j.Slf4j;
import net.dreamlu.iot.mqtt.codec.ByteBufferUtil;
import net.dreamlu.iot.mqtt.spring.client.MqttClientSubscribe;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;

/**
 * Emq x 系统主题订阅
 *
 * <a href="https://www.emqx.io/docs/zh/v5.0/advanced/system-topic.html">...</a>
 * EMQ x 系统主题官方文档
 */
@Component
@Slf4j
public class EmqxSysSub {
    //-----------EMQ 集群状态信息------------------------------------------------------------

    /**
     * $SYS/brokers/${node}/version
     * EMQX 版本
     *
     * @param topic
     * @param payload
     */
    @MqttClientSubscribe("$SYS/brokers/+/version")
    public void subEmqxVersion(String topic, ByteBuffer payload) {
        log.info("EmqX版本信息topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    /**
     * $SYS/brokers/${node}/uptime
     * EMQX 运行时间
     */
    @MqttClientSubscribe("$SYS/brokers/+/uptime")
    public void subEmqxUptime(String topic, ByteBuffer payload) {
        log.info("EmqX运行时间topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    /**
     * $SYS/brokers/${node}/datetime
     * EMQX 系统时间
     */
    @MqttClientSubscribe("$SYS/brokers/+/datetime")
    public void subEmqxSysTime(String topic, ByteBuffer payload) {
        log.info("EmqX系统时间topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    //-------EMQ系统统计-----------------------------------------------------------

    /**
     * $SYS/brokers/emqx@172.17.0.2/stats/connections.count
     * 当前客户端总数
     */
    @MqttClientSubscribe("$SYS/brokers/+/stats/connections.count")
    public void subEmqxCountNowClient(String topic, ByteBuffer payload) {
        log.info("EmqX当前客户端总数topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    /**
     * $SYS/brokers/emqx@172.17.0.2/stats/connections.max
     * 客户端数量历史最大值
     */
    @MqttClientSubscribe("$SYS/brokers/+/stats/connections.max")
    public void subEmqxCountHistoryClient(String topic, ByteBuffer payload) {
        log.info("EmqX客户端数量历史最大值topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }


    /**
     * $SYS/brokers/emqx@172.17.0.2/stats/topics.count
     * 当前 Topic 总数
     */
    @MqttClientSubscribe("$SYS/brokers/+/stats/topics.count")
    public void subEmqxCountNowTopic(String topic, ByteBuffer payload) {
        log.info("EmqX当前 Topic 总数topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    /**
     * $SYS/brokers/emqx@172.17.0.2/stats/topics.max
     * Topic 数量历史最大值
     */
    @MqttClientSubscribe("$SYS/brokers/+/stats/topics.max")
    public void subEmqxCountHistoryTopic(String topic, ByteBuffer payload) {
        log.info("EmqX Topic 数量历史最大值topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }


    /**
     * $SYS/brokers/emqx@172.17.0.2/metrics/bytes/sent
     * 累计发送流量
     */
    @MqttClientSubscribe("$SYS/brokers/+/metrics/bytes/sent")
    public void subEmqxMetricsSent(String topic, ByteBuffer payload) {
        log.info("EmqX 累计发送流量topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }

    /**
     * $SYS/brokers/emqx@172.17.0.2/metrics/bytes/received
     * 累计接收流量
     */
    @MqttClientSubscribe("$SYS/brokers/+/metrics/bytes/received")
    public void subEmqxMetricsReceived(String topic, ByteBuffer payload) {
        log.info("EmqX 累计接收流量 topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }



//-------客户端上下线事件订阅-------------------------------------------------------------------------------

    /**
     * $SYS/brokers/${node}/clients/${clientid}/connected
     * 上线事件。当任意客户端上线时，EMQX 就会发布该主题的消息
     *
     * @param topic
     * @param payload
     */
    @MqttClientSubscribe("$SYS/brokers/+/clients/+/connected")
    public void subDeviceConnect(String topic, ByteBuffer payload) {
        log.info("设备上线topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }


    /**
     * $SYS/brokers/${node}/clients/${clientid}/disconnected
     * 下线事件。当任意客户端下线时，EMQX 就会发布该主题的消息
     *
     * @param topic
     * @param payload
     */
    @MqttClientSubscribe("$SYS/brokers/+/clients/+/disconnected")
    public void subDeviceDisConnect(String topic, ByteBuffer payload) {
        log.info("设备下线topic:{} payload:{}", topic, ByteBufferUtil.toString(payload));
    }


}

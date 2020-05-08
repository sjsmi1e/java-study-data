package com.smile.service.impl;

import com.smile.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author smi1e
 * @description
 * @Date 2020/4/25 21:03
 */
//定义消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {


    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        log.info("********serial:" + s);
        return s;
    }
}

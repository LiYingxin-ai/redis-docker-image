package com.test.queue;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Log4j2
@RestController
@RequestMapping("/redis")
public class RedisPublisher {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(RedisPublisher.class);
    @Autowired
    private StringRedisTemplate template;

    //  http://localhost:8091/redis/publish
    @RequestMapping("/publish")
    public String publish() {
        logger.info(" -- controller publish Begin --");

        for (int i = 1; i <= 10; i++) {
            template.convertAndSend("MyTopic","这是我的第" + i + "条消息...");
        }

        logger.info(" -- controller publish End   --");

        return "缓存发送10条消息结束";
    }

}

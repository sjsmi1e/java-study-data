package smile.service;

import com.smile.mapper.RedisMapper;
import com.smile.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-15 上午10:59
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class RedisService implements RedisMapper {

    //注入JEDIS
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void set(Email email) {
        //向redis里存入数据和设置缓存时间
        redisTemplate.opsForValue().set(email.getEmail(),email.getVeriCode(),60*10, TimeUnit.SECONDS);
    }

    @Override
    public String get(String email) {
        return (String) redisTemplate.opsForValue().get(email);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
}

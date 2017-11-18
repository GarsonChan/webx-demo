package webx.engine.util.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Garson in 20:12 2017/11/17
 * Description : redis工具类,要测试时记住要将@Component的注释去掉
 */
//@Component
public class RedisUtil {

	private JedisPool jedisPool;
	@Autowired
	public RedisUtil(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public Jedis getJedis() {
		if (jedisPool != null) {
			return jedisPool.getResource();
		}else {
			return null;
		}
	}

	public void close(Jedis jedis){
		if(jedis != null)jedis.close();
	}

}

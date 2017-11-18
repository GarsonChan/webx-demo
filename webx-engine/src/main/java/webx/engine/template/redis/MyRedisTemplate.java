package webx.engine.template.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Garson in 16:07 2017/11/18
 * Description : 获取spring-data-redis配置的redisTemplate
 */
@Component("myRedisTemplate")
public class MyRedisTemplate {

	private RedisTemplate<String ,Object> redisTemplate;
	@Autowired
	public MyRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 设置key-value缓存
	 * @param key key
	 * @param value value
	 */
	public void set(String key ,Object value){
		ValueOperations<String ,Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value);
	}

	/**
	 * 获取key-value缓存
	 * @param key key
	 * @return value
	 */
	public Object get(String key){
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置key-list缓存
	 * @param key key
	 * @param value list
	 */
	public void setList(String key, List<?> value) {
		ListOperations<String ,Object> listOperations = redisTemplate.opsForList();
		listOperations.leftPush(key, value);
	}

	/**
	 * 获取key-list缓存
	 * @param key key
	 * @return list
	 */
	public Object getList(String key) {

		return redisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 设置key-set缓存
	 * @param key key
	 * @param value set
	 */
	public void setSet(String key, Set<?> value) {
		SetOperations<String ,Object> setOperations = redisTemplate.opsForSet();
		setOperations.add(key, value);
	}

	/**
	 * 获取key-set缓存
	 * @param key key
	 * @return set
	 */
	public Object getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	/**
	 * 设置key-hash缓存
	 * @param key key
	 * @param value hash
	 */
	public void setHash(String key, Map<String, ?> value) {
		HashOperations<String ,String ,Object> hashOperations = redisTemplate.opsForHash();
		hashOperations.putAll(key, value);
	}

	/**
	 * 获取key-hash缓存
	 * @param key key
	 * @return hash
	 */
	public Object getHash(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 * 删除key缓存
	 * @param key key
	 */
	public void delete(String key) {
		redisTemplate.delete(key);
	}

}

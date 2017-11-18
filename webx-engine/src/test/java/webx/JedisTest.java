package webx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import webx.engine.template.redis.MyRedisTemplate;
import webx.engine.util.redis.Role;
import webx.engine.util.redis.RedisUtil;

import java.util.*;

/**
 * Created by Garson in 20:49 2017/11/17
 * Description : JedisTest
 */
public class JedisTest {

	/**
	 * 测试没有配置spring-data-redis的redis工具
	 */
	/*@Test
	public void TestJedis(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:redis.xml");
		RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisUtil");
		Jedis jedis = redisUtil.getJedis();
		System.out.println(jedis);
		jedis.set("name" ,"Garson");
		System.out.println(jedis.get("name"));
		redisUtil.close(jedis);
	}*/

	/**
	 * 测试没有配置spring-data-redis的redis工具
	 */
	/*
	@Test
	public void TestJedisPojo(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:redis.xml");
		RedisUtil redisUtil = (RedisUtil) applicationContext.getBean("redisUtil");
		Jedis jedis = redisUtil.getJedis();
		System.out.println(jedis);
		Role role = new Role(1 ,"Garson");
		String key = "role";
		jedis.set(key.getBytes() , SerializingUtil.serialize(role));
		System.out.println(jedis.get(key.getBytes()).toString());
		Role role1 = (Role) SerializingUtil.deserialize(jedis.get(key.getBytes()));
		System.out.println(role1);
	}*/

	/**
	 * 测试spring-data-redis缓存的工具
	 */
	@Test
	public void TestJedisSpring(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
		MyRedisTemplate redisTemplate = (MyRedisTemplate) applicationContext.getBean("myRedisTemplate");
		System.out.println("-----key-value-----");
		redisTemplate.set("nameKey" ,"Garson");
		System.out.println(redisTemplate.get("nameKey"));
		System.out.println("-----key-list-----");
		List<String> list = new ArrayList<>();
		list.add("GarsonList1");
		list.add("GarsonList2");
		list.add("GarsonList3");
		redisTemplate.setList("nameList" ,list);
		System.out.println(redisTemplate.getList("nameList"));
		System.out.println("-----key-set-----");
		Set<String> set = new HashSet<>();
		set.add("GarsonSet1");
		set.add("GarsonSet2");
		set.add("GarsonSet3");
		redisTemplate.setSet("nameSet" ,set);
		System.out.println(redisTemplate.getSet("nameSet"));
		System.out.println("-----key-Hash-----");
		HashMap<String ,Object> hashMap = new HashMap<>();
		hashMap.put("nameHash1" ,"GarsonHash1");
		hashMap.put("nameHash2" ,"GarsonHash2");
		hashMap.put("nameHash3" ,"GarsonHash3");
		redisTemplate.setHash("nameHash" ,hashMap);
		System.out.println(redisTemplate.getHash("nameHash"));
		System.out.println("-----test pojo-----");
		Role role = new Role(1 ,"Garson");
		redisTemplate.set("role" ,role);
		System.out.println(role);
	}

}

package webx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import webx.engine.dao.UserDao;

import javax.annotation.Resource;

/**
 * Created by Garson in 14:07 2017/11/10
 * Description :
 */
public class UserDaoTest {

	@Test
	public void selectTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("engine.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		for (int i = 0 ; i<3; i++)
		System.out.println(userDao.selectByName("wang"));
	}

	@Test
	public void selectRoleTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("engine.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		System.out.println(userDao.getRoles("wang"));
	}

}

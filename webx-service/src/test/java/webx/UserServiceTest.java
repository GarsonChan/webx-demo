package webx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import webx.service.user.UserService;

/**
 * Created by Garson in 19:38 2017/11/10
 * Description :
 */
public class UserServiceTest {

	@Test
	public void selectTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println(userService.selectByName("wang"));
	}

}

package webx;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import webx.po.User;
import webx.service.user.UserService;

import javax.annotation.Resource;

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

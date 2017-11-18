package webx.app1.module.screen.admin;

import org.springframework.beans.factory.annotation.Autowired;
import webx.engine.template.redis.MyRedisTemplate;
import webx.po.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Garson in 22:14 2017/11/10
 * Description :
 */

public class aaa {

	@Autowired
	HttpServletResponse response;
	@Autowired
	MyRedisTemplate myRedisTemplate;

	public void execute() throws IOException {
		PrintWriter out = response.getWriter();
		out.print("欢迎登录");
		out.print(myRedisTemplate.get("name"));
		User user = new User();
		myRedisTemplate.set("user" ,user);
	}

}

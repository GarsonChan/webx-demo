package webx.app1.module.screen.login;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import webx.engine.dao.UserDao;
import webx.po.User;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Garson in 20:24 2017/10/31
 * Description :
 */
public class Login {

	@Autowired
	private HttpServletResponse response;

	public void doLogin(@Param("userName")String userName ,@Param("password")String password) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName ,password);
		PrintWriter writer = response.getWriter();
		try{
			subject.login(token);
			writer.print("登录成功");
		}catch (Exception e){
			writer.print("登录失败");
		}
	}

	public void doA() throws IOException {
		PrintWriter writer = response.getWriter();
		writer.print("111");
	}

}

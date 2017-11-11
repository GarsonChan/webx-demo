package webx.app1.module.screen.admin;

import org.springframework.beans.factory.annotation.Autowired;

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

	public void execute() throws IOException {
		PrintWriter out = response.getWriter();
		out.print("欢迎登录");
	}

}

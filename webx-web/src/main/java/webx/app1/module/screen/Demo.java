package webx.app1.module.screen;

import com.alibaba.citrus.service.requestcontext.lazycommit.LazyCommitRequestContext;
import com.alibaba.citrus.service.requestcontext.parser.ParserRequestContext;
import com.alibaba.citrus.util.StringUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Garson in 21:23 2017/11/13
 * Description :
 */
public class Demo {

	@Autowired
	ParserRequestContext parser;
	@Autowired
	LazyCommitRequestContext lazyCommit;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	private Logger logger = LoggerFactory.getLogger(Demo.class);

	/**
	 * 访问http://localhost:8080/webx/Demo/GetParserParamDemo.do?param=123
	 * @throws IOException IOException
	 */
	public void doGetParserParamDemo() throws IOException {
		PrintWriter out = response.getWriter();
		String s = parser.getParameters().getString("param" ,"no_value");
		Boolean b = parser.getParameters().getBoolean("param" ,false);
		int i = parser.getParameters().getInt("param" ,-1);
		out.print("String: " + s + ";Boolean: " + b + ";Int: " + i);
	}

	/**
	 * 访问http://localhost:8080/webx/Demo/UploadFile.do
	 */
	public void doUploadFile(){
		Boolean isMutipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMutipart);
		if(isMutipart){
			System.out.println("111");
			FileItem[] items = parser.getParameters().getFileItems("file");
			if(items != null){
				String fileName;
				for (FileItem item: items){
					fileName = item.getName();
					if(!item.isFormField() && !StringUtil.isBlank(fileName)){
						File file = new File("D:/test/" + fileName);
						try {
							item.write(file);
						} catch (Exception e) {
							logger.error("error" ,e);
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 访问http://localhost:8080/webx/Demo/lazyCommit.do，获取response一些状态，文档p113
	 * @throws IOException IOException
	 */
	public void doLazyCommit() throws IOException {
		PrintWriter out = response.getWriter();
		out.print("test lazy commit");
		//访问response状态
		response.encodeURL("http://localhost:8080/webx/Demo/lazyCommit.do");
		System.out.println("isError :" + lazyCommit.isError() + " getStatus: " + lazyCommit.getStatus());
	}

	public void doRewrite(){
		int x = parser.getParameters().getInt("x");
		System.out.println(x);
	}


}

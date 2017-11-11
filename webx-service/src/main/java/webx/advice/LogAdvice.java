package webx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

/**
 * Created by Garson in 19:21 2017/11/10
 * Description :
 */
@Order(0)
@Aspect
@Controller
public class LogAdvice {

	private Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	@Pointcut("execution(* webx.service..*.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		Signature signature = joinPoint.getSignature();
		logger.info("---execute method: " + signature.getDeclaringTypeName() + signature.getName());
	}

	@AfterThrowing(value = "pointCut()" ,throwing = "e")
	public void afterThrow(JoinPoint joinPoint ,Exception e){
		Signature signature = joinPoint.getSignature();
		logger.error("---execute method: " + signature.getDeclaringTypeName() + signature.getName()
				+ "---Throw Exception: " + e);
	}


}

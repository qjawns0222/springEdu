package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
@Service
@Aspect
public class AroundAdvice {
 
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinpoint) throws Throwable {
		String method=joinpoint.getSignature().getName();
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		Object returnObj=joinpoint.proceed();
		stopWatch.stop();
		System.out.println(method+"()메서드 수행에 걸린시간"+stopWatch.getTotalTimeMillis()+"(ms)초");
		return returnObj;
	}

}

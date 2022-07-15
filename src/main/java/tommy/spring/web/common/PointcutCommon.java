package tommy.spring.web.common;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {
	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
	public void allPointcut() {}
	@Pointcut("execution(* tommy.spring.web..*Impl.get*(..))")
	public void getPointcut() {}
}

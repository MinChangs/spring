package kr.or.ddit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAspect {
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}

	@Around("dummy()")
	public Object aroundTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime= System.currentTimeMillis();
		logger.debug("시작시간 : {}",startTime);
		
		Object[] aaa= joinPoint.getArgs();
		Object bbb= joinPoint.proceed(aaa);
		
		
		long endTime= System.currentTimeMillis();
		
		logger.debug("종료시간 : {}",endTime);
		logger.debug("소요시간 : {}",endTime-startTime);
		
		return bbb;
	}

}

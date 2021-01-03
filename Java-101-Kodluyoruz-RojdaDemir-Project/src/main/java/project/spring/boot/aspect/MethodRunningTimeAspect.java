package project.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import project.spring.boot.aspect.annotation.MethodRunningTime;
@Aspect
@Component
public class MethodRunningTimeAspect {

	@Around("@annotation(methodRunningTime)")
	public Object execute(ProceedingJoinPoint joinPoint, MethodRunningTime methodRunningTime) 
			throws Throwable {
		
		if(!methodRunningTime.active()) {
			return joinPoint.proceed();
		}
		
		String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
		
		String methodName = joinPoint.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object result = joinPoint.proceed();
		
		stopWatch.stop();
		
		System.out.println(className + "#" + methodName + " runnedin " + stopWatch.getTotalTimeMillis() + " ms");
		
		return result;
	}
}
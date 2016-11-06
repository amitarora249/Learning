package org.practice.spring.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	private Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
	}

	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info("The method " + joinPoint.getSignature().getName()
				+ "() ends");
	}

	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("The method " + joinPoint.getSignature().getName()
				+ "() ends with " + result);
	}

	public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
		LOGGER.info("Illegal argument " + Arrays.toString(joinPoint.getArgs())
				+ " in " + joinPoint.getSignature().getName() + "()");
	}

	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("The method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			LOGGER.info("The method " + joinPoint.getSignature().getName()
					+ "() ends with " + result);
			return result;
		} catch (IllegalArgumentException e) {
			LOGGER.info("Illegal argument "
					+ Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
}

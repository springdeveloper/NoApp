package com.app.npr.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.app.npr.config.debug.Settings;


@Aspect
@Component
public class LoggingAspect {
	private Boolean debug = Settings.LOG_UTIL.getValue();
	/** The start. */
	private Instant start;
	
	/** The end. */
	private Instant end;
	
	/** The message. */
	private String message = "";
	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	public Instant getEnd() {
		return end;
	}

	public void setEnd(Instant end) {
		this.end = end;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Pointcut("within(com.app.npr.dao..*)")
	private void selectAll(){}
	
	@Before("selectAll()")
	public void logBefore(JoinPoint joinPoint) {
	
		String beforeMessage = "";
		if (debug) {
			beforeMessage += joinPoint.getTarget().getClass().getName() + "{" + "\n";
			beforeMessage += "\t" + joinPoint.getSignature().toLongString() + "\n";
			beforeMessage += "\targs(" + joinPoint.getArgs().length + ") is: \n\t\t  " +
					Arrays.asList(joinPoint.getArgs());
//					readArray(joinPoint.getArgs());
			start = Instant.now();
			setMessage(beforeMessage);
		}	
		System.out.println("9000000000000000000000000000000000" + joinPoint.getSignature().getDeclaringTypeName() + " ] : " + joinPoint.getSignature().toShortString());
	}
	
	@After("selectAll()")
	public void afterMethod(JoinPoint joinPoint) {
		String afterMessage = getMessage();
		if (debug) {
			end = Instant.now();
			System.out.println(
					afterMessage +
					"\n\n\tIt take: " + Duration.between(start, end).toMillis() + " ms" +
					"\n}\n"
			);
		}
	}


}
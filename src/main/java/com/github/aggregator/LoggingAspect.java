package com.github.aggregator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	
    @Around("execution(* com.github.aggregator.service.AggregatorService.findPackage())")
    public Object logFindPackage(ProceedingJoinPoint jp) throws Throwable {
    	
    	final Logger LOG = LoggerFactory.getLogger(jp.getSignature().getDeclaringType());
        final Object ret;
        
    	LOG.info("---------- Before ---------- " + jp.getSignature());
        try {
        	ret = jp.proceed();
        	LOG.info("---------- After ---------- " + jp.getSignature());
        	return ret;
        } catch (Throwable e) {
        	LOG.info("---------- Oops! ---------- " + e);
        	throw e;
        }
    }
}

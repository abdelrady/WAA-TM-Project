package edu.mum.tm.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionLoggingAspect {

    private Logger log = Logger.getLogger(getClass());

    @Pointcut("execution(* edu.mum.tm.controller.*(..))")
    public void serviceLayerMethods() {

    }

    @AfterThrowing(pointcut = "serviceLayerMethods()", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {

        StringWriter stack = new StringWriter();
        ex.printStackTrace(new PrintWriter(stack));

        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            stack.append("Arg: " + signatureArg);
        }

        log.error("----------------------------------------------------------");
        log.error(stack.toString());
        log.error("----------------------------------------------------------");
    }
}
package data.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private final RequestResponseLoggingService loggingService;

    public LoggingAspect(RequestResponseLoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Around("execution(* data.Utils.Calculator.*(..)))")
    public Object addInputAndOutputLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return loggingService.logRequestAndResponseFromJointPoint(proceedingJoinPoint);
    }
}

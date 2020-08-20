package data.Aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class RequestResponseLoggingService {
    private final Logger log = LogManager.getLogger("elasticsearch");

    private String getRequestInput(Object request) {
        return request.toString();
    }

    private String getResponseOutput(Object response) {
        return response.toString();
    }

    private String getMethodName(ProceedingJoinPoint proceedingJoinPoint) {
        return proceedingJoinPoint.getSignature().getName();
    }

    @SuppressWarnings("Duplicates")
    Object logRequestAndResponseFromJointPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = getMethodName(proceedingJoinPoint);
        try {
            Object[] request = proceedingJoinPoint.getArgs();
            log.info(methodName + " -> " + getRequestInput(request[0]));
        } catch (Exception e) {
            log.warn("Unable to log request ", e);
        }
        Object result = proceedingJoinPoint.proceed();
        try {
            log.info(methodName + " <- " + getResponseOutput(result));
        } catch (Exception e) {
            log.warn("Unable to log response ", e);
        }
        return result;
    }
}

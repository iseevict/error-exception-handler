package practice.error_exception.domain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 클래스를 AOP Aspect(관심사) 로 선언
@Component // Bean 등록
public class ExceptionHandlerAspect {

    /*@Around("execution(* practice.error_exception.domain.aop.AopTestService.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            System.err.println("Exception in method: " + joinPoint.getSignature());
            e.printStackTrace();
            return "3";
        } catch (Throwable e) {
            System.err.println("Exception in method: " + joinPoint.getSignature());
            return "3";
        }
    }*/

    @Around("@annotation(practice.error_exception.domain.aop.AopTestAnnotation)")
    public Object handleCustomAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("Before method execution: " + joinPoint.getSignature());
            Object result = joinPoint.proceed(); // 원래 메서드 실행
            System.out.println("After method execution: " + joinPoint.getSignature());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}

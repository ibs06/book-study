package chap07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {
//    @Pointcut("execution(public * chap07..factorial(..))")
//    private void publicTarget() {
//
//    }

    @Around("CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.println(joinPoint.getTarget().getClass().getSimpleName() + sig.getName() + Arrays.toString(joinPoint.getArgs()) + (finish - start));
        }
    }
}

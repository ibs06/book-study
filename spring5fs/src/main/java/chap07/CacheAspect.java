package chap07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(2)
public class CacheAspect {
    private Map<Long,Object> cache = new HashMap<>();

//    @Pointcut("execution(public * chap07..factorial(..))")
//    public void cacheTarget(){
//
//    }


//    @Around("execution(public * chap07..factorial(..))")
    @Around("CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long)joinPoint.getArgs()[0];
        if(cache.containsKey(num)){
            System.out.println("CacheAspect :  Cache에서 구함 "+num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num,result);
        System.out.println("CacheAspect :  Cache에서 추가 "+num);
        return result;
    }
}

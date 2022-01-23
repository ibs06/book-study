package chap07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainAspectAutoProxy {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCache.class);

        Calculator cal = ctx.getBean("calculator",Calculator.class);
        long rst = 0L;
        rst += cal.factorial(7);
        rst += cal.factorial(7);
        rst += cal.factorial(5);
        rst +=  cal.factorial(5);
        System.out.println("rst ="+rst);

        /*
        *   -> order cache먼저 적용시
            RecCalculatorfactorial[7]31099
            CacheAspect :  Cache에서 추가 7
            CacheAspect :  Cache에서 구함 7
            RecCalculatorfactorial[5]4499
            CacheAspect :  Cache에서 추가 5
            CacheAspect :  Cache에서 구함 5
            rst =10320

            -> exetime cache먼저 적용시
            * CacheAspect :  Cache에서 추가 7
            RecCalculatorfactorial[7]346100
            CacheAspect :  Cache에서 구함 7
            RecCalculatorfactorial[7]70200
            CacheAspect :  Cache에서 추가 5
            RecCalculatorfactorial[5]32700
            CacheAspect :  Cache에서 구함 5
            RecCalculatorfactorial[5]28100
            rst =10320
        * */

        ctx.close();
    }
}

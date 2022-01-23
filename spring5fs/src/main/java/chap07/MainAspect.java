package chap07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

//        Calculator cal = ctx.getBean("calculator",Calculator.class);
        // Bean named 'calculator' is expected to be of type 'chap07.RecCalculator' but was actually of type 'com.sun.proxy.$Proxy19'

        // @EnableAspectJAutoProxy(proxyTargetClass = true) 인터페이스 구현이 아니라 상속으로 설정시 정상실행 (chap07.RecCalculator$$EnhancerBySpringCGLIB$$f1aa8fce)
        RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("cla.factorial(5) ="+fiveFact);

        /* ExeTimeAspect 미설정시 프록시 객체 사용안함
        * cla.factorial(5) =120
            chap07.RecCalculator
        * */
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}

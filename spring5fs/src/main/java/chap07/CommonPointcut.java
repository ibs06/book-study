package chap07;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
    //non static ? 메소드 시그니처만을 사용하는건가?
    @Pointcut("execution(public * chap07..factorial(..))")
    public void commonTarget(){

    }
}

package chap07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {
    @Bean
    public CacheAspect cacheAspect(){
        return new CacheAspect();
    }
    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
}

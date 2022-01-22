package chap03.lifcycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {
    /*
    *
    afterPropertiesSet start
    Client2 connect 실행
    Client.send() tohost
    Client2 close 실행
    destroy start
    * */
    @Bean
    @Scope("prototype")
    public Client client(){
        Client client = new Client();
        client.setHost("host");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    @Scope("singleton")
    public Client2 client2(){
        Client2 client = new Client2();
        client.setHost("host");
        return client;
    }
}

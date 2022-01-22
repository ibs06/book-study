package chap03.lifcycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client client1 = ctx.getBean(Client.class);
        client1.send();

        Client client2 = ctx.getBean(Client.class);

        System.out.println(client1 == client2);
        System.out.println(client1 != client2);

        System.out.println("-----------------------");
        Client2 client3 = ctx.getBean(Client2.class);
        Client2 client4 = ctx.getBean(Client2.class);

        System.out.println(client3 == client4);
        System.out.println(client3 != client4);

        ctx.close();
    }
}

package chap03.config;

import chap03.spring.MemberDao;
import chap03.spring.MemberPrinter;
import chap03.spring.MemberSummaryPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
//@Import(AppConf2.class)
@ComponentScan(basePackages = {"chap03.spring"},
        excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
//        excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
public class AppConfImport {

    /*
     * Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException:
     * No qualifying bean of type 'chap03.spring.MemberDao' available: expected at least 1 bean which qualifies as autowire candidate.
     * Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
     * */
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

//    @Bean
//    public MemberPrinter memberPrinter() {
//        return new MemberPrinter();
//    }

    /*Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
     No qualifying bean of type 'chap03.spring.MemberPrinter' available: expected single matching bean but found 2: memberPrinter1,memberPrinter2*/
//    @Bean
//    @Qualifier("printer1")
//    public MemberPrinter memberPrinter1() {
//        return new MemberPrinter();
//    }

    @Bean
    @Qualifier("printer1")
    public MemberPrinter memberPrinter2() {
        return new MemberPrinter();
    }

    /* Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    상속관계에서도 발생!
    * No qualifying bean of type 'chap03.spring.MemberPrinter' available: expected single matching bean but found 2: memberPrinter2,memberPrinter3
    * */
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter3() {
        return new MemberSummaryPrinter();
    }

}

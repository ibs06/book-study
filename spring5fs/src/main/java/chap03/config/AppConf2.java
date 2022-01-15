package chap03.config;

import chap03.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf2 {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao);
    }


    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
        return passwordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao, memberPrinter());
    }


    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter info = new MemberInfoPrinter();
        //세터 메서드를 사용해서 의존 주입을 하지 않아도
        // 스프링 컨테이너가 @Autowired 붙인 필드에 자동으로 해당 타입 빈 객체를 주입
//        info.setMemberDao(memberDao);
//        info.setMemberPrinter(memberPrinter());
        return info;
    }

}

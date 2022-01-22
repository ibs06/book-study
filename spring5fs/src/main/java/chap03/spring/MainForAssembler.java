package chap03.spring;

import chap03.config.AppConf1;
import chap03.config.AppConf2;
import chap03.config.AppConfImport;
import chap03.config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForAssembler {
    //    private static Assembler assembler = new Assembler();
// 스프링 : 범용 조립기
    private static ApplicationContext ctx = null;

    public static void main(String[] args) {

//        ctx = new AnnotationConfigApplicationContext(AppCtx.class);
//        ctx = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
    ctx = new AnnotationConfigApplicationContext(AppConfImport.class);

    processNewCommand();
    processChangeCommand();
}

    private static void processNewCommand() {
        System.out.println("processNewCommand call");

        //스프링 컨테이너가 @Configuration 어노테이션 설정 클래스도 스프링 빈으로 등록하는 지 확인
//
//        AppConf1 appConf1 = ctx.getBean(AppConf1.class);
//        System.out.println("appConf1 !== null : " );
//        System.out.println("appConf1 !== null : " );
//        System.out.println(appConf1 != null );
////        System.out.println(appConf1 != null );  결과 모두 true
//
//        AppConf2 appConf2 = ctx.getBean(AppConf2.class);
//
//        System.out.println("appConf2 !== null : " );
//        System.out.println(appConf2 != null );
////        System.out.println(appConf2 != null );  결과 모두 true

//        MemberRegisterService reqSvc = assembler.getRegSvc();
        MemberRegisterService reqSvc = ctx.getBean( MemberRegisterService.class);


        RegisterRequest req = new RegisterRequest();
        // 등록 케이스1
        req.setEmail("aaa@naver.com");
        req.setName("aaa");
        req.setPassword("1234");
        req.setConfirmPassword("1234");

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호 불일치");
            return;
        }
        try {
            reqSvc.regist(req);
            System.out.println("등록성공");
        } catch (RuntimeException e) {
            System.out.println("등록실패:" + e);
        }

        //등록실패 케이스 2
        req = new RegisterRequest();
        req.setEmail("aaa@naver.com");
        req.setName("aaa");
        req.setPassword("1234");
        req.setConfirmPassword("1234");

        try {
            reqSvc.regist(req);
            System.out.println("등록성공");
        } catch (RuntimeException e) {
            System.out.println("등록실패:" + e);
        }

        //멤버리스트 조회
        System.out.println("멤버리스트 조회");
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();

        //멤버 조회
        System.out.println("멤버 조회");
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo("aaa@naver.com");
    }


    private static void processChangeCommand() {
//        ChangePasswordService pwdSvc = assembler.getPwdSvc();
        ChangePasswordService pwdSvc = ctx.getBean(ChangePasswordService.class);


        try {
            pwdSvc.changePassword("aaa@naver.com", "1234", "1234");
            System.out.println("암호변경성공");
        } catch (RuntimeException e) {
            System.out.println("암호변경실패:" + e);
        }

        try {
            pwdSvc.changePassword("aaa@naver.com", "1111", "1234");
            System.out.println("암호변경성공");
        } catch (RuntimeException e) {
            System.out.println("암호변경실패:" + e);
        }

        try {
            pwdSvc.changePassword("bbb@naver.com", "1111", "1234");
            System.out.println("암호변경성공");
        } catch (RuntimeException e) {
            System.out.println("암호변경실패:" + e);
        }
    }


}

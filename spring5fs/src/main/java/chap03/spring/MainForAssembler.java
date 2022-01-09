package chap03.spring;

public class MainForAssembler {
    private static Assembler assembler = new Assembler();

    public static void main(String[] args) {
        processNewCommand();
        processChangeCommand();
    }

    private static void processNewCommand() {
        System.out.println("processNewCommand call");

        MemberRegisterService reqSvc = assembler.getRegSvc();

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
    }


    private static void processChangeCommand() {
        ChangePasswordService pwdSvc = assembler.getPwdSvc();
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

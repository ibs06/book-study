package chap03.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberPrinter memberPrinter;

    //어노테이션 내부 자동 주입으로 설정 변경
//    public void setMemberDao(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }
//
//    public void setMemberPrinter(MemberPrinter memberPrinter) {
//        this.memberPrinter = memberPrinter;
//    }

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            System.out.println("MemberInfoPrinter  데이터없음 !!");
            return;
        }
        memberPrinter.print(member);
    }
}

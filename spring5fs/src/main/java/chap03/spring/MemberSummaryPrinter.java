package chap03.spring;

public class MemberSummaryPrinter extends MemberPrinter {
    @Override
    public void print(Member member){
        System.out.println("회원정보 MemberSummaryPrinter: "+ member);
    }
}

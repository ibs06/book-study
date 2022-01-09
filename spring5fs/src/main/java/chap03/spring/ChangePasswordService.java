package chap03.spring;

public class ChangePasswordService {
    private MemberDao memberDao;

    // 세터
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void changePassword(String email, String oldPassword, String newPassword) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new RuntimeException("MemberNotFoundException");
        }
        member.changePassword(oldPassword, newPassword);
    }
}

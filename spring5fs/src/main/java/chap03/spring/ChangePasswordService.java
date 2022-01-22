package chap03.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
    @Autowired
    private MemberDao memberDao;

    // 세터 주입없이 @Autowired 변경
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

package chap03.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {

//  자동주입 선택주입 3가지 방법
//    @Autowired(required = false)
//    private DateTimeFormatter dateTimeFormatter;

//    @Autowired
//    @Nullable
//    private DateTimeFormatter dateTimeFormatter;

    @Autowired
    private Optional<DateTimeFormatter> formatter;

    //    public void print(Member member){
//        System.out.println("회원정보: "+ member);
//    }
//    public void print(Member member) {
//        if (dateTimeFormatter == null) {
//            System.out.println("회원정보 null:" + member);
//        } else {
//            System.out.println("회원정보: " + member + " / date.format: " + dateTimeFormatter.format(member.getRegisterDateTime()));
//        }
//    }
//
    public void print(Member member) {
        DateTimeFormatter dateTimeFormatter = formatter.orElse(null);
        if (dateTimeFormatter == null) {
            System.out.println("회원정보 null:" + member);
        } else {
            System.out.println("회원정보: " + member + " / date.format: " + dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

    /*
    그대로 실행시 : Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException:
    Error creating bean with name 'memberPrinter2': Unsatisfied dependency expressed through method 'setDateTimeFormatter' parameter 0;
    nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'java.time.format.DateTimeFormatter' available:
    expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
    @Autowired
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
   */
    //@Autowired(required = false) -> 회원정보 null:Member{id=1, email='aaa@naver.com', password='1234', name='aaa', registerDateTime=2022-01-22T20:28:55.595280300}
    // 메소드 실행안됨
//    @Autowired(required = false)
//    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
//        this.dateTimeFormatter = dateTimeFormatter;
//    }

    // 옵셔널 처리 -> 옵셔널 빈값 전달 회원정보 null:Member{id=1, email='aaa@naver.com', password='1234', name='aaa', registerDateTime=2022-01-22T20:30:44.445170}
    //메소드 실행
//    @Autowired
//    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatter) {
//        if (formatter.isPresent()) {
//            this.dateTimeFormatter = formatter.get();
//        } else {
//            this.dateTimeFormatter = null;
//        }
//    }


    //import org.springframework.lang.Nullable;
    //값이 없으면  null 전달후 메소드 실행 ->회원정보 null:Member{id=1, email='aaa@naver.com', password='1234', name='aaa', registerDateTime=2022-01-22T20:31:57.526324600}
//    @Autowired
//    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//        this.dateTimeFormatter = dateTimeFormatter;
//    }
}

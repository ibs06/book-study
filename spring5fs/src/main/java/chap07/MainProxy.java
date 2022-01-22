package chap07;

public class MainProxy {

    public static void main(String[] args) {
        /*
        * > Task :MainProxy.main()
            실행시간:4300 / 메소드명:ImpeCalculator
            2432902008176640000
            실행시간:3000 / 메소드명:RecCalculator
            2432902008176640000
        * */
        ExeTimeCalculator tt1 = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(tt1.factorial(20));
        ExeTimeCalculator tt2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(tt2.factorial(20));
    }
}

package chap02;

public class Greeter {
    private String formatStr;

    public String greet(String guest) {
        return String.format(formatStr, guest);
    }

    public void setFormatStr(String formatStr) {
        this.formatStr = formatStr;
    }
}

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        boolean isPWFormatted;
        boolean isDigit;
        boolean isLowerCase;
        boolean isUpperCase;
        boolean isSpecialChar;
        do{
            isPWFormatted = false;
            isDigit = false;
            isLowerCase = false;
            isUpperCase = false;
            isSpecialChar = false;

            System.out.print("請輸入密碼: ");
            str = sc.nextLine();

            for (int i = 0; i <= str.length(); i++){
                char ch = str.charAt(i);
                if(!isDigit && ((ch >= '0') && (ch <= '9'))){
                    isDigit = true;
                }
            }
        }

    }
}

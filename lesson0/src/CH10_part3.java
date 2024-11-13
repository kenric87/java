import java.util.Scanner;
public class CH10_part3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
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
            
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!isDigit && (ch >= '0' && ch <= '9')) {
                    isDigit = true;
                }
                else if(!isLowerCase && (ch>='a'&& ch<='z')){
                    isLowerCase=true;
                }
                else if (!isUpperCase && (ch>='A'&& ch<='Z'))
                isUpperCase = true;                
            }
            isSpecialChar = str.contains("@") || str.contains("#") || str.contains("$") || str.contains("%");

            isPWFormatted=isDigit&&isLowerCase&&isUpperCase&&isSpecialChar;
            if(!isPWFormatted)
            System.out.println("密碼格式應含大寫、小寫、數字和特殊符號");
            else
            System.out.println("密碼格式正確");
        }while(!isPWFormatted);
    }
}

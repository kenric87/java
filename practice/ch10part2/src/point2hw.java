//利用matches 來驗證email的格式是否正確
import java.util.*;
public class point2hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        boolean isFormatted;

        do{
            isFormatted = false;
            System.out.print("Enter your email: ");
            str = sc.next();
            if((str.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.]+[a-zA-Z0-9\\.]+")) && (str.charAt(str.length() - 1) != '.')){
                //這邊比較需要注意的是這個 charAt(str.length()-1)
                //用於判斷最後一個是否為'.'
                System.out.println("enter right");
                isFormatted = true;
            }
            if(!isFormatted)
                System.out.println("wriong email:XXX@XXX.XXX...");
        }
        while(!isFormatted);
    }
}

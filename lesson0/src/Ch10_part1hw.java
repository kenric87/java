import java.util.*;
public class Ch10_part1hw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str;
        int error;
        do{
            error=0;
            System.out.print("請輸入號碼: ");
            str = sc.next();
            String a = new String(str);
            
            for(int i=0;i<str.length();i++){
                if(a.charAt(i)<'0'||a.charAt(i)>'9') {
                    error+=1;;
                }
            }
            if(error>=1)
                System.out.println("輸入格式錯誤");
            else
                System.out.println("謝謝!");
        }
        while(error >= 1);
    }
}
import java.io.*;
import java.util.*;

public class Ch10_part2hw {
    public static void main(String[] args) {
        String str;
        boolean isFormatted;
        Scanner sc=new Scanner(System.in); 
        do {
            isFormatted = false;
            System.out.print("請輸入電子郵件 ");
            str = sc.next(); 
            if((str.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.]+[a-zA-Z0-9\\.]+")) && (str.charAt(str.length() - 1) != '.')) {
                System.out.print("輸入正確");
                isFormatted=true;
            }
            if(!isFormatted) { //不是整數
                System.out.println("電子郵件應該是XXX@XXX.XXX....");
            }
        } while (!isFormatted);
    }
}

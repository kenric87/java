//這程式主要是對於數字型別的判別
//個部分都通過之後，最終才能通過
//較需要注意的是conatins

import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        boolean isPWFormatted;
        boolean isDigit;
        boolean isLow;
        boolean isUp;
        boolean isSuecialz;

        do{
            isPWFormatted = false;
            isDigit = false;
            isLow = false;
            isUp = false;
            isSuecialz = false;

            System.out.print("enter your PW: ");
            str = sc.next();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if((!isDigit) && ((ch >= '0') && (ch <= '9')))
                    isDigit = true;
                if((!isLow) && ((ch >= 'a') && (ch <= 'z')))
                    isLow = true;
                if((!isUp) && (ch >= 'A') && (ch <= 'Z'))
                    isUp = true;
            }
            isSuecialz = (str.contains("$")) || (str.contains("@"));
            isPWFormatted = isDigit && isLow && isUp && isSuecialz;
            if(!isPWFormatted)
                System.out.println("wrong!!     need: digital, up, low, spe");
        }
        while(!isPWFormatted);
        System.out.println("right!");
    }
}

/*這是另外一種輸入數字判斷的方法
 * 可以發現，我們依舊可以使用boolean 作為判斷的指標
 * 而且速度似乎更快，因為他不用所有全部輸入都判斷完
 * 只要一遇到不合適的，直接break 即可
 * 可以參考學習
 */
import java.util.*;
public class point1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        boolean isInteger;

        do{
            isInteger = true;
            System.out.println("請輸入整數: ");
            str = sc.next();

            for (int i = 0; i < str.length(); i++){
                if((str.charAt(i) < '0') || (str.charAt(i) > '9')){
                    isInteger = false;
                    System.out.println("wrong, please integer");
                    break;
                }           
            }
        }
        while(!isInteger);
        System.out.println("right!!");
    }
}

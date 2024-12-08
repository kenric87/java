//自行設定密碼，並自己驗證
//這邊的理念很簡單，就是透過兩次輸入得到兩個字串
//並比較兩字串是否相同
import java.util.*;

public class point3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        String inputans;
        boolean isRight;

        do{
            isRight = true;
            System.out.println("enter question: ");
            password = sc.next();

            System.out.println("enter your answer: ");
            inputans = sc.next();

            if(inputans.matches(password))
                System.out.println("right!!");
            else{
                isRight = false;
                System.out.println("wrong!!");
            }
        }
        while(!isRight);
        
    }
    
}

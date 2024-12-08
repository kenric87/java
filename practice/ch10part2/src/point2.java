import java.util.*;

public class point2 {
    public static void main(String[] args) {
        String str;
        boolean isInteger;
        Scanner sc = new Scanner(System.in);//超重要，每次都會忘記

        do{
            isInteger = true;
            System.out.println("請輸入整數: ");
            str = sc.next();

            if(!str.matches("[0-9]+")){
                isInteger = false;
                System.out.println("WRONG!");
            }

        }
        while(!isInteger);
        System.out.println("right~~");
    }
    
}
/*
 * "[0-9]+"  多次整數
 */
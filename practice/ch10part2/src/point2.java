//這個程式主要是用matches來做有很多搭配的應用

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

            if(!str.matches("a[0-9a-zA-Z]a")){
                isInteger = false;
                System.out.println("WRONG!");
            }

        }
        while(!isInteger);
        System.out.println("right~~");
    }
    
}
/*
 * "[0-9]+"     多次整數
 * "hello"      單純某一個單字的，要全對
 * "ab*a"       *前面的要不要出現，出現幾次都可以，應該是屬於最寬鬆的一種了
 * "ab?a"       ?前的那個字可以出現0次、1次，不能超過一次
 * "ab+a"       +前面的那個字至少要出現一次，我覺得蠻好用的，在密碼形式規範下蠻有用的
 * "ab{2}a"     剛好{n}次
 * 
 * "a[bjl]a"    []內"其一"元素，出現一次
 * "a[0-9]a"    範圍，但也是一樣，只出現一次
 * "a[0-9][0-9]a"       可連續使用
 * "a[a-z][0-9]a"       也有英文須注意大小寫
 * "a[0-9a-zA-Z]a"      
 */
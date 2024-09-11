/**
 * gogo
 */
import java.util.Scanner; // Add this import statement
public class gogo {

    public static void main(String[] args) {
        System.err.println("hello world");
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入一個整數: ");
        x = sc.nextInt();
        System.out.println("你輸入的整數為: " + x);
    }
}
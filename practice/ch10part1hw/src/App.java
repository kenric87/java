import java.util.*;//重要前綴
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//我覺得重點是這個，要知道資料輸入如何使用
        String str;
        int error;

        do{
            error = 0;
            System.out.println("請輸入號碼: ");
            str = sc.next();

            for(int i = 0; i < str.length(); i++){
                if((str.charAt(i) < '0') || (str.charAt(i) > '9')){
                    //str.charAt要會使用，他會一次叫一個字串(str)中某一個位置的值
                    error += 1;
                }
            }

            if(error >= 1)
                System.err.println("錯!");
            else
                System.out.println("對了!");

        }
        while(error >= 1);


    }
}

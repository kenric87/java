// 大致組成
public class abc {//abc 為程式檔案名稱
    //part01
    public static void main(String[] args) {
        System.err.println("000");//列印

        //使用class1-2
        TA aa = new TA();
        aa.x = 4;
        aa.showX();
        //這後面就可以放:變數，或是要執行的子程式

        //call by reference //超重要3-2
        TB bb = new TB();
        bb.changeTA(aa, 0);//放入變數名稱

        //呼叫method2-2
        abc cc = new abc();
        cc.fun(0);

        //一次用很多個class
        TA [] manyAA = new TA[5];//後面的中括號要標上數字
        manyAA[0] = new TA();
        //簡單來說，就是new 要使用兩次，才能真正開始使用

    }
    void fun(int x) {//也可以在最外面之前裝method //2-1
    }
}
//可以在最外面裝class，AA為class名稱1-1
class TA {
    int x = 3;

    void showX() {
        System.out.println("x = " + x);
    }
}
//call by reference 3-1
//通常會需要兩個class
class TB {
    void changeTA(TA t, int j){ //裡面的動作才是真正開始放變數的地方
        //要記住，()裡面如果有放變數，要記得標上他的項目名稱，例如 TA，int
        t.x = j;
    }
}


//Example with an array:
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
//Example with a List:
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
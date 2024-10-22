//1.建構方法

class T1{
    int x, y;
    void showInfo(){
        System.out.println("x = " + x + ", y = " + y);
    }

    //預設的建構方法
    //可以有多個建構方法，通常以輸入參數的數量做區分
    //重點是要與class同名
    T1() {
        //這是不具參數的建構方法
        x = 10;
        y = 20;
    }
    T1(int x, int y) {
        //這是具參數的建構方法
        this.x = x;
        this.y = y;
    }
    T1(int x) {
        //建構方法的overloading
        this.x = x;
    }

    // 通常，若有建構參數
    // 記得要加上"不具參數"的建構方法
}

//this.x 與 this(x) 的妙用
class T2 {
    int x, y;
    T2(int x) {
        this.x = x;
    }
    T2(int x, int y) {
        this(x);//呼叫建構方法要放第一行
        this.y = y;
    }
    void showInfo(){
        System.out.println("x = " + x + ", y = " + y);
    }
}

//this(x) 也可以以多欺少
class T3{
    int x, y;
    T3(int x) {
        this(x, 50);
    }

    T3(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void showInfo(){
        System.out.println("x = " + x + ", y = " + y);
    }
}

class T4 {
    private int x1;
    int x2;
    protected int x3;
    public int x4;

    void showx1(){
        System.out.println("x1 = " + x1);
    }
    void showx2(){
        System.out.println("x2 = " + x2);
    }
    void setx1(int x1) {
        this.x1 = x1;
    }

}

public class App {
    public static void main(String[] args) {
        T1 a1 = new T1();
        a1.showInfo();
        T1 b1 = new T1(20, 30);
        //喔喔喔我懂了，所以說建構方法就是在這種
        // new T1()裡面要放上的新的東西
        //之前沒用，是因為系統已經自動加上不具參數的建構方法了
        //且該建構方法沒有執行任何的東西
        b1.showInfo();
        T1 c1 = new T1(30);
        c1.showInfo();
        T2 aT2 = new T2(10,20);
        aT2.showInfo();
        T3 aT3 = new T3(10, 500);
        aT3.showInfo();
        ////////////////////////
        //來試試private的力量
        
    }
}

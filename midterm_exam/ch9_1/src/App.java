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

class T5{
    //private 子程式
    private int x, y;
    public T5(int x){
        this.x = x;
    }
    public T5(int x, int y){
        this(x);//跨用的建構方法要放第一行
        this.y = y;
    }
    //因為x, y是private
    //所以需要一個public的方法用以修該他們
    public void setXY (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        //這邊分開寫是因為要能順利回傳 int
        return x;
    }
    public int getY(){
        //這邊分開寫是因為要能順利回傳 int
        return y;
    }
    public void showXY() {
        System.out.println("x = " + x + ", y = " + y);
    }
}
//static 共享成員變數
class T6 {
    private int x;
    private static int y;
    //在這邊是指，這個y 是大家的
    //一個地方改，所有地方就改
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
}
class T6_st{
    private int x;
    private static int y;
    
    public T6_st(int x, int y){
        //喔對了，就算是建構方法，也需要加上public
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(x, y) = (" + x + ", " + y + ")";
    }
}

///////////////////////////////////////
//是一些不太重要的 去看ch9_part1.java
class T7{
	public int x;
	public static int y;
	static {
		y=100;
	}
}

//4.static方法
class T8{
	public static void sayHello() {
		System.out.println("Hello");
	}
	
}

//5.final
class T9{
	public int x;
	public static final int y=200;
    //final 要先給值，因為之後不能再改
    //紀錄一下，static 跟final 並不是互相相反的性質，可以同時並存
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
        T4 a4  = new T4();
        // a4.x1 = 100; 這不能用，因為x1在T4中是private
        a4.x2 = 30;
        a4.showx2();
        a4.setx1(10);
        a4.showx1();

        T5 a5 = new T5(30);
        System.out.println(a5.getX());
        a5.setXY(20, 90);
        a5.showXY();
        a5.setXY(20,30);
        System.out.println(a5.getY());
        
        T6 a6 = new T6();
        a6.setX(20);
        a6.setY(200);
        System.out.println(a6.getX() + ", " + a6.getY());
        T6 a6y = new T6();
        a6y.setX(30);
        a6y.setY(300);
        System.out.println("a6y");
        System.out.println(a6y.getX() + ", " + a6y.getY());
        System.out.println("a6");
        System.out.println(a6.getX() + ", " + a6.getY());
        //因為y是共用的，所以改了的話，大家都會改

        T6_st a6st = new T6_st(20, 200);
        System.out.println("st = " + a6st);
        T6_st a6sty = new T6_st(30, 300);
        System.out.println("sty = " + a6sty);
        System.out.println("st = " + a6st.toString());
        //System.out.println("st = " + a6st);
        //System.out.println("st = " + a6st.toString());
        //這兩種寫法相同.toString會自動呼叫

        /*虽然可以显式调用 .toString()
        但 Java 在 print() 和 println() 方法中会自动调用它
        因此可以省略直接使用对象
        这是 Java 设计的简化机制之一。
        */



    }
}

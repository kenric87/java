//繼承
class Circle{
    //這邊的參數就不會用private
    //改用protected，這樣才可以繼承
    protected double x, y;
    protected double r;

    Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    Circle() {}//這是好習慣，要記得建立無參數的建構方法
    public void setCenter (double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setR (double r) {
        this.r = r;
    }
    public String toString() {
        return "圓心: (" + x + "," + y + "), 半徑: " + r;
    }
    //要記得toString下面的是return
}

class Cylinder extends Circle {
    private double h;   //可以用private是因為這邊不用再繼續繼承下去了
    Cylinder (double x, double y, double r, double h){
        super(x, y, r);
        //在 Java 中，super() 是用來呼叫父類別的建構方法
        this.h = h;
    }

}

public class App {
    public static void main(String[] args) {
        Cylinder cr = new Cylinder(1, 2, 3, 4);
        System.out.println(cr);
    }
}

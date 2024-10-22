//傳回成員物件
//副類別1
class Point{
    private double x, y;//因為座標想要以小數點形式呈現

    public double getX() {return x;}
    public void setX(double x){this.x = x;}
    //建構方法
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    //不具參數的建構方法
    public Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(Point p) {
        this.x = p.x;
        // this.x = p.getX(); 這兩個結果相同
        this.y = p.y;
        
    }
    //.toString
    public String toString(){
        return "(x, y) = (" + x + ", " + y + ")";
    }
}
//第二個副類別(重頭戲)會用到Point
class Circle {
    private Point p;//這是自創單位Point 從副類別1來的
    private double r;
    public double getR() {return r;}
    public Point getP(){return p;}//需要注意，這邊的單位是Point
    public Point gerNewP(){
        return new Point(p);//歐幹，這邊超重要
    }

    //建構方法
    public Circle(double x, double y, double r){
        this.p = new Point(x, y);
        this.r = r;
    }
    public Circle(){
        this(0, 0, 1);//這是剛剛上面的那個建構方法
    }
    public String toString(){
        return "圓心: " + p + ", 半徑: " + r;
    }


}

public class App {
    public static void main(String[] args) {
        Circle c1 = new Circle(3, 4, 5);
        System.out.println(c1.toString());
        System.out.println(c1);//印出來相同

        Point p1 = c1.getP();
        System.out.println(p1);

        p1.setX(20);
        System.out.println(p1);
        System.out.println(c1);
        //出大事，發現c1的直也被修改
        //失去[資料隱藏]特性

        //需要一個類似 生成額外的點的方法
        //不要讓既有的資料相依

        //新點測試
        Circle c2 = new Circle(20, 30, 40);
        System.out.println(c2);;
        Point p2 = c2.gerNewP();
        System.out.println(p2);
        p2.setX(100);;
        System.out.println(p2);
        System.out.println(c2);
    }
}

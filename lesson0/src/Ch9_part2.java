//<ch9_Part2>
//(二-6 傳回成員物件(Sec. 9-2-3))

//<副類別>
//1.第1個副類別
class Point {
    private double x, y;

    public double getX(){return x;}
    public void setX(double x) {this.x = x;}

    public Point(double x, double y){//建構方法
        this.x = x;
        this.y = y;
        
    }
    //[自行]加上[不具參數的建構方法]
    public Point(){
        x = 0;
        y = 0;
    }
    //8.補寫:新增一個[Point (p)]的建構方法
    public Point (Point p) {
        this.x = p.x;//<--同一個類別可以直接寫p.x，也可寫p.getX()
        this.y = p.y;
    }

    public String toString(){
        return "(x, y) = (" + x + ", " + y + ")";
    }

}

//2.第2個副類別
class Circle{
    //private double x, y;
    private Point p;
    private double r;

    public double getR() {return r;}
    public Point getP() {
        return p;   //return [物件名稱p]
    }
    //7.重寫getP()
    public Point getNewP() {
        return new Point(p);   //return [新物件Point(p)]
        //此時還缺[Point (p)]建構方法，所以需要補寫此建構方法
    }
    public Circle(double x, double y, double r) {
        this.p = new Point(x, y);   //生新物件，讓物件變數p指向此物件
        this.r = r;        
    }

    public Circle() {//[自行]加上[不具參數的建構方法]
        this(0, 0, 1);
    }

    public String toString() {
        return "圓心: " + p + ", 半徑: " + r;
    }
    
}
//-----------------------------------------
//<主類別>
public class Ch9_part2 {
    public static void main(String[] args) {
        //3.生Circle 物件
        Circle c = new Circle(3, 4, 5);
        System.out.println(c); //圓心: (x, y) = (3.0, 4.0), 半徑: 5.0

        //4.讓新的物件p1內容為Circle物件內的[Point P]
        Point p1 = c.getP();//6.問題:Point 物件名稱[p1] = 物件名稱[p]
        //[內容相依]，需要修改
        System.out.println(p1);//(x, y) = (3.0, 4.0)
        
        //5.嘗試修改p1的x值
        p1.setX(6);
        System.out.println(p1);//(x, y) = (6.0, 4.0)
        System.out.println(c);//圓心: (x, y) = (6.0, 4.0), 半徑: 5.0
        //此時發現c的x值也被修改了[失去[資料隱藏]特性]

        //9.再次嘗試:
        Point p2 = c.getNewP();//11.解法:Point 物件名稱[p1] = 新物件[new 
        System.out.println(p2);//(x, y) = (6.0, 4.0)

        //10.嘗試修改p2的x值
        p2.setX(7);
        System.out.println(p2);//(x, y) = (7.0, 4.0)
        System.out.println(c);//圓心: (x, y) = (6.0, 4.0), 半徑: 5.0

        //11.重點整理(傳回成員物件)
        /*
         * 1.條件:
         * (1)成員有[物件][如[Point p]]
         * (2)傳回成員[物件的值]給別的物件[如[Point p1 = c.getP()]]
         * 2.錯誤方法:
         * return 物件變數[如[return p]], 會有call by reference 的問題[內容相依]
         * 3.正確方法
         * (1)使用[return new 新物件][如[return new Point(p)]]
         * (2)增加一個建構方法，參數為物件[如[Point(Point p) {}]]
         */
    }
}

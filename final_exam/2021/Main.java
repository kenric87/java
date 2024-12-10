
interface ICC{
    boolean isLargerThan(double value);
}

class ShowByThreshold {
    double price;

    static void showLandsSmallerThan(double maxThreshold, ICC[] objs) {
        for (int i = 0; i < objs.length; i++) {
            if (objs[i].isLargerThan(59.5) == true) {
                System.out.println(objs[i]);
            }
        }
    }
}
    abstract class Land implements ICC{
        double r, side;
        abstract double area();
        public boolean isLargerThan(double value) {
            if(area() < 59.5) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    class Circle extends Land{
        double r;
        Circle(double r){
            this.r = r;
        }
        double area(){
            return r* r * 3.14 ;
        }
        public String toString(){
            return "半徑: " + r + ", 面積: " + area() + "的圓";
        }

    }

    class Square extends Land{
        double side;
        Square(double side){
            this.side = side;
        }
        double area(){
            return side * side;
        }

        public String toString(){
            return "邊長: " + side + ", 面積: " + area() + "的正方形";
        }
    }
    public class Main {
        public static void main(String[] args) {
            Circle c1 = new Circle(3.3);
            Circle c2 = new Circle(5.5);
            Square s1 = new Square(7.7);
            Square s2 = new Square(9.9);
            Land[] lands = {c1, c2, s1, s2};
            System.out.println("===所有土地資訊===");
            for (Land l : lands) {
                System.out.println(l);
            }
            System.out.println("===面積小於59.5的包含===");
            ShowByThreshold.showLandsSmallerThan(59.5, lands);
        }
    }
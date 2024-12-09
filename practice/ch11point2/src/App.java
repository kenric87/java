class Land {
    double getArea() {
        return 0;
        //但是不會真的用到return 0;
    }
}

class Circle extends Land {
    int r;
    Circle (int r) {
        this.r = r;
    }
    double getArea () {
        return r * r * 3.14;
    }
}

 class Square extends Land {
    int d;
    Square (int d) {
        this.d = d;
    }
    double getArea() {
        return d * d;
    }
 }

 class Calculator {
    double price;
    Calculator(double price) {
        this.price = price;
    }

    //原本的寫法是要個別計算
    //但因為兩者擁有同一個父類別
    //所以可以混而為之

    double CalcPrice(Land l) {
        return l.getArea() * price;
    }
 }
public class App {
    public static void main(String[] args) {
        Circle c = new Circle(1);
        Square s = new Square(1);
        Calculator cal = new Calculator(10);

        System.out.println("circle price = " + cal.CalcPrice(c));
        System.out.println("square price = " + cal.CalcPrice(s));
    }
}

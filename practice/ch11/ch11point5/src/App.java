//這是多型的改良版
//需要先參考point2 下半
//對應:Ch11_part3.java 下半部

class Land {
    double getArea() {
        return 0;
        //但是不會真的用到return 0;
    }
}

class Circle1 extends Land {
    int r;
    Circle1 (int r) {
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
    double CalcPrice(Land l) {
        return l.getArea() * price;
    }

    //新東西從這邊開始
    //計算所有土地的總價
    double CalcAllPrice1(Land[] ls) {
        double total = 0;
        for(Land k:ls) {
            total += CalcPrice(k);
        }
        return total;
    }

    //新語法... 
    //變長參數，要輸入幾個都沒問題
    double CalcAllPrice2(Land... ls){
        double total = 0;
        for(Land k:ls){
            total += CalcPrice(k);
        }
        return total;
    }

    //Object，Land 或 Integer 都可
    double CalcAllPrice3(double price, Object... obj) {
        double temp = 0;
        double total = 0;
        for(Object k:obj) {
            if(k instanceof Land) {
                temp = ((Land)k).getArea() * price;
                //(Land)k:要記得先轉一下型別
                total += temp;
            }
            if(k instanceof Integer) {
                //需要注意一下 instanceof 跟 Integer
                total += temp * ((Integer)k - 1);
                //會需要-1是因為前面肯定算過一次了
            }
        }
        return total;
    }

}
public class App {
    public static void main(String[] args) {
        Circle1 c = new Circle1(1);
        Square s = new Square(1);
        Calculator cal = new Calculator(100);

        System.out.println("circle price = " + cal.CalcPrice(c));
        System.out.println("square price = " + cal.CalcPrice(s) + "\n");

        //(1)使用陣列
        System.out.println(cal.CalcAllPrice1(new Land[]{c, s}));
        //(2)使用可變參數
        System.out.println(cal.CalcAllPrice2(c,s));
        //(3)使用Object
        System.out.println(cal.CalcAllPrice3(100, c, 10, s, 2));
    }
    
}

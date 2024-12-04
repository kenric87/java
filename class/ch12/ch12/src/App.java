// 接口 ICC
interface ICC {
    int compare(ICC i); // 進行比較
    boolean isLargerThan(double value); // 新增方法
}

// 功能類別 Sort
class Sort {
    static void bubbleSort(ICC[] objs) {
        for (int i = objs.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (objs[j].compare(objs[j + 1]) < 0) {
                    ICC temp = objs[j];
                    objs[j] = objs[j + 1];
                    objs[j + 1] = temp;
                }
            }
        }
    }
}

// 抽象類別 Land
abstract class Land implements ICC {
    abstract double area(); // 計算面積
    
    public int compare(ICC i) {
        Land l = (Land) i;
        return (int) (this.area() - l.area());
    }
    
    public boolean isLargerThan(double value) {
        return this.area() > value;
    }
}

// 圓形的子類別
class Circle extends Land {
    int r; // 半徑
    
    Circle(int r) {
        this.r = r;
    }
    
    double area() {
        return 3.14 * r * r;
    }
    
    public String toString() {
        return "半徑：" + r + ", 面積：" + area() + " 的圓";
    }
}

// 正方形的子類別
class Square extends Land {
    int side; // 邊長
    
    Square(int side) {
        this.side = side;
    }
    
    double area() {
        return side * side;
    }
    
    public String toString() {
        return "邊長：" + side + ", 面積：" + area() + " 的正方形";
    }
}

// 顯示小於閾值的類別
class ShowByThreshold {
    static void showLandsSmallerThan(double maxThreshold, ICC[] objs) {
        for (ICC obj : objs) {
            if (!obj.isLargerThan(maxThreshold)) {
                System.out.println(obj);
            }
        }
    }
}

// 主類別
public class App {
    public static void main(String[] args) {
        Land[] lands = {
            new Circle(5), // 面積約 78.5
            new Square(3), // 面積 9
            new Square(2), // 面積 4
            new Circle(4)  // 面積約 50.24
        };
        
        // A. 排序前列印
        System.out.println("排序前：");
        for (Land l : lands) {
            System.out.println(l);
        }
        
        // B. 呼叫排序方法
        Sort.bubbleSort(lands);
        
        // C. 排序後列印
        System.out.println("排序後：");
        for (Land l : lands) {
            System.out.println(l);
        }
        
        // D. 列印面積小於 59.5 的物件
        System.out.println("面積小於 59.5 的物件：");
        ShowByThreshold.showLandsSmallerThan(59.5, lands);
    }
}

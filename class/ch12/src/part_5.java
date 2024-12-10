// Part5 四.綜合演練2
//2. Sorting.java 
//(1) 介面 //ICanCompare
interface ICC { 
	int compare(ICC i); // 進行比較
    
}
//(2) 功能類別 (提供Sort排序功能的類別)
class Sort { 
	static void bubbleSort(ICC[] objs) { 		
		// 方法bubbleSort「參數」寫「介面ICC」
		// （參數「ICC[] objs」指向「實作ICC[]」的「物件名稱陣列」）

		// 以下為氣泡排序法 由大排到小
		for(int i = objs.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(objs[j].compare(objs[j + 1]) < 0) {
				// 意思就是:「if ( objs[j] < objs[j + 1] )」
				// 直接用「實作方法的compare()」，因為「實作類別」必須「實作此方法」
					ICC temp = objs[j];
					objs[j] = objs[j + 1];
					objs[j + 1] = temp;
				}
			}
		}
	}
}
// (3) 實作的類別
abstract class Land implements ICC { // 抽象類別, 也是父類別
	abstract double area(); // 計算面積
	public int compare(ICC i) { // 必須實作「int compare(ICC i)」
		Land l = (Land) i; // ICC型別轉型Land型別, 才可使用area()
		return (int)(this.area() - l.area()); // 自己面積 - 輸入面積 (比大小)
	}
}
// (4) 子1:圓形的土地
class Circle extends Land {
	int r; // 半徑（單位：公尺）
	
	Circle(int  r) { // 建構方法
		this.r = r;
	}
	
	double area() { // 多重定義的版本
		return 3.14 * r * r;
	}
	
	public String toString() {
		return "半徑：" + r + ",面積：" + area() + "的圓";
	}
}
// (5) 子2:正方形的土地
class Square extends Land {
	int side; // 邊長（單位：公尺）
	
	Square(int  side) { // 建構方法
		this.side = side;
	}
	
	double area() { // 多重定義的版本
	    return side * side;
	}
	
	public String toString() {
		return "邊長：" + side + ",面積：" + area() + "的正方形";
	}
}

public class part_5 {
	public static void main(String[] args) {
		// (6) 主類別
	    Land[] lands = {
	    	new Circle(5),
	    	new Square(3),
	    	new Square(2),
	    	new Circle(4)
	    };
	    
    	// A. 排序前，用for-each 印出所有lands[]陣列
    	for(Land l : lands) {
    		System.out.println(l);
    	}
    	
        // B. 呼叫方法
        Sort.bubbleSort(lands);
		// Hint：
		// （呼叫方法，帶入「物件名稱」）
        // (1) 用「功能類別Sort」直接使用「static方法bubbleSort()」，
    	// (2) 參數帶入「實作類別lands[]」生的(指向的)「物件C, S, S, C」

        // C. 排序後，再用for-each 印出所有lands[]陣列
        System.out.println("排序後...");    	
    	for(Land l : lands) {
    		System.out.println(l);
    	}
}
}


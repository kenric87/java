// 三、繼承注意事項 (Ch11-3) 

// 1. 子類別只能變鬆
class Parent1 { // 父類別
	public void Show() {
		System.out.println("我是父類別");
    }
}

class Child1 extends Parent1 { // 子類別
	// 程式
//	private void Show() {//<------overriding <------private變嚴格 不行
//		System.out.println("我是子類別");
//    }

}

// 複習第9章
class T4 {
	// 資料封裝-------------------------------------------------
	private   int x1; 	// (1) private		同類別 (最常用)
			  int x2;	// (2) 不加			同類別 + 同套件
	protected int x3;	// (3) protected	同類別 + 同套件 + 子類別
	public    int x4;	// (4) public		任何人 (不建議)
	// -------------------------------------------------------
}
// (最嚴) private < 不加 < protected < public (最鬆)

//------------------------------------------------------------------------------------

// 2. 同名成員 (11-3-2)
// (1) 成員獨立
// A. 父子類別
class Parent2 {
	int i = 10;
}

class Child2 extends Parent2 {
	int i = 20;
}

// ----> 接 「2.(1)B.」

// (2) 使用super存取父類別成員
// A. 父子類別
class Parent3 {
	int i = 10;
}

class Child3 extends Parent3 {
	int i = 20;
	public void Show() {
		System.out.println("c3.i: " + i); // c3.i: 20
	    System.out.println("super.i: " + super.i);  // super.i: 10	    
	}	
}

//----> 接 「2.(2)B.」

// (3) 使用super呼叫父類別的方法
class Parent4 {
	int i = 10;
	public void Show() {
		System.out.println("i: " + i); // i: 10   
	}	
}

class Child4 extends Parent4 {
	int i = 20;
	public void Show() {
		System.out.println("i: " + i); // i: 20  
		super.Show(); // 呼叫父類別的方法
	}	
}

// (4) static成員
// A. 父子類別
class Parent5 {
	static int i = 10;
	public void Show() {
		System.out.println("i: " + i);
	}	
}

class Child5 extends Parent5 {
	static int i = 20;
	public void Show() {
		System.out.println("c5.i: " + i);
	    System.out.println("super.i: " + super.i);  
	}	
}

//----> 接 「2.(4)B.」

// 3. 父類別final方法不能overriding (11-3-3)
class Parent6 {
	int i = 10;
	
	final void Show() { // final方法
		System.out.println("i: " + i);
	}	
}

class Child6 extends Parent6 {
	int i = 20;
	
//	void Show() {  // 不能overriding
//		System.out.println("i: " + i);
//	}	
}

// 4. 父類別建構方法 (11-3-4)

// (1) 建構方法不能被繼承

//A. 父子類別
class Parent7 {
	static int i = 10;
	
	Parent7 (int i) {
		this.i = i;
	}
}

class Child7 extends Parent7 {
	Child7 () {
		super(10);
	}
}

//----> 接 「4.(1)B.」

// (2) 父類別建構方法的自動呼叫
class Parent8 {	
	Parent8 () {
		System.out.println("我是父類別");
	}
}

class Child8 extends Parent8 {
	Child8 () {
		// super(); <--- 自動加入
		System.out.println("我是子類別");
	}
}
//重要::務必幫父類別建立一個無參數的建溝方法

//----> 接 「4.(2)B.」

// 四、隱藏的類別 (Ch11-4) 

// 1. Object類別 (隱藏的父類別)
// 如果無父親，由阿伯j領養
// 如果無父類別，自動繼承object類別

// class Object { } <--- XXXXXXXXXX

// (1) A 
// class Child9 { }

class Child9 extends Object { }
// (1) Object的toString()
// (2) Object的equals()

//----> 接 「四-1.(1)B.」

// 2. 代表基礎型別的類別

class Child10 extends Object {
	int i;
	
	void Show() {
		System.out.println("字串" + i); // <--- i自動轉字串 (封箱)		
	}
	
	int addTwoInt(Integer a, Integer b) { // Integer類別
		return a + b; // <--- a, b 自動轉int (拆箱)		
	}
	
	void Show2() {
		int i = addTwoInt(3, 8); // int 3, 8 呼叫時先自動轉Integer物件 (封箱)
		// @SuppressWarnings("deprecation")
		// int j = addTwoInt(new Integer(3), new Integer(8)); 
		// The constructor Integer(int) is deprecated (已棄用) since version 9 
		// 改用ValueOf方法
		int k = addTwoInt(Integer.valueOf(3), Integer.valueOf(8)); 
	}
}

// 五、多型的不定參數 (Ch11-5 綜合演練（多型參數改良版）)
// 先複習 Land1.jave (p11-24) (舊版 p11-29) (@11-2-5)

//<1.父>
class Land { // 代表任何形狀土地的父類別
	double getArea() { // 計算面積
		return 0;
 }
}

//<2.子1>
class Circle extends Land { // 圓形的土地
	int r; // 半徑（單位：公尺）

	Circle(int  r) { // 建構方法
		this.r = r;
	}

	double getArea() {  // 多重定義的版本
		return 3.14 * r * r;
	}
}

//<3.子2>
class Square extends Land { // 正方形的土地
	int side; // 邊長（單位：公尺）

	Square(int side) { // 建構方法
		this.side = side;
	}

	double getArea() {     // 多重定義的版本
		return side * side;
	}
}

//<4.功能類別>
class Calculator { // 計算器
	double price; // 每平方公尺的價格（元）

	Calculator(double price) { // 建構方法
		this.price = price;
	}
	
	// 一般方法：多重定義 (Overloading) 2個method
	double calculatePrice(Circle c) { 
		return c.getArea() * price; 
	}
	
	double calculatePrice(Square s) { 
		return s.getArea() * price; 
	}
	
	// 多形方法：只要定義1個method (前面2個method可刪除)

	double calculatePrice(Land l) { //<---------用多形(因為在參數中,「父物件變數」將會指向「子物件內容」)
		return l.getArea() * price; // 透過多形呼叫正確的 getArea() 方法
	}
		 
	// (1) 使用陣列
	// 程式
	double calculateAllPrices(Land []ls) {
		double total=0;
		for(Land l:ls) {
			total+=calculatePrice(l);
		}
		
		
		return total;
	}
	// (2-1) 使用可變參數(Variable arguments) (只有此參數)  // 不定參數
	// 程式
	double calculateAllPrices2(Land... ls) {
		double total=0;
		for(Land l:ls) {
			total+=calculatePrice(l);
		}
		
		
		return total;
	}
	//(2-2) 使用可變參數(Variable arguments) (參數 + 可變參數)
	// 程式
	double calculateAllPrices3(double price,Land... ls) {
		double total=0;
		for(Land l:ls) {
			//total+=calculatePrice(l);
			total+=l.getArea() * price;
		}
		
		
		return total;
	}
	// (3) 用Object + overloading
	// 程式	
	double calculateAllPrices4(double price,Object... objs) {
		double total=0;
		double tmp=0;
		for(Object j:objs) {
			if(j instanceof Land){
				tmp=((Land)j).getArea()*price;
				total+=tmp;
			}
			else if(j instanceof Integer) {
				total+=tmp*((Integer)j - 1);
				
			}
		}
		return total;
	}
}


//------------------------------------------------------------------------------------



// 四、隱藏的父類別 (Ch11-4)
// 白板畫圖講解


public class Ch11_part3 {

	public static void main(String[] args) {
		
		// 2.(1)
		// B. 主類別
	    Parent2 p2 = new Parent2(); 
	    Child2 c2 = new Child2(); 
	    System.out.println("p2.i: " + p2.i); //i=10
	    System.out.println("c2.i: " + c2.i);//i=20
	    
	    // ----> 接 「2.(2)」
	    
		// 2.(2)
		// B. 主類別
	    Child3 c3 = new Child3();
	    c3.Show(); 
	    Parent3 p3 = c3; // <--- ???
	    System.out.println("p3.i: " + p3.i); // 那個i? p3.i:10 用繼承的i
	    //編譯器看到 Parent3型別 的參照 則存取parent3類別的成員
	    
	    // ----> 接 「2.(3)」
	    
		// 2.(4)
		// B. 主類別
	    Child5 c5a = new Child5();
	    Child5 c5b = new Child5();
	    
	    c5a.Show(); //c5.i:20;super.i:10
	    
	    c5b.i = 80; 
	    c5a.Show(); //c5.i:80;super.i:10
	    
	    // ----> 接 「3.」
	    
		// 4.(1)
		// B. 主類別
	    // (a) 使用繼承的建構方法
	    // Child7 c7 = new Child7 (10); // <--- 使用繼承的建構方法
	    // (b) 
	    Child7 c7 = new Child7 ();
	    
	    // ----> 接 「4.(2)」
	    
		// 4.(2)
		// B. 主類別
	    Child8 c8 = new Child8 (); //我弒父類別 換行 我柿子類別
	    
	    // 重要：務必幫父類別定義一個無參數的建構方法
	    
	    // ----> 接 「四」
	    
	    // -------------------------------------
	    
	    // 四-1.(1)
		// B. 主類別
	    Child9 c9 = new Child9();
	    // (1) Object的toString()
	    System.out.println("c9.toString(): " + c9); // (hash code) c9.toString(): Child9@a09ee92
	    System.out.println("c9.toString(): " + c9);//一樣的
	    
	    
	    // (2) Object的equals()
	    // 比較是否同一個物件
	    Child9 d1 = new Child9();
	    Child9 d2 = new Child9();
	    Child9 d3 = d1;
	    
	    System.out.println("d1 equals d2: " + d1.equals(d2)); // false
	    System.out.println("d1 equals d3: " + d1.equals(d3)); // true
	    System.out.println("d3 equals d2: " + d3.equals(d2)); // false
	    
	    // ----> 接 「四-2」	    
	    
	    //------------------------------------------------------------------------
	    
	    // 五、使用
	    Circle c = new Circle(5); // 一塊圓形的地
	    Square s = new Square(5); // 一塊正方形的地
	    
	    Calculator ca = new Calculator(3000.0); // 每平方公尺3000元
	    
	    System.out.println("c 這塊地值" + ca.calculatePrice(c));
	    System.out.println("s 這塊地值" + ca.calculatePrice(s));	 
	    
	    // (1) 使用陣列
	     System.out.println( ca.calculateAllPrices(new Land[]{c,s}) );  // <---Land2
	    
	    // (2-1) 使用可變參數(Variable arguments) (只有此參數)  // 不定參數
	    System.out.println( ca.calculateAllPrices2(c,s) );  // <---Land3
	    
	    //(2-2) 使用可變參數(Variable arguments) (參數 + 可變參數)
	    System.out.println( ca.calculateAllPrices3(4000,c) ); // <---Land4
	    System.out.println( ca.calculateAllPrices3(4000,c,s) );  // <---Land4
	    
	    // (3) 用Object + overloading
	    System.out.println( ca.calculateAllPrices4(4000,s,2,c));  // <---Land5	    
	}
}
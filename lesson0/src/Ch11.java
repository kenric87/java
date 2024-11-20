// Ch11 繼承(Inheritance)_Part1, 2022.12.14 (學生版)

// 一、繼承基本概念 
// 1. 基本概念
// (1) 看看以下Circle_1類別
class Circle_1 {        // 圓
	//private double x, y; // 圓心
	//private double r;   // 半徑
	protected double x, y; // 圓心
	protected double r;   // 半徑
  
	Circle_1(double x, double y, double r) {  // Circle 的建構方法
		this.x = x;
		this.y = y;
		this.r = r;		
	}
	Circle_1() {  // Circle 的建構方法	
	}

	public void setCenter(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setRadius(double r) {
		this.r = r;
	}

	public String toString() {     // 顯示圓心與半徑
		return "圓心：(" + x + "," + y + "), 半徑：" + r;
	}
}

//(2) 假設要寫一個Cylinder類別
//Circle_1多一個高度h

//(2A) 方法1：複製貼上 + 修改 (Cylinder_1)
//複製「Circle_1」的內容 + 修改 (先複製貼上再修改)
// 程式here
class Cylinder_1 {        // 圓
	private double x, y; // 圓心
	private double r;   // 半徑
	private double h;  //高度
	Cylinder_1(double x, double y, double r) {  // Circle 的建構方法
		this.x = x;
		this.y = y;
		this.r = r;		
	}

	public void setCenter(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setRadius(double r) {
		this.r = r;
	}
	public void setHeight(double h) {
		this.h = h;
	}

	public String toString() {     // 顯示圓心與半徑
		return "圓心：(" + x + "," + y + "), 半徑：" + r;
	}
}
//(2B) 方法2： 使用繼承(Cylinder_2)
class Cylinder_2 extends Circle_1{
	private double h; 
	Cylinder_2(double x, double y, double r,double h) {  // Circle 的建構方法
		super(x,y,r);//呼叫父類別的建構方法，兩個選一個用
		// this.x = x;
		// this.y = y;
		// this.r = r;
		this.h = h;
	}

}

//(2C) --> 主程式(2C)

//2. UML類別圖 
//注意類別圖的箭頭(封閉箭頭+實線)


//3. protected 隱藏資訊
//protected 成員:子類別或同一個套件才能存取



//4. 多層繼承 

//二、多型(Polymorphism)
//1. 方法的三種狀況 (11-2-1~3)
//(1) 繼承, (2)overriding, (3)overloading
class Parent { // 父類別
	void Show() {
		System.out.println("我是父類別");
	}
}

//(1A) 繼承
//--- 程式here ---
class Child_1 extends Parent{		//子類別

}
//--> 接主程式(1B)

//(2A) overriding
//--- 程式here ---
class Child_2 extends Parent{		//子類別
	void Show() {
		System.out.println("我是子類別");
	}
}
//--> 接主程式(2B)

//(3A) overloading
//--- 程式here ---
class Child_3 extends Parent{		//子類別
	void Show(String str){
		System.out.println(str);
	}
}
//--> 接主程式(3B)

//(4A) Overriding + overloading
//--- 程式here ---
class Child_4 extends Parent{ //子類別
	void Show() {           //overriding
		System.out.println("我是子類別");
	}
	void Show(String str){  //overloading
		System.out.println(str);
	}
}
//--> 接主程式(4B)

//----------------------------------------------------

//二、3. 多型效用

//<1.父>
class Land{
	double getArea() {
		return 0;
	}
}
//<1>
class Circle extends Land{ // 圓形的土地
	int r; // 半徑（單位：公尺）

	Circle(int  r) { // 建構方法
		this.r = r;
	}

	double getArea() {  // 多重定義的版本
		return 3.14 * r * r;
	}
}

//<2>
class Square extends Land{ // 正方形的土地
	int side; // 邊長（單位：公尺）

	Square(int side) { // 建構方法
		this.side = side;
	}

	double getArea() {     // 多重定義的版本
		return side * side;
	}
}

//<功能類別>
class Calculator { // 計算器
	double price; // 每平方公尺的價格（元）

	Calculator(double price) { // 建構方法
		this.price = price;
	}
	
	// 一般方法：多重定義 (Overloading) 2個method
	/*double calculatePrice(Circle c) { 
		return c.getArea() * price; 
	}
	
	double calculatePrice(Square s) { 
		return s.getArea() * price; 
	}*/
	double calculatePrice(Land l) {
		return l.getArea()*price;
	}
}

public class Ch11 {
	public static void main(String[] args) {
		// 一、1.
		// (2C) 使用子類別建立物件
		//--- 程式here ---
		Cylinder_2 cr = new Cylinder_2(1,2,3,4);
		System.out.println(cr.toString());
		// -->接上方(p3)(2. UML類別圖)

		//--------------------------------------------------------
		
	    // 二、1.	
	    // (1B)
		//--- 程式here ---
		Parent p = new Parent();
		Child_1 c1 = new Child_1();
		p.Show();
		c1.Show();
		// --> 接上方(2A)
		
	    // (2B)
		//--- 程式here ---
		Child_2 c2 = new Child_2();
		c2.Show();
		// --> 接上方(3A)	
		

	    // (3B)
		//--- 程式here ---
		Child_3 c3 = new Child_3();
		c3.Show();
		c3.Show("鄵是");
		// --> 接上方(4A)		
		
	    // (4B)
		//--- 程式here ---
		Child_4 c4 = new Child_4();
		c4.Show();
		c4.Show("鄵是");
		// --> 接下方「二、2. 多形」
		
		//--------------------------------------------------------
		
	    // 二、2. 多形
	    // (1) 多形的定義
		//[父類別(上層類別)參照] 指向 [子類別(下層類別)物件]
	    // 狀況1
		p=c4;
		p.Show();
		p=c3;
		p.Show();
	    // 狀況2
		/*
	    // (2) 編譯錯誤
		p=c3;
		//p.show("測試");//<=====編譯錯誤(這樣不行)
		//只能呼叫自己有的方法，parent 本身沒有這種方法
	    // (3) 強制轉型 (不建議使用)
		p=c3;
		if(p instanceof Child_3) {
			Child_3 aa=(Child_3) p;
			aa.Show("測試");
			
		}
		// --> 接上方「二、3. 多型效用」
		
		//--------------------------------------------------------
	    // 二、3.
	    // (2) 使用
		Circle c =new Circle(5);
		Square s =new Square(5);
		Calculator ca =new Calculator(3000.0);
		System.out.println("C這塊地值"+ca.calculatePrice(c));
		System.out.println("C這塊地值"+ca.calculatePrice(s));
        */
	}
        
}
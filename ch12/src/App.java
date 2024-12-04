// Ch12 抽象類別(Abstract Class)與介面(Interface) (學生版)
// Part1
// 一、抽象類別 
   // 特性：可以被繼承,不能生物件

// 1. 在class前加上abstract:
abstract class Parent1 {
	double area() {return 0;}
}

// 2.抽象方法 
	// 特性：無區塊內容
	// 含有「抽象方法」的「抽象類別」 
abstract class Parent2 {
	abstract double area(); // <--- 無區塊內容
}

// (1)（舉例）Land類別不生物件，則可定義如下：
// 程式

// (2) (備註) 只含有抽象方法的類別 (不行) 
// class Parent3 {
// 	abstract double area();
// }
// (PS: 此部分與C++不同)

// 3. 繼承關係
abstract class Parent {
	abstract void show();
}

abstract class Child extends Parent { // 若沒有實作show(), class必須加上「abstract」
}

class Grandson extends Child { // 實作show()
	void show() {};
}

// Part2 二、介面
// 特性：具有某些「特性」（如「Flying」代表會飛）
// 類似「抽象類別」, 但是「實作介面」的類別必須「實作方法」
// 1. 父子類別與介面實作
interface Surfacing {
	double PI = 3.14159; 
	double area();
}

class Shape {
	protected double x,y;
	// 程式省略
}

class Circle1 extends Shape implements Surfacing { 
	private double r;
	// 實作後，所有介面的member會直接變成「static public final」的特性（如下）
	// static public final double PI = 3.14159; 
	// 可直接使用「物件名稱.PI」或「interface名稱.PI」存取 (如:Surfacing.PI)
	// 程式省略
	public double area() { // <--- 實作方法, 且必須宣告為「public」 (不可protected或private)
		return PI * r * r;
	}
}
//----> 接 (#A)

// Part3 三、介面繼承
// 1. 簡單介面繼承
interface P { // 父介面
	int i = 20; // 必須初始化
	void show();
}
interface C extends P { // 子介面
	int getI();
}

// public 
class SimpleI implements C { // <--- 問題:此處需要去掉public
	public void show() {}
	public int getI() {return i;}
}

//----> 接 (#C)

// (#D)	
// 2. 介面多重繼承
interface P1 { 
	int i = 20; 
	void show();
	void showI();
}

interface P2 { 
	int i = 40; 
	int j = 30; 
	void show();
	void showJ();
}

interface CC extends P1,P2 { 
	public void show(String s);
}

class NC implements CC {	
	public void show() {}
	public void showI() {}
	public void showJ() {}
	public void show(String s) {
		System.out.println(P1.i);
		System.out.println(P2.i);
	}
}





public class App {

	public static void main(String[] args) {
		// (#A) 
		Circle1 c = new Circle1();
		System.out.println(c.PI);         // <---用物件存取
		System.out.println(Surfacing.PI); // <---直接用interface名稱存取

        // (#C)
		SimpleI s = new SimpleI();
		// ----> 接 (#D)「2. 介面多重繼承」
    }
}


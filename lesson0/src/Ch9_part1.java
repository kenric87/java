//物件的建構與封裝
//副類別
//1.建構方法
class T1{
	int x,y;
	void showinfo() {
		System.out.println("x= "+x+" y= "+y);
		}
	
	//1.預設的建構方法
	//1.1.A定義建構方法
	//T1(){}	
	
	//2.自行定義建構方法
	//不具參數的建構方法
	T1(){
		x=10;
		y=20;
	}
	//具參數的建構方法
	T1(int x, int y){
		
		this.x=x;
		this.y=y;
	}
	//3.建構方法的overloading
	T1(int x){
		this.x=x;
	}
	/*
	 * 當我們為類別定義居要參數的建構方法十
	 * JAVA 編譯器 不會為我們建立不具參數的建構方法
	 * 這時最好自行為類別加上一個不具參數的建構方法
	 */
}
//4.this保留字
class T2{
	int x,y;
	T2(int x){
		this.x=x;
	}
	
	T2(int x, int y){
		//this.x=x;
		this(x);//呼叫建構方法 要放第一航
		this.y=y;
	}
}
//4.this保留字
class T3{
	int x,y;
	T3(int x){
		//this.x=x;
		this(x,0);
	}
	
	T3(int x, int y){
		//this.x=x;
		this.x=x;//呼叫建構方法 要放第一航
		this.y=y;
	}
}
//2.封裝與資訊隱藏

class T4{
	private int x1;   //同套件(最常用)
	int x2;			  //同類別 同套件
	protected int x3; //同類別 同套件 子類別
	public int x4;	  //任何人(不建議)
	
	void showx1(){System.out.println("x1= "+x1);}
	void setx1(int x1) {this.x1=x1;}
	
}

//2-4
class T5{
	private int x,y;
	public T5(int x){
		this.x=x;
	}
	
	public T5(int x, int y){
		//this.x=x;
		this.x=x;;//呼叫建構方法 要放第一航
		this.y=y;
	}
	public void setx(int x) {this.x=x;}
	public void sety(int y) {this.y=y;}
	public int getx(){return x;}
	public int gety(){return y;}
	public void showxy(){System.out.println("x= "+x+"y="+y);}
}

//2.6(sec 9-2-3下周帶課本)
//3.static 共享成員變數
//1.物件共享
//1-1
class T6{
	public int x;//<-------為了舉例
	public static int y;//<-------為了舉例
	
	T6(int x,int y){
		this.x=x;
		this.y=y;
	}
	//物件轉字串
	public String toString(){ //override 系統的tostring
		//return "Henlo worlda";
		return "(x,y)=("+x+","+y+")";//(x,y)=(100,40)
	}
}

//3.
class T7{
	public int x;
	public static int y;
	static {
		y=100;
	}
}

//4.static方法
class T8{
	public static void sayHello() {
		System.out.println("Hello");
	}
	
}

//5.final
class T9{
	public int x;
	public static final int y=200;//<-----final 要先給值
}

//final要先設定初值
//(1)如果是 static 要在 宣告同時 或是 static初始區塊 設充值

//主列別

public class Ch9_part1 {
    public static void main(String[] args) {
		//1.1.B使用建構方法
		T1 a1= new T1();//呼叫(預設的/自行定義)建構方法
		a1.showinfo();//(1)預設 x = 0, y = 0 (2)自訂 =10 y=10
		T1 b1= new T1(30,40);
		b1.showinfo();// x = 30, y = 40 
		T1 c1= new T1(30);
		c1.showinfo();// x = 30
		/////////////////////////////////////////////////////
		//2-2
		T4 a4= new T4();
		a4.x2=10;
		System.out.println("x2= "+a4.x2);	
		//a4.x1=100; 不同類別不能用
		a4.setx1(100);//要改成這樣
		//System.out.println("x1 = "+a4.x1);	錯的
		a4.showx1();
		
		//2.5
		T5 a5 =new T5(50,60);
		System.out.println("x = "+ a5.getx());
		System.out.println("y = "+ a5.gety());
		a5.setx(70);
		a5.sety(70);
		System.out.println("x = "+ a5.getx());
		System.out.println("y = "+ a5.gety());
		a5.showxy();

        ////////////////////////////////////////////////////
		T6 a6 =new T6(100,40);
		System.out.println("物件6:"+a6);//自動呼叫 .string()
		T6 b6 =new T6(200,50);
		System.out.println("物件6:"+b6);//自動呼叫 .string()
		T6 c6 =new T6(300,60);
		System.out.println("物件6:"+c6);//自動呼叫 .string()
		
		System.out.println("物件6:"+b6);
		System.out.println("物件6:"+a6);
		T6.y=500;
		System.out.println("物件6:"+a6);
		System.out.println("物件6:"+b6);
		System.out.println("物件6:"+c6);
		
		//4.2 直接呼叫
		T8.sayHello();
		T9 a9 = new T9();
		// T9.y=300;//final後 不能再改了
	}    
}

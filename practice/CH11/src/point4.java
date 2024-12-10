//這邊是繼承的進階用法
//對應: Ch11_part3.java
//子類別只能變鬆例如:private-->public
class Parent1 {
    protected int i = 10;
}
class Child1 extends Parent1{
    protected int i = 20;
    //無意外的話，相同的會被覆蓋
}

class Parent2 {
    protected int i = 10;
    public void show() {
        System.out.println(i);
    }
}
class Child2 extends Parent2 {
    protected int i = 20;
    public void show() {
        System.out.println(i);
        System.out.println("super.i = " + super.i);
        //利用super呼叫父類別
        //super 基本上即代表父類別
        System.out.println("\n呼叫父類別裡面的方法");
        super.show();
    }
}

//static
class Parent3 {
    protected static int i = 10;
    public void Show() {
        System.out.println("parent3.i = " + i);
    }
}
class Child3 extends Parent3 {
    protected static int i = 20;
    public void Show() {
        System.out.println("c3.i = " + i);
        super.Show();
    }
}

// 父類別final方法不能overriding
class Parent4 {
	int i = 10;
	final void Show() {
		System.out.println("i: " + i);
	}	
}
class Child4 extends Parent4 {
	int i = 20;
	void Show(int k) {  // 不能overriding
        //就是不能完全一樣，但如果有一點點不同像現在這樣就可以
		System.out.println(k);
	}	
}

//建構方法不能被繼承
//所以當需要的時候，使用super()
//剛剛測試了一下，發現要講更細
//無參數的建構方法可以直接繼承，甚至會自動寫在紫類別的無參數的建構方法中
//有參數的則不行 需要手動super 呼叫
class Parent5 {
    int i  = 10;
    Parent5() {
        System.out.println("this is parent5's build");
    }
}
class Child5 extends Parent5 {
    Child5() {
        // super();
        System.out.println("this is child5's build");
    }
}
//重要:務必幫父類別建立一個無參數的建溝方法
//因為當子類別需要無參數的建構方法時，會從父類別先呼叫
//因此如果沒有會發生錯誤



public class point4 {
    public static void main(String[] args) {
        Parent1 p1 = new Parent1();
        Child1 c1 = new Child1();
        System.out.println(p1.i);;
        System.out.println(c1.i);

        System.out.println("");
        Parent2 p2 = new Parent2();
        Child2 c2 = new Child2();
        c2.show();
        
        System.out.println("");
        Parent3 p3 = new Parent3();
        Child3 c3_1 = new Child3();
        Child3 c3_2 = new Child3();
        c3_1.Show();
        c3_2.Show();
        /*c3.i = 20
        parent3.i = 10 */

        System.out.println("");
        c3_1.i = 40;
        p3.i = 100;
        c3_1.Show();
        c3_2.Show();
        /* c3.i = 40
        parent3.i = 100*/

        System.out.println("");
        Parent5 p5 = new Parent5();
        Child5 c5 = new Child5();



    }
    
}

//子類別只能變鬆
class Parent1 {//父類別
    public void Show(){
        System.out.println("我是父類別");
    }
}

class Child1 extends Parent1{
    //子類別
    //overriding 下 private 變嚴格 這樣是不行的
    // private void Show(){
    //     System.out.println("我是子類別");
    // }
}

//複習 嚴格程度
class T4 {
    // private 
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

//多型(Polymorphism)
class Parent {
    public void Show () {
        System.out.println("I'm father.");
    }
}

class Child1 extends Parent {}

class Child2 extends Parent {
    public void Show() {
        System.out.println("I'm child2.");
        //遇到相同的時候，會被覆蓋
    }
}
public class point2 {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child1 c1 = new Child1();
        Child2 c2 = new Child2();

        p.Show();
        c1.Show();
        c2.Show();
    }
    
}

class CC {
    int a = 3;
    int b = 8;

    void showAB(){
        System.out.println("a = " + a + ", b = " + b);
    }
}

class DD {
    void swapAB(CC c){
        int x;
        x = c.a;
        c.a = c.b;
        c.b = x;

    }

}

public class Ch8_part2hw {
    public static void main(String[] args) {
        CC c1 = new CC();
        DD d1 = new DD();

        c1.showAB();
        d1.swapAB(c1);
        c1.showAB();
    }
    
}

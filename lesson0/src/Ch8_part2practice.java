// 先複習
class Iccard {
    long id;
    int money;

    void showInfo(){
        System.out.println("ID = "+id);
        System.out.println("money = "+money);        
    }
    void addMoney(int money){
        this.money += money;
        System.out.println("加值" + money + "元成功");
    }
    Boolean isGoodAdding (int money){
        if((money > 0)&&((this.money + money) <= 10000)){
            this.money += money;
            return true;
        }
        return false;
    } 
}
class showTime {
    int hour, min, sec;
    
    void showTime(){
        System.out.println("時間是" + hour + "點" + min + "分");
    }
    void reset(){
        hour = 0;
        min = 0;
        sec = 0;
    }
}
public class Ch8_part2practice {
    public static void main(String[] args) {
        System.out.println("Hello Wlold");
        Iccard test1 = new Iccard();
        Ch8_part2practice cc = new Ch8_part2practice();
        int i = 7;
        System.out.println("i = " + i);
        cc.fun(i);
        System.out.println("i = " + i);

        //call by reference
        TA a = new TA();
        TB b = new TB();
        a.showx();
        b.changeTA(a, 9);
        a.showx();//!!最終X的值改變

        TT a1 = new TT();
        String [] kk = {"AA", "BB", "CC"};
        a1.showAllstring(kk);
        a1.showAllstring(new String[] {"DD", "EE", "FF"}); 
        //這就是匿名陣列拉，可以直接在()內寫一個新的

        RR1 a2 = new RR1();
        System.out.println(a2.power(2, 3));
        
    }
    void fun(int x){
        System.out.println("x = " + x);
        x++;
        System.out.println("x = " + x);
    }
}
class TA{
    int x = 3;

    void showx(){
        System.out.println("x = " + x);
    }
}
class TB{
    void changeTA(TA t, int j){ //超重要的 call by refence ，TA 是放在TB的void裡面
        t.x = j;
    }
}
class TT{
    void showAllstring (String [] strss){
        for (String k: strss){
            System.out.println(k);
        }
    }
}
class RR1 {
    long power (int x, int y) {
        if (y <= 0)
            return 1;
        return x * power(x, y-1);
    }
}
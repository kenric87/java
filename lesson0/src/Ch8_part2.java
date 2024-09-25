//CH8 Part 2
//0-1 複習
class IcCard {
    long id;
    int money;
    
    void showInfo(){
        System.out.println("ID " + id);
        System.out.println("money " + money);
    }

    void addMoney(int value){
        money += value;
        System.out.println("加值" + value + "元成功");
    }
    
    //4. this.成員變數(當變數名稱相同)(有時可以增加意義及辨識度)(感覺很搞，但其實沒有)
    void addMoney2(int money){
        this.money += money;//此時，此money非彼money
        System.out.println("加值" + money + "元成功");
    }

    Boolean isGoodAdding (int value){
        if((value>0)&&((money + value)<=10000)){
            money += value;
            return true;
        }
        return false;
    }
}

class Time{
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

public class Ch8_part2 {
    public static void main(String[] args) {
        System.out.println("Hello world"); //測試
        //1. 物件回收
        // 將不需要的物件回收
        // 參照計數(Reference count)
        //(1)回收三種狀況
        //A.強迫釋放參照(自行歸還)

        IcCard test1 = new IcCard();
        test1 = null;

        //B.將參照變數指向別的物件
        IcCard test2 = new IcCard();
        IcCard test3 = new IcCard();
        test3 = test2;

        //C.參照變數離開有效範圍
        /*e.g.
        public void fun(){
            IcCard test4 = new IcCard();
        }
         */

         //(2)回收時機
         //系統先記錄，等待或有空再回收
        
        //------------------------------------
        //2.參數的傳遞
        //2-1. Call by value
        //2-1-B
        Ch8_part2 cc = new Ch8_part2();//<--奇怪寫法，適應
        int i = 7;
        System.out.println("i = " + i);
        cc.fun(i); // 必須使用物件呼叫 method
        System.out.println("i = " + i);//i = 7,i值不變

        //2-2 Call by reference(重要，必考)
        //2-2-B
        TA a = new TA();
        TB b = new TB();

        a.showX();  //x = 3
        b.changeTA(a, 9);
        a.showX();  //x = 9, x值改變

        //3.變數有效範圍(Scope)
        int xx = 1;
        {
            int yy = 2;
            {
                int zz = 3;
                //int yy = 11;//<--不行，內圈不能改外圈
            }
            int zz = 4;
        }
        int yy = 5;
        int zz = 6;

        //(1)[內層區域]可以看到[外層區域]的變數
        //(2)[內層區域]不能宣告[外層區域]同名變數
        //(3)離開[內層區域]後，[外層區域]可以宣告[失效的]同名變數
        //(4)[同層區域]的變數名稱不能重複
        //(5)區域變數(方法內的變數)與外部變數隔離
        //(6)類別內的[成員變數位置]與[執行順序]無關
        //------------------------------------------------------------------

        //5.匿名陣列
        //5-2
        TT a1 = new TT();
        String[] ss = {"AA", "BB", "CC"};
        a1.showAllString(ss);

        a1.showAllString(new String[] {"AA", "BB", "CC"});//不用宣告陣列，唯一目標，節省記憶體





    }
    //2-1-A
    void fun(int x) {
        System.out.println("x = " + x);//x = 7
        x++;
        System.out.println("x = " + x);//x = 8
    }
    
}

//2-2-A
class TA {
    int x = 3;

    void showX() {
        System.out.println("x = " + x);
    }
}

class TB {
    void changeTA(TA t, int j){ //call by reference
        t.x = j;

    }
}

//5-1
class TT {
    void showAllString(String[] strs) {
        for(String s: strs) {
            System.out.println(s);
        }
    }
}

//6.遞迴
//計算次方
//(1)類別

//A.  一般方法
class RR1 {
    long power (int x, int y) {
        if (y <= 0)
            return 1;
        return x * power(x, y-1);
    }
}
//B.分而治之
class RR2 {
    long power (int x, int y) {
        if (y <= 0)
            return 1;
        if (y % 2 == 0)
            return power(x, y/2) * power(x, y/2);
        else //<--可以不用寫
            return x * power(x, y/2) * power(x, y/2);
    }
}

//(2)使用
//在main()中，物件名稱.power(2, 8);

//7.Overloading
class GG {
    int Area (int w, int h){
        return w * h;
    }
    int Area (int t, int l, int b, int r){
        return (r - l) * (b - t);
    }
}

// 下周要小考(CH8)
//記得看錄影最後 常見的三種call by reference 方法
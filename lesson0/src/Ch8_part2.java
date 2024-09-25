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

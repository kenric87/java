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


public class ch8hw {
    public static void main(String[] args) {
        Time [] manyTimes = new Time[3];

        for(int ff = 0; ff < manyTimes.length; ff++){
            manyTimes[ff] = new Time();
            manyTimes[ff].hour = ff+3;
            manyTimes[ff].min = ff+4;
            manyTimes[ff].min = ff+5;
        }

        for (Time f: manyTimes){
            f.showTime();
            f.reset();
        }
        for (Time g: manyTimes){
            g.showTime();
        }
    }
    
}

class Time{
    private int hour, min, sec;
    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    public int showH() {return hour;}
    public int showM() {return min;}
    public int showS() {return sec;}
    public void setH(int hour) {this.hour = hour;}
    public void setM(int min) {this.min = min;}
    public void setS(int sec) {this.sec = sec;}
    public void setTime (int hour, int min, int sec){
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    public Time (Time t) {
        //不要搞錯，public 後面就直接是Time了
        this.hour = t.hour;
        this.min = t.min;
        this.sec = t.sec;
    }
    public static int getTimeDiff(Time c1, Time c2){
        //重要，原來static 可以這樣用
        int h = c1.hour - c2.hour;
        int m = c1.min - c2.min;
        int s = c1.sec - c2.sec;
        int diff = 3600*h + 60*m + s;
        if (diff >= 0){
            return diff;
        }
        return -diff;
    }
    public String toString() {
        return "時間是" + hour + "點" + min + "分" +  sec + "秒";
    }
}
class TimeManager{
    public void showTime (Time t){
        System.out.println("時間是" + t.showH() + "點" + t.showM() + "分" +  t.showS() + "秒");
    }
    public void reset(Time t){
        t.setH(0);
        t.setM(0);
        t.setS(0);
    }
}
class SmartPhone{
    private Time time;
    private int year, month, day;
    public SmartPhone (int year, int month, int day, int hour, int min, int sec){
        this.time  = new Time(hour, min, sec);//第一行需要特別注意一下
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Time getSameTime(){
        return new Time(time);
    }
    public String toString(){
        return "日期是" + year + "年" + month + "月" + day + "日, " + time;
    }
}

public class App {
    public static void main(String[] args) {
        Time clock1 = new Time(11, 22, 33);
        Time clock2 = new Time(22, 33, 44);
        TimeManager tm = new TimeManager();
        tm.showTime(clock1);
        tm.showTime(clock2);
        System.out.println("時間相隔" + Time.getTimeDiff(clock1, clock2) + "秒");
        tm.reset(clock1);
        tm.showTime(clock1);
        SmartPhone sp = new SmartPhone(2022, 11, 13, 14, 50, 40);
        System.err.println(sp);
        Time tt = sp.getSameTime();
        // System.out.println(tt);  //時間是14時50分40秒
        tt.setTime(15, 16, 17);
        System.out.println(tt);
        System.out.println(sp);

    }
}

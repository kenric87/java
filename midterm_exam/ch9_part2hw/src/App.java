class Date{
    private int year, month, day;

    public void setDate (int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(Date d) {
        this.year = d.year;
        this.month = d.month;
        this.day = d.day;
    }

    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

}
class Watch{
    private Date d;
    private int hour, min, sec;

    public Watch (int year, int month, int day, int hour, int min, int sec) {
        this.d = new Date(year, month, day);
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    public Date getNewDate() {
        return new Date(d);
    }
    public String toString() {
        return d + "" + hour + "時" + min + "分" + sec + "秒";
    }

}

public class App {
    public static void main(String[] args) {
        Watch w = new Watch(2019, 11, 6, 15, 20, 30);
        System.out.println(w);
        Date d = w.getNewDate();
        d.setDate(2022, 11, 9);
        System.out.println(d);
        System.out.println(w);

    }
}

class Date{    
    private int year, month, day;
    
    public int getYear() {
        return year;
    }    
    
    public int getMonth() {
        return month;
    }
        
    public int getDay() {
        return day;
    }    
    
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public Date() {
        year = 0;
        month = 0;
        day = 0;
    }
    
    public Date(Date d) {
        this.year = d.year;
        this.month = d.month;
        this.day = day;
    }
    
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
    
}

class Watch{
    private Date d;
    private int hour, min, sec;
    
    public int getHour() {
        return hour;
    }
    
    public int getMin() {
        return min;
    }
    
    public int getSec() {
        return sec;
    }
    
    public Date getD() {
        return d;
    }
    
    public Date getNewDate() {
        return new Date(d);
    }
    
    public Watch(int year, int month, int day, int hour, int min, int sec) {
        this.d = new Date(year, month, day);
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    
    public Watch() {
        this(0, 0, 0, 0, 0, 0);
    }
    
    public String toString() {
        return d.getYear() + "年" + d.getMonth() + "月" + d.getDay() + "日" + hour + "點" +  min + "分" + sec + "秒";
    }
}
public class Ch9_part2hw {
    public static void main(String[] args) {
        Watch w = new Watch(2019, 11, 6, 15, 20, 30);
        System.out.println(w);
        Date d = w.getNewDate();
        d.setDate(2022, 11, 9);
        System.out.println(d);
        System.out.println(w);
    }
}

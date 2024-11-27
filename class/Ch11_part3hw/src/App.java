class person{
    protected String name;
    protected int bday;
}
class teacher extends person{
    private String subject;
    teacher(String name, int bday,String subject) {
        this.name=name;
        this.bday=bday;
        this.subject=subject;
    }
    public String toString() {  
        return "名字: "+name+" 生日: "+bday+" 教授科目:"+subject;
    }
    public void showinfo(teacher s){
        System.out.println(s.toString());    
    }
}
class student extends person{
    private String number1;
    private int grade;
    student(String name, int bday,String number1,int grade) {
        this.name=name;
        this.bday=bday;
        this.name=name;
        this.number1=number1;
        this.grade=grade;
    }
    public String toString() {
        return "名字: "+name+" 生日: "+bday+" 學號: "+number1+" 年級: "+grade;
    }
    public void showinfo(student s){
        System.out.println(s.toString());    
    }
}
//新的
class Show{
    public void showAllInfo(person... ps){
        for(person p:ps){
            System.out.println(p.toString());
        }
    }

}

public class App {
    public static void main(String[] args) {
        teacher t1= new teacher("王先生",820605,"數學");
        teacher t2= new teacher("陳小姐",990605,"英文");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        t1.showinfo(t1);
        t2.showinfo(t2);
        student s1= new student("吳同學",920605,"b1021108",3);
        student s2= new student("張同學",910605,"b1021169",9);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        s1.showinfo(s1);
        s1.showinfo(s2);


        //新的
        System.out.println("-------------------這是分隔線-------------------");
        Show ss = new Show();
        ss.showAllInfo(t1, t2, s1, s2);
        System.out.println("-------------------再試一次!-------------------");
        ss.showAllInfo(t1, s1);
    }
}
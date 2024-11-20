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
public class App {
    public static void main(String[] args) {
        teacher t1= new teacher("葉",820605,"羅社");
        teacher t2= new teacher("ye",700625,"邏輯設計實驗");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        t1.showinfo(t1);
        t2.showinfo(t2);
        student s1= new student("王凱立",910807,"b1021210",4);
        student s2= new student("王先生",910605,"b1021169",12);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        s1.showinfo(s1);
        s1.showinfo(s2);
    }
}
//這其實也是屬於多型的應用
//對應:Ch11_hw.java

class Person {
    protected String name;
    protected int birth;
    //先把大家都有的列出來
}

class Teacher extends Person {
    private String subject;
    public Teacher (String name, int birth, String subject) {
        this.name = name;
        this.birth = birth;
        this.subject = subject;
    }
    public String toString() {
        return "姓名: " + name + ", 生日: " + birth + ", subject: " + subject;
    }
    public void ShowInfo(Teacher t) {
        System.out.println(t);
    }
}

class Student extends Person {
    private String number;
    private int grade;

    public Student(String name, int birth, String number, int grade) {
        this.name = name;
        this.birth = birth;
        this.number = number;
        this.grade = grade;
    }

    public String toString() {
        return "姓名: " + name + ", 生日: " + birth + ", 學號: " + number + ", 年級: " + grade;
    }

    public void ShowInfo(Student s) {
        System.out.println(s);
    }
}
public class point3 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("黎明副", 19770206, "線性代數");
        Teacher t2 = new Teacher("黃志樂", 1234, "電磁學");
        Student s1 = new Student("禮樂林", 20020514, "B1021144", 4);
        Student s2 = new Student("王凱俐", 20020807, "B1021210", 1);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(s1);
        System.out.println(s2);

        t1.ShowInfo(t1);


    }
    
}

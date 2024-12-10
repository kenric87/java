import java.util.Scanner;
//1.健康檢查
interface WeightControl{
    boolean isOverWeight(double value);
    //value 為超過標準體重的倍率
}
class Healthy{
    static void listOverWeight(WeightControl[] objs){
        //(1)列出超重人員
        for(int i=0;i< objs.length;i++){
            if (objs[i].isOverWeight(1.1)==true) {
                System.out.println(objs[i]);
            }
        }
    }
}
//(2) 抽象類別Person 實作 WeightControl
// 抽象方法 stdWeight() 方法 isOverWeight()
abstract class Person implements WeightControl{
    double height,weight;
    abstract double stdWeight();
    public boolean isOverWeight(double value){

        if(this.weight>stdWeight()*value) return true;
        else return false;
    }

}
 class Men extends Person{
    Men(double height, double weight){
        this.height=height;
        this.weight=weight;
    }
    //(3)
    public double weight(){return weight;}
    double stdWeight(){return (height-80)*0.7;};
    public String toString(){return "性別: 男, 身高:"+height+", 體重:"+weight()+", 標準體重:"+stdWeight();}
}
 class Women extends Person{
    Women(double height, double weight){
        this.height=height;
        this.weight=weight;
    }
    //(4)
    public double weight(){return weight;}
    double stdWeight(){return (height-70)*0.6;};
    public String toString(){return "性別: 女, 身高:"+height+",體重:"+weight()+", 標準體重:"+stdWeight();}
}
public class Main {
    public static void main(String[] args) {
        Men m1 =new Men(171.5,65);
        Men m2 =new Men(175,90.5);
        Women w1 =new Women(160.5,50);
        Women w2 =new Women(165,70.5);
        Person[] persons ={m1,m2,w1,w2};
        System.out.println("===所有人員資訊===");
        //(5)
        for (Person P : persons){
            System.out.println(P);
        }

        System.out.println("===體重過重的人員包含===");
        //(6)
        Healthy.listOverWeight(persons);
        //2.密碼格式
        Scanner sc =new Scanner(System.in);
        String str;
        boolean isPWFormatted;
        boolean isDigit;
        boolean isAalphabet;
        boolean isBlank;
        boolean isNumberBeginning;
        do{
            isPWFormatted = false;
            isDigit = false;
            isAalphabet = false;
            isBlank = false;
            isNumberBeginning = false;

            System.out.print("請輸入密碼: ");
            str = sc.nextLine();
            //(7)程式
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!isNumberBeginning && i == 0 && (ch >= '0' && ch <= '9')) {
                    isNumberBeginning = true;
                }
                if (!isDigit && (ch >= '0' && ch <= '9')) {
                    isDigit = true;
                }
                if(!isAalphabet && ((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z'))){
                    isAalphabet=true;
                }
                if (!isBlank && ch == ' ')
                    isBlank = true;
            }
            if (isNumberBeginning) System.out.println("密碼不能數字開頭");
            if (isBlank) System.out.println("密碼不能含空白");
            if (!isDigit) System.out.println("密碼應該包含數字");

            isPWFormatted=isDigit&&isAalphabet&&!isNumberBeginning&&!isBlank;
            if(!isPWFormatted) System.out.println("請再輸入一遍");
            else System.out.println("密碼格式正確");
        }while(!isPWFormatted);
    }
}
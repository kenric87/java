//類別與物件
//1.定義類別
class IcCard {
    //3.成員變數
    long id;
    int money;

    //5.方法1(Method)(行為Behavior)(Function in C/C++)
    void showInfo(){
        System.out.println("id = " + id);
        System.out.println("money = " + money);
    }

    //7.方法2
    void addMoney (int value) {
        money += value;
        System.out.println("加值" + value + "元成功!");
    }
    //9.方法3
    Boolean isGoodAdding (int value){
        if ((value > 0) && ((money + value) <= 10000)){
            money += value;
            return true;
        }
        return false;
    }

}


public class ch8 {
    //part01
    public static void main(String[] args) {
        //2.建立物件
        IcCard myCard;  //用[類別]宣告[物件名稱]
        int i;  //相當於用[型別] 宣告[變數名稱]

        myCard = new IcCard(); //用[類別]生[物件]，並讓[物件名稱]myCard 指向此物件
        IcCard hisCard;
        hisCard = new IcCard();

        IcCard herCard = new IcCard();

        //4.使用成員變數
        myCard.id = 123456;
        myCard.money = 1000;

        hisCard.id = 123457;
        hisCard.money = 2000;

        herCard.id = 123458;
        herCard.money = 3000;

        System.out.println("myCrad.id = " + myCard.id); //物件名稱.成員名稱
        System.out.println("myCrad.money = " + myCard.money);

        System.out.println("hisCrad.id = " + hisCard.id); //物件名稱.成員名稱
        System.out.println("hisCrad.money = " + hisCard.money);

        //6.使用方法1
        myCard.showInfo();
        hisCard.showInfo();
        herCard.showInfo();

        //8.使用方法2
        myCard.addMoney(500);
        myCard.showInfo();

        //10.使用方法3
        myCard.isGoodAdding(9000);//直接使用
        System.out.println(myCard.isGoodAdding(9000));//印出ture or false
        System.out.println(myCard.isGoodAdding(9000)? "成功" : "失敗");//印出成功 or 失敗
        System.out.println("加值9000元" + (myCard.isGoodAdding(9000)? "成功" : "失敗"));//印出成功 or 失敗
        myCard.showInfo();

        //11.參照
        IcCard aCard, bCard, cCard;
        aCard = new IcCard();
        bCard = new IcCard();
        cCard = bCard; //cCard 指向同一個物件

        //物件的[==]為[參照值]的比較
        System.out.println("aCard == bCard: " + (aCard == bCard)); //false
        System.out.println("bCard == cCard: " + (bCard == cCard)); //ture

        //12.物件陣列
        int [] s = new int [3]; //生int陣列
        IcCard [] manyCards = new IcCard[3];//生IcCard[物件名稱]陣列//並非生[物件]
        manyCards[0] = new IcCard();
        manyCards[0].id = 100;
        manyCards[0].money = 200;

        for (int j = 0; j < manyCards.length; j++){
        manyCards[j] = new IcCard();
        manyCards[j].id = 100 + j;
        manyCards[j].money = 200;
        }

        for(IcCard c: manyCards){       //使用for-each
            c.showInfo();
        }

    }
    
}

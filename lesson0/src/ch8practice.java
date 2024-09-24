class IcCard{
    long id;
    int money;

    void showInfo(){
        System.out.println("id = " + id);
        System.out.println("money = " + money);
    }
    void addMoney (int value){
        money += value;
        System.out.println("加值" + value + "元成功");
    }
    boolean isGoodAdding (int value){
        if((value > 0) && ((money + value) <= 10000)){
            money += value;
            return true;
        }
        return false;
    }

     
}

public class ch8practice {
    public static void main(String[] args) {
        IcCard myCard = new IcCard();
        IcCard hisCard = new IcCard();
        IcCard heCard = new IcCard();

        myCard.id = 123546;
        myCard.money = 1000;

        hisCard.id = 123457;
        hisCard.money = 2000;

        heCard.id = 123458;
        heCard.money = 3000;

        System.out.println("myCard.id = " + myCard.id);
        System.out.println("hisCard.money = " + hisCard.money);

        myCard.showInfo();
        hisCard.showInfo();
        heCard.showInfo();

        myCard.addMoney(500);
        myCard.showInfo();

        myCard.isGoodAdding(-1);
        System.out.println(myCard.isGoodAdding(-1));
        System.out.println((myCard.isGoodAdding(-1)) ? "成功" : "失敗");
        System.out.println("加值-1元" + ((myCard.isGoodAdding(-1)) ? "成功" : "失敗"));
        
        IcCard aCard, bCard, cCard;
        aCard = new IcCard();
        bCard = new IcCard();
        cCard = bCard;





    
    
    }

}

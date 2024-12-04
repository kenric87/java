// Part4 四.綜合演練1
// 1. Stopwatch.java
//要會畫這類型的圖，大概知道
//期末考會考
//!!!!下禮拜期末考，考10.11.12章
// (1) 介面
interface TimesUp {
	void notifyMe();
}
// (2) 功能類別 (提供虛擬碼表的類別)
class Timer {
	static void startTimer(int seconds, TimesUp obj) { 
		// 方法startTimer「參數」寫「介面TimesUp」
		// （參數「TimesUp obj」指向「實作TimesUp」的「物件名稱」）
		
		// 開始計時
		for (int i = 0; i < seconds; i++); // <---- 什麼都不做
		obj.notifyMe();  
		// 直接用「實作方法的notifyMe()」，因為「實作類別」必須「實作此方法」
	}
}

// (3) 實作的類別
class watchUser implements TimesUp {
	public void notifyMe() {
		System.out.println("時間到");		
	}	
}

public class part_4 {
	public static void main(String[] args) {
		// (4) 主類別
		watchUser w = new watchUser();
		Timer.startTimer(1000, w);
		// Hint：
		// （呼叫方法，帶入「物件名稱」）
		// (1) 用「功能類別Timer」直接使用「static方法startTimer()」，
		// (2) 參數帶入「實作類別」生的「物件w」
    }
}


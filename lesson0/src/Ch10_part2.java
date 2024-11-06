import java.io.*;
import java.util.*;

public class Ch10_part2 {
	public static void main(String[] args) {
		
		// (三) StringBuffer與StringBuilder類別 (字串內容可改變) (10-3)
		// 1. StringBuffer類別 (10-3-1)
		
		String aa = "這是一個測試字串"; 
		StringBuffer bb = new StringBuffer("這是一個測試字串");
		System.out.println(bb);
		
		// (1) append()
		System.out.println(bb.append(20));//這是一個測試字串20
		System.out.println(bb.append("字串內容已經變了"));//這是一個測試字串20字串內容已經變了
		System.out.println(bb);//這是一個測試字串20字串內容已經變了

		// (2) insert()
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa);
		System.out.println(bb); //這是一個測試字串(0這1是2一3個4測5試6字7串)
		System.out.println(bb.insert(0, 38)); //38這是一個測試字串(0:3 1:82這3是4一5個6測7試8字9串)
		System.out.println(bb.insert(3, "東西")); //38這東西是一個測試字串(0:3 1:82這3東4西5是6一7個8測9試10字11串)
		//插入到尾端等於append
		System.out.println(bb.length()); 
		System.out.println(bb.insert(bb.length(), bb)); 
		
		// (3) StringBuffer delete (int start, ind end)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); //(0這1是2一3個4測5試6字7串)
		System.out.println(bb);//這是一個測試字串
		System.out.println(bb.delete(1, 2)); //這一個測試字串(將1之後2之前刪除)
		System.out.println(bb.delete(0, 3));//測試字串(將0之後3之前刪除)
		
		// (4) StringBuffer deleteCharAt(int index)
		// (5) StringBuffer replace(int start, int end, String str)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa);// (0這1是2一3個4測5試6字7串)
		System.out.println(bb.deleteCharAt(2)); //這是個測試字串(0這1是2個3測4試5字6串)
		System.out.println(bb.replace(1, 3, "好像不是")); //這好像不是測試字串
		
		// (6) StringBuffer reverse()
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); //0這1是2一3個4測5試6字7串
		System.out.println(bb.reverse()); //串字試測個一是這
		System.out.println(bb.reverse()); //這是一個測試字串 
		
		// (7) void setCharAt() (單引號)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); // 0這1是2一3個4測5試6字7串
		bb.setCharAt(2, '二'); 
		System.out.println(bb); //這是二個測試字串
		//此回傳值為void 不能寫在System.out.println內
		
		// 2. StringBuilder類別 (10-3-2)
		
		// (1) 用法: 與StringBuffer一樣
		// (2) 優點: 效率較高
		// (3) 缺點: 不保證執行多執行系
		
		// (四) 規則表示法 (10-4) matchs
		// 1. 簡介 (10-4-1)
		
		// (1) 檢查是否純數字 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//import java.io.*;
		Scanner sc = new Scanner (System.in);
		//import java.util.*;
		
		
		
		/*
		// 方法1: 用charAt() + for迴圈
		String str;
		boolean isInteger;
		do {
			isInteger = true;
			System.out.print("請輸入整數: ");  // 123 (0:1 1:2 2:3)
			str = sc.next(); //str=br.readLine();
			
			for(int i=0;i<str.length();i++) {
				char ch=str.charAt(i);
				if(ch<'0'||ch>'9') {
					isInteger=false;
					System.out.print("您輸入的不是整數: ");
					break;
				}
			}
		} while (!isInteger);
		
		////////////////////////////////////////////////////////////////
        
		// 方法2: 用matches()
		do {
			isInteger = true;
			System.out.print("請輸入整數: ");  // 123 (0:1 1:2 2:3)
			str = sc.next(); 
			
			if(!str.matches("[0-9]+")) { //不是整數
				isInteger=false;
				System.out.print("您輸入的不是整數: ");
			}
			
		} while (!isInteger);
        
        // 2. 入門 (matches的各種用法) (10-4-2)
		
        
		// 比對兩次輸入密碼
		String pat; // 紀錄使用者輸入樣式
		String str2; // 紀錄使用者輸入測試字串
		
		System.out.print("請輸入樣式: ");
		pat = sc.next();  // 讀取樣式
		
		System.out.print("請輸入字串: ");
		str2 = sc.next();  // 讀取字串
		
		if(str2.matches(pat))
			System.out.print("相符");
		else
			System.out.print("不相符");
        
        */
		// (1) 直接比對
		System.out.println("print".matches("print")); //true
		System.out.println("Print".matches("print")); //false
		// (2) 限制出現次數
		// (A) ?: 最多一次
		System.out.println("aba".matches("ab?a")); //true
		System.out.println("aa".matches("ab?a")); //true
		System.out.println("abba".matches("ab?a")); //false
		// (B) +: 至少一次
		System.out.println("aba".matches("ab+a")); //true
		System.out.println("aa".matches("ab+a")); //false
		System.out.println("abba".matches("ab+a")); //true
		// (C) {n}: 剛好n次
		System.out.println("aba".matches("ab{2}a")); //false
		System.out.println("aa".matches("ab{2}a")); //false
		System.out.println("abba".matches("ab{2}a")); //true
		System.out.println("abbba".matches("ab{2}a")); //false
		// (D) *: 0次以上(包含0次)
		System.out.println("aba".matches("ab*a")); //true
		System.out.println("aa".matches("ab*a")); //true
		System.out.println("abba".matches("ab*a")); //true
		System.out.println("abc".matches("ab*a")); //false
		// (3) 限制字元種類
		// (A) [abc]: 一個a或b或c
		System.out.println("aba".matches("a[bjl]a")); //true
		System.out.println("aka".matches("a[bjl]a")); //false
		System.out.println("abba".matches("a[bjl]a")); //false
		System.out.println("abja".matches("a[bjl]a")); //false
		// (B) [a-z]: 範圍
		System.out.println("a3a".matches("a[0-9]a")); //true
		System.out.println("a38a".matches("a[0-9]a")); //false
		System.out.println("a38a".matches("a[0-9][0-9]a")); //true
		System.out.println("aka".matches("a[a-z]a")); //true
		System.out.println("a3a".matches("a[a-z]a")); //false
		System.out.println("aAa".matches("a[a-z]a")); //false
		// (C) [0-9a-z]表示「[0-9]」或「[a-z]」
		System.out.println("a3a".matches("a[0-9a-z]a"));//true
		System.out.println("aca".matches("a[0-9a-z]a"));//true
		System.out.println("a3ca".matches("a[0-9a-z]a"));//false//一次一個
		System.out.println("a3ca".matches("a[0-9a-z][0-9a-z]a"));//true
		
		// (4) 字元種類 
		System.out.println("a1a".matches("a\\da")); //true \d:整數
		System.out.println("aca".matches("a\\da")); //false
		System.out.println("a1a".matches("a\\Da")); //false \D:非整數
		System.out.println("aca".matches("a\\Da")); //true
		
		// (5) 群組 (){}
		System.out.println("a7a".matches("a(\\d){2}a"));//整數出現兩次 FALSE
		System.out.println("a38a".matches("a(\\d){2}a"));//true
		System.out.println("ag3gg8ga".matches("a(g\\dg){2}a")); //true
		System.out.println("ag3ga".matches("a(g\\dg){2}a"));//false
		
		// 3. replaceAll(), 「()(),"$1$2"」(10-4-3)
		System.out.println("ab123cd123".replaceAll("123", "456")); //ab456cd456
		System.out.println("ab123cd77".replaceAll("\\d", "*"));//ab***cd**
		System.out.println("ab123cd77".replaceAll("\\d+", "數字")); //ab數字cd數字
		System.out.println("ab123cd77".replaceAll("(\\d+)", "數字$1")); //$1:(\\d+)
        //ab數字123cd數字77
		System.out.println("ab123cd77".replaceAll("([0-9])", "數字$1")); //ab數字1數字2數字3cd數字7數字7
		
		/*
		補充：正則表達式的範例
		參考：http://ccckmit.wikidot.com/regularexpression

		語法				正則表達式						範例
		整數				[0-9]+							3704
		有小數點的實數	    [0-9]+\.[0-9]+					7.93
		位址				[0-9]+(\.[0-9]+){3}				168.1.0.0
		英文詞彙			[A-Za-z]+						Code
		變數名稱			[A-Za-z_][A-Za-z0-9_]*			_counter(因為變數名稱不能是數字開頭)
		Email			[a-zA-Z0-9_]+@[a-zA-Z0-9\._]+	ccc@kmit.edu.tw  (不完整)
		URL				http://[a-zA-Z0-9\./_]+			http://ccc.kmit.edu.tw/mybook/ (不完整)
		
		PS: 使用 「\.」 代表小數點符號「.」
		*/
	}
}
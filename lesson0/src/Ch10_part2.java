// Ch10 字串(String)_Part2 (學生版)
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
		System.out.println(bb.append(20));
		System.out.println(bb.append("字串內容已經變了"));
		System.out.println(bb);

		// (2) insert()
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa);
		System.out.println(bb); 
		System.out.println(bb.insert(0, 38)); 
		System.out.println(bb.insert(3, "東西")); 
		
		System.out.println(bb.length()); 
		System.out.println(bb.insert(bb.length(), bb)); 
		
		// (3) StringBuffer delete (int start, ind end)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); 
		System.out.println(bb);
		System.out.println(bb.delete(1, 2)); 
		System.out.println(bb.delete(0, 3));	
		
		// (4) StringBuffer deleteCharAt(int index)
		// (5) StringBuffer replace(int start, int end, String str)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa);
		System.out.println(bb.deleteCharAt(2)); 
		System.out.println(bb.replace(1, 3, "好像不是")); 
		
		// (6) StringBuffer reverse()
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); // 0這1是2一3個4測5試6字7串
		System.out.println(bb.reverse()); 
		System.out.println(bb.reverse()); 
		
		// (7) void setCharAt() (單引號)
		aa = "這是一個測試字串";
		bb = new StringBuffer(aa); // 0這1是2一3個4測5試6字7串
		bb.setCharAt(2, '二'); 
		System.out.println(bb); 
		
		// 2. StringBuilder類別 (10-3-2)
		
		// (1) 用法: 
		// (2) 優點: 
		// (3) 缺點: 
		
		// (四) 規則表示法 (10-4)
		// 1. 簡介 (10-4-1)
		
		// (1) 檢查是否純數字 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner (System.in);
				
		// 方法1: 用charAt() + for迴圈
		String str;
		boolean isInteger;
		do {
			isInteger = true;
			System.out.print("請輸入整數: ");  // 123 (0:1 1:2 2:3)
			str = sc.next(); 
			
			// 程式
			

		} while (!isInteger);
		
		////////////////////////////////////////////////////////////////
		// 方法2: 用matches()
		do {
			isInteger = true;
			System.out.print("請輸入整數: ");  // 123 (0:1 1:2 2:3)
			str = sc.next(); 
			
			// 程式
			
		} while (!isInteger);
		
		// 2. 入門 (matches的各種用法) (10-4-2)
		
		// 比對兩次輸入密碼
		String pat; // 紀錄使用者輸入樣式
		String str2; // 紀錄使用者輸入測試字串
		
		System.out.print("請輸入樣式: ");
		pat = sc.next();  // 讀取樣式
		
		System.out.print("請輸入字串: ");
		str2 = sc.next();  // 讀取字串
		
		// 程式
		
		// (1) 直接比對
		System.out.println("print".matches("print")); 
		System.out.println("Print".matches("print")); 
		
		// (2) 限制出現次數
		// (A) ?: 最多一次
		System.out.println("aba".matches("ab?a")); 
		System.out.println("aa".matches("ab?a")); 
		System.out.println("abba".matches("ab?a")); 
		// (B) +: 至少一次
		System.out.println("aba".matches("ab+a")); 
		System.out.println("aa".matches("ab+a")); 
		System.out.println("abba".matches("ab+a")); 
		// (C) {n}: 剛好n次
		System.out.println("aba".matches("ab{2}a")); 
		System.out.println("aa".matches("ab{2}a")); 
		System.out.println("abba".matches("ab{2}a")); 
		System.out.println("abbba".matches("ab{2}a")); 
		// (D) *: 0次以上
		System.out.println("aba".matches("ab*a")); 
		System.out.println("aa".matches("ab*a")); 
		System.out.println("abba".matches("ab*a")); 
		
		// (3) 限制字元種類
		// (A) [abc]: 一個a或b或c
		System.out.println("aba".matches("a[bjl]a")); 
		System.out.println("aka".matches("a[bjl]a")); 
		System.out.println("abba".matches("a[bjl]a")); 
		System.out.println("abja".matches("a[bjl]a")); 
		// (B) [a-z]: 範圍
		System.out.println("a3a".matches("a[0-9]a")); 
		System.out.println("a38a".matches("a[0-9]a")); 
		System.out.println("aka".matches("a[a-z]a")); 
		System.out.println("a3a".matches("a[a-z]a")); 
		System.out.println("aAa".matches("a[a-z]a")); 
		// (C) [0-9a-z]表示「[0-9]」或「[a-z]」
		System.out.println("a3a".matches("a[0-9a-z]a"));
		System.out.println("aca".matches("a[0-9a-z]a"));
		System.out.println("a3ca".matches("a[0-9a-z]a"));
		
		// (4) 字元種類 
		System.out.println("a1a".matches("a\\da")); 
		System.out.println("aca".matches("a\\da")); 
		System.out.println("a1a".matches("a\\Da")); 
		System.out.println("aca".matches("a\\Da")); 
		
		// (5) 群組 (){}
		System.out.println("a7a".matches("a(\\d){2}a"));
		System.out.println("a38a".matches("a(\\d){2}a"));
		System.out.println("ag3gg8ga".matches("a(g\\dg){2}a")); 
		System.out.println("ag3ga".matches("a(g\\dg){2}a"));
		
		// 3. replaceAll(), 「()(),"$1$2"」(10-4-3)
		System.out.println("ab123cd123".replaceAll("123", "456")); 
		System.out.println("ab123cd77".replaceAll("\\d", "*"));
		System.out.println("ab123cd77".replaceAll("\\d+", "數字")); 
		System.out.println("ab123cd77".replaceAll("(\\d+)", "數字$1")); 
		System.out.println("ab123cd77".replaceAll("([0-9])", "數字$1")); 
		
		/*
		補充：正則表達式的範例
		參考：http://ccckmit.wikidot.com/regularexpression

		語法				正則表達式						範例
		整數				[0-9]+							3704
		有小數點的實數	[0-9]+\.[0-9]+					7.93
		位址				[0-9]+(\.[0-9]+){3}				168.1.0.0
		英文詞彙			[A-Za-z]+						Code
		變數名稱			[A-Za-z_][A-Za-z0-9_]*			_counter
		Email			[a-zA-Z0-9_]+@[a-zA-Z0-9\._]+	ccc@kmit.edu.tw  (不完整)
		URL				http://[a-zA-Z0-9\./_]+			http://ccc.kmit.edu.tw/mybook/ (不完整)
		
		PS: 使用 「\.」 代表小數點符號「.」
		*/
	}
}
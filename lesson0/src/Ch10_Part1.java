// Ch10 字串(String)_Part1 (學生版)

public class Ch10_Part1 {
	public static void main(String[] args) {		
		// (一) 產生字串 (10-1)
		// 0. 基本用法
		char[] test = {'這', '是','個','測','試','字','串'}; // 0這1是2個3測4試5字6串
		// 程式：四個String

		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		
		// 程式
		
		// 1. JAVA對String的特別支援 (10-1-1)
		// (1) Stringconstant (字面常數)
		a = "這是一個測試字串";
		// 程式
		
		System.out.println("a==b ?" + (a==b));
		System.out.println("b==c ?" + (b==c));
		System.out.println("a==c ?" + (a==c));
		
		// (2) equals()方法: 比較內容
		System.out.println("a與b內容相同 ?" + a.equals(b));
		System.out.println("b與c內容相同 ?" + b.equals(c));
		System.out.println("a與c內容相同 ?" + a.equals(c));
		
		// (3) equalsIgnoreCase()方法: 比較內容(忽略大小寫)
		String x = "This is a TEST String";
		String y = "This is a test string";
		
		System.out.println("分大小寫時, x與y內容相同 ?" + x.equals(y));
		System.out.println("不分大小寫時, x與y內容相同 ?" + x.equalsIgnoreCase(y));
		
		// 2. String物件特性 (10-1-2)
		// (1) toString()方法: 「非String物件」的自動轉型		

		
		// 2-(1)-B 主類別
		Student s1 = new Student("Joy");

		// (2) String物件內容產生後, 無法更改
		
		//////////////////////////////////////////////////////////////////////////
		
		// (二) 各種String類別的「方法」(method) (10-2)
		// 1. charAt(int index)
		a = "這是一個測試字串"; // 0這1是2一3個4測5試6字7串 (索引號碼: index)
		System.out.println("索引0的字元: " + a.charAt(0));
		System.out.println("索引5的字元: " + a.charAt(5));
		
		// 2. 字串比較與包含
		// (1) int compareTo(String anotherString)
		a = "abcd";
		System.out.println(a.compareTo("abcb"));
		System.out.println(a.compareTo("abcd"));
		System.out.println(a.compareTo("abce"));
		System.out.println(a.compareTo("abcde"));
		System.out.println(a.compareTo("Abcd"));
		
		// (2) int compareToIgnoreCase(String anotherString)
		System.out.println(a.compareToIgnoreCase("ABCB"));
		System.out.println(a.compareToIgnoreCase("ABCD"));
		System.out.println(a.compareToIgnoreCase("ABCE"));
		
		// (3) boolean contains(CharSequence s) // 介面
		a = "abcd";
		System.out.println(a.contains("abcd"));
		System.out.println(a.contains("abc"));
		System.out.println(a.contains("abcde"));
		System.out.println(a.contains("lkk"));
		
		// (4) boolean endsWith(String suffix)
		System.out.println(a.endsWith("cd"));

		// (5) boolean startsWith(String suffix)
		System.out.println(a.startsWith("ab"));
		
		// 3. void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
		a = "這是一個測試字串"; // 0這1是2一3個4測5試6字7串
		char [] chars = new char[4];
		a.getChars(1, 5, chars, 0);
		System.out.println(new String(chars));
		
		// 4. index索引
		// (1) int indexOf(int ch)
		a = "這是一個測試字串讚讚讚"; // 0這1是2一3個4測5試6字7串8讚9讚10讚
		System.out.println(a.indexOf('測')); 
		System.out.println(a.indexOf('空'));
		System.out.println(a.indexOf('讚')); 
		
		// int lastIndexOf(int ch)
		System.out.println(a.lastIndexOf('讚'));
	 	
		// (2) int indexOf(int ch, int fromIndex)
		System.out.println(a.indexOf('讚', 9));
		System.out.println(a.lastIndexOf('讚', 9));
		
		// (3) int indexOf(String str)
		System.out.println(a.indexOf("測試"));
		System.out.println(a.indexOf("字符"));
		System.out.println(a.indexOf("讚讚"));
		System.out.println(a.lastIndexOf("讚讚"));
		
		// (4) int indexOf(String str, int fromIndex)
		System.out.println(a.indexOf("讚讚", 9));
		System.out.println(a.lastIndexOf("讚讚", 9));
		
		// 5. 屬性
		b = "   " ; // 三個空白
		// (1) boolean isEmpty() 空的
		System.out.println(b.isEmpty());
		// (2) boolean isBlank() 空白
		System.out.println(b.isBlank());
		// (3) boolean length() 長度
		System.out.println(b.length());
		
		// 6. 字串取代
		// (1) String replace (char oldChar, char newChar) (單引號)
		a = "這是一個測試字串";
		System.out.println(a.replace('測','考'));
		System.out.println(a);
		
		// (2) String replace (charSequence target, charSequence replacement) (雙引號)
		a = "這是一個測試字串"; // 0這1是2一3個4測5試6字7串
		System.out.println(a.replace("測試","正式"));
		System.out.println(a);
		
		// 7. 開頭字與結尾字
		// (1) boolean startsWith(String prefix)  
		// (2) boolean startsWith(String prefix, int offset)  
		// (3) boolean endsWith(String prefix)
		// (無此功能) boolean endsWith(String prefix, int offset)
		
		a = "abcd"; // 0a 1b 2c 3d
		System.out.println(a.startsWith("cd")); 
		System.out.println(a.startsWith("cd", 2));
		System.out.println(a.endsWith("cd")); 
		// System.out.println(a.endsWith("cd", 2)); 
		
		// 8. 子字串
		// (1) String substring (int beginIndex)
		// (2) String substring (int beginIndex, int endIndex)
		a = "這是一個測試字串"; // 0這1是2一3個4測5試6字7串
		System.out.println(a.substring(4));
		System.out.println(a.substring(4, 6));
		
		// 9. 大小寫轉換
		// (1) String toLowerCase()
		// (2) String toUpperCase()
		a = "ABcd";
		System.out.println(a.toLowerCase()); 
		System.out.println(a.toUpperCase());
		
		// 10. 去頭尾的「空白」與「特殊字元」
		// (1) String trim() 去頭尾的「空白」與「特殊字元」 (不含「Unicode空白」)
		a = " \t 這是一個測試字串"; // 0 1\t2 3這4是5一6個7測8試9字10串
		System.out.println(a); 
		System.out.println(a.trim()); 
		System.out.println(a); 
		
		// (2) String stip() 去頭尾的「空白」與「特殊字元」 (含「Unicode空白」)
		// (3) String stipLeading() 去頭端的「空白」與「特殊字元」 (含「Unicode空白」)
		// (4) String stipTrailing() 去尾端的「空白」與「特殊字元」 (含「Unicode空白」)
		
		// 11. String repeat (int count)
		a = "ABc";
		System.out.println(a.repeat(3));
		System.out.println("OK".repeat(3));
	}
}


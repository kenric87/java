// Ch10 �r��(String)_Part1 (�ǥͪ�)

public class Ch10_Part1 {
	public static void main(String[] args) {		
		// (�@) ���ͦr�� (10-1)
		// 0. �򥻥Ϊk
		char[] test = {'�o', '�O','��','��','��','�r','��'}; // 0�o1�O2��3��4��5�r6��
		// �{���G�|��String

		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		
		// �{��
		
		// 1. JAVA��String���S�O�䴩 (10-1-1)
		// (1) Stringconstant (�r���`��)
		a = "�o�O�@�Ӵ��զr��";
		// �{��
		
		System.out.println("a==b ?" + (a==b));
		System.out.println("b==c ?" + (b==c));
		System.out.println("a==c ?" + (a==c));
		
		// (2) equals()��k: ������e
		System.out.println("a�Pb���e�ۦP ?" + a.equals(b));
		System.out.println("b�Pc���e�ۦP ?" + b.equals(c));
		System.out.println("a�Pc���e�ۦP ?" + a.equals(c));
		
		// (3) equalsIgnoreCase()��k: ������e(�����j�p�g)
		String x = "This is a TEST String";
		String y = "This is a test string";
		
		System.out.println("���j�p�g��, x�Py���e�ۦP ?" + x.equals(y));
		System.out.println("�����j�p�g��, x�Py���e�ۦP ?" + x.equalsIgnoreCase(y));
		
		// 2. String����S�� (10-1-2)
		// (1) toString()��k: �u�DString����v���۰��૬		

		
		// 2-(1)-B �D���O
		Student s1 = new Student("Joy");

		// (2) String���󤺮e���ͫ�, �L�k���
		
		//////////////////////////////////////////////////////////////////////////
		
		// (�G) �U��String���O���u��k�v(method) (10-2)
		// 1. charAt(int index)
		a = "�o�O�@�Ӵ��զr��"; // 0�o1�O2�@3��4��5��6�r7�� (���޸��X: index)
		System.out.println("����0���r��: " + a.charAt(0));
		System.out.println("����5���r��: " + a.charAt(5));
		
		// 2. �r�����P�]�t
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
		
		// (3) boolean contains(CharSequence s) // ����
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
		a = "�o�O�@�Ӵ��զr��"; // 0�o1�O2�@3��4��5��6�r7��
		char [] chars = new char[4];
		a.getChars(1, 5, chars, 0);
		System.out.println(new String(chars));
		
		// 4. index����
		// (1) int indexOf(int ch)
		a = "�o�O�@�Ӵ��զr���g�g�g"; // 0�o1�O2�@3��4��5��6�r7��8�g9�g10�g
		System.out.println(a.indexOf('��')); 
		System.out.println(a.indexOf('��'));
		System.out.println(a.indexOf('�g')); 
		
		// int lastIndexOf(int ch)
		System.out.println(a.lastIndexOf('�g'));
	 	
		// (2) int indexOf(int ch, int fromIndex)
		System.out.println(a.indexOf('�g', 9));
		System.out.println(a.lastIndexOf('�g', 9));
		
		// (3) int indexOf(String str)
		System.out.println(a.indexOf("����"));
		System.out.println(a.indexOf("�r��"));
		System.out.println(a.indexOf("�g�g"));
		System.out.println(a.lastIndexOf("�g�g"));
		
		// (4) int indexOf(String str, int fromIndex)
		System.out.println(a.indexOf("�g�g", 9));
		System.out.println(a.lastIndexOf("�g�g", 9));
		
		// 5. �ݩ�
		b = "   " ; // �T�Ӫť�
		// (1) boolean isEmpty() �Ū�
		System.out.println(b.isEmpty());
		// (2) boolean isBlank() �ť�
		System.out.println(b.isBlank());
		// (3) boolean length() ����
		System.out.println(b.length());
		
		// 6. �r����N
		// (1) String replace (char oldChar, char newChar) (��޸�)
		a = "�o�O�@�Ӵ��զr��";
		System.out.println(a.replace('��','��'));
		System.out.println(a);
		
		// (2) String replace (charSequence target, charSequence replacement) (���޸�)
		a = "�o�O�@�Ӵ��զr��"; // 0�o1�O2�@3��4��5��6�r7��
		System.out.println(a.replace("����","����"));
		System.out.println(a);
		
		// 7. �}�Y�r�P�����r
		// (1) boolean startsWith(String prefix)  
		// (2) boolean startsWith(String prefix, int offset)  
		// (3) boolean endsWith(String prefix)
		// (�L���\��) boolean endsWith(String prefix, int offset)
		
		a = "abcd"; // 0a 1b 2c 3d
		System.out.println(a.startsWith("cd")); 
		System.out.println(a.startsWith("cd", 2));
		System.out.println(a.endsWith("cd")); 
		// System.out.println(a.endsWith("cd", 2)); 
		
		// 8. �l�r��
		// (1) String substring (int beginIndex)
		// (2) String substring (int beginIndex, int endIndex)
		a = "�o�O�@�Ӵ��զr��"; // 0�o1�O2�@3��4��5��6�r7��
		System.out.println(a.substring(4));
		System.out.println(a.substring(4, 6));
		
		// 9. �j�p�g�ഫ
		// (1) String toLowerCase()
		// (2) String toUpperCase()
		a = "ABcd";
		System.out.println(a.toLowerCase()); 
		System.out.println(a.toUpperCase());
		
		// 10. �h�Y�����u�ťաv�P�u�S��r���v
		// (1) String trim() �h�Y�����u�ťաv�P�u�S��r���v (���t�uUnicode�ťաv)
		a = " \t �o�O�@�Ӵ��զr��"; // 0 1\t2 3�o4�O5�@6��7��8��9�r10��
		System.out.println(a); 
		System.out.println(a.trim()); 
		System.out.println(a); 
		
		// (2) String stip() �h�Y�����u�ťաv�P�u�S��r���v (�t�uUnicode�ťաv)
		// (3) String stipLeading() �h�Y�ݪ��u�ťաv�P�u�S��r���v (�t�uUnicode�ťաv)
		// (4) String stipTrailing() �h���ݪ��u�ťաv�P�u�S��r���v (�t�uUnicode�ťաv)
		
		// 11. String repeat (int count)
		a = "ABc";
		System.out.println(a.repeat(3));
		System.out.println("OK".repeat(3));
	}
}


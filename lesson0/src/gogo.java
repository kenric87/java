/**
 * gogo
 */
import java.util.Scanner; // Add this import statement
public class gogo {

    public static void main(String[] args) {
        System.err.println("hello world");
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入一個整數: ");
        x = sc.nextInt();
        System.out.println("你輸入的整數為: " + x);

        //CH7 陣列 7-1 陣列簡介 (1)陣列宣告
		double[] students;
		students = new double[5];//兩行的寫法
		
		double[] students2 = new double[5];//一行的寫法
		
		// (2)陣列給值
		students[0] = 70;
		students[1] = 80;
		students[2] = 90;
		students[3] = 60;
		students[4] = 50;
		
		//(3)宣告設定初值
		double[] students3 = {10, 80, 90, 60, 50};
		
		//(4)陣列名稱.lenth: 陣列元素個數
		System.out.println("陣列長度為" + students.length); //陣列名稱.lenth

        //(比較) 字串名稱.length():字串長度
		String s1 = "ABC";
		System.out.println("字串長度為" + s1.length());
		
		//(5)陣列使用
		System.out.println("第一個學生分數為" + students[0]);
		System.out.println("第二個學生分數為" + students[1]);
        
        //7-2陣列用在迴圈
        double sum = 0;
        for (int j = 0; j < 5; j++) {
			sum += students[j];
		}
		
		double sum2 = 0;
		for (int j = 0; j < students.length; j++) {
			sum2 += students[j];
		}
		
		//for-each 寫法
		//
		double sum3 = 0;
		for(double j: students) {
			sum3 += j;
		}
        System.out.println(sum3);
        
        //7-3 多微陣列
		//(1)二微陣列固定配置
		int[][] a = new int [3][4];
		//二微陣列名稱.length: (正下方)陣列元素個數
		System.out.println("a 陣列長度為: " + a.length);//3
		System.out.println("a[0] 陣列長度為: " + a[0].length);//4

		//(2)二微陣列分層配置
		int[][] b = new int [3][];
		b[0] = new int[4];
		b[1] = new int[5];
		b[2] = new int[6];
		
		
		//(3)三維
		
		int[][][] c = new int [3][][];
		
		//*只有最右邊的元素可以留空
		//錯誤寫法
		// int [][] aaa = int[][4];
		// int [][][] bbb = new int[][5][];
		//正確寫法
		int [][][] ccc = new int [6][7][];
		int [][][] ddd = new int [8][][];
		
		//(3)宣告時設定初值
		int [][] d = {
				{1,2,3,4},
				{5,6,7,8}
		};
		//(4)多微陣列 搭配 for-each
		//int [][]d       int []i:d
		//int []i       int j:i
		for (int []i:d) {
			for(int j:i) {
				System.out.println(j + "\t");
			System.out.println("");
			}
		}


    }
}
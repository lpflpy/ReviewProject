package test.liuwangfang.com.reviewproject.datastructure;

/***
输入数字n，按顺序打印出从1到n位最大十进数的数值。比如输入3，则打印出1、2、3一直到最大三位数即999。
*/

public class Test9{
	public static void main(String[] args) {
		printAll(2);
	}

	public static void printAll(int n){
		StringBuilder sb = new StringBuilder();

		while(n>0){
			sb.append("9");
			n--;
		}
		int max = Integer.valueOf(sb.toString());
		for(int i= 1; i<= max;i++){
			System.out.print(i+" ");
		}
	}
}
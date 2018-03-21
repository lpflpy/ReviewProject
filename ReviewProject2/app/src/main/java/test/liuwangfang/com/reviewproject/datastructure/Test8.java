package test.liuwangfang.com.reviewproject.datastructure;

/**
请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制1001，有2位1。因此如果输入9，该函数输出2。
*/


public class Test8{
	public static void main(String[] args) {
		int num = 9;
		System.out.println("count ====="+getOneNum(num));
	}

	public static int getOneNum(int n){

		int count = 0;
		int i = 1;
		int index = 0;
		while(index<32){
			int re = n & i;
			if(re>0){
				count ++;
			}
			i = i << 1;
			index++;
		}

		return count;
	}
}
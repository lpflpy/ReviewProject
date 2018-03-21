package test.liuwangfang.com.reviewproject.datastructure;

/**
写一个函数，输入n，求斐波那契数列的第n项值。

斐波那契数列的定义如下：



f0 ＝ 0；
f1 = 1;
fn = fn-1 +fn-2;
*/

public class Test7{
	public static void main(String[] args) {
			System.out.println("n==="+fibonacci(5));
	}

	public static int getNum(int n){
		if(n == 0){
			return 0;
		}

		if(n ==1 || n==2){
			return 1;
		}

		return getNum(n-1)+getNum(n-2);

	}
	public static int fibonacci(int n){
		if(n == 0){
			return 0;
		}

		if(n ==1 || n==2){
			return 1;
		}

		int i = 3;

		int pre = 1;
		int prepre = 1;
		int current = pre+prepre;

		while(i<=n){
			current = prepre+pre;
			prepre = prepre;
			pre = current;
			i++;
		}
		return current;
	}

}






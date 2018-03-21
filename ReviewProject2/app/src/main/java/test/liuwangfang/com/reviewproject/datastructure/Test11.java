package test.liuwangfang.com.reviewproject.datastructure;/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
*/

import java.util.Arrays;
public class Test11{
	public static void main(String[] args) {
		int[] nums ={1,2,10,12,3,11,11,4,5,6,7,8};

		// System.out.println("getNewArray=="+Arrays.toString(getNewArray(nums)));
		System.out.println("getNewArray=="+Arrays.toString(getNewArray2(nums)));
	}
	public static int[] getNewArray(int[] nums){
		int i = 0;
		int j =0;
		int[] oushuArray = new int[nums.length];
		int[] jishuArray = new int[nums.length];
		for(int num:nums){
			if(num%2==0){
				oushuArray[i++] = num;
			}else{
				jishuArray[j++] = num;
			}
		}
		for(int m = 0;m<i;m++){
			int num = oushuArray[m];
			jishuArray[j++] = num;
		}

		return jishuArray;

	}

	public static int[] getNewArray2(int[] nums){
		//错误的想法 只相比的相邻的2个元素
		// for(int i = 0;i<nums.length-1;i++){
		// 	System.out.println("nums[i]=="+nums[i]+"   nums[i+1]=="+nums[i+1]);
		// 	if(nums[i]%2==0 && nums[i+1]%2!=0){
		// 		int temp = nums[i];
		// 		nums[i] = nums[i+1];
		// 		nums[i+1] = temp;
		// 	}
		// }

		// int i = 0;
		// int j = 1;
		// while(i<nums.length && j<nums.length){
		// 	if(nums[i]%2==0 && nums[j]%2!=0){
		// 		int temp = nums[i];
		// 		nums[i] = nums[j];
		// 		nums[j] = temp;
		// 		i++;
		// 		j++;
		// 	}else if(nums[i]%2==0 && nums[j]%2==0){
		// 		j++;
		// 	}else{
		// 		i++;
		// 		j++;
		// 	}

		// }

		int start = 0;
		int end = nums.length-1;
		while(start<end){
			// if(nums[start] %2 ==0 && nums[end]%2!=0){
			// 	int temp = nums[start];
			// 	nums[start] = nums[end];
			// 	nums[end] = temp;
			// 	start++;
			// 	end--;
			// }else if(nums[start]%2==0 && nums[end]%2==0){
			// 	end--;
			// }else{
			// 	start++;
			// 	end--;
			// }
			/**
				标准答案    两个指针移动的规则：第一个指针只有是偶数时才停止移动。第二个指针只有是奇数时才停止移动 while循环的使用场合：有开始的时机 有停止的时机
				while是当。。。时候，当为奇数时，指针移动，当为偶数时，指针停止。
			*/
			while(start<end && nums[start]%2!=0){
				start++;
			}
			while(start<end && nums[end]%2==0){
				end--;
			}

			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

		}
		return nums;

	}
}
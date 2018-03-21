package test.liuwangfang.com.reviewproject.datastructure;

/**请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。*/
class StringTest{
	public static void main(String[] args){
		String str = replace("We are happy.","%20");
		System.out.println("str=="+str);
	}

	private static String replace(String str,String des){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			
			if(c ==' '){
				sb.append(des);			
			}else{
				sb.append(String.valueOf(c));
			}
		}
		return sb.toString();
	}
}
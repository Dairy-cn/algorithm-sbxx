package com.dair.sbxx.day38;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: 2021/10/10
 ************************************************************/
public class Test2 {
	
	public int maxConsecutiveAnswers(String answerKey, int k) {
		
		int maxLength=returnMaxLength(answerKey);
		if(maxLength==answerKey.length()){
			return maxLength;
		}
		//FTFTTFTT 1
		//滑动窗口替换
		for (int i = 0; i <= answerKey.length()-k; i++) {
			
			StringBuilder stringBuilder = new StringBuilder(answerKey);
			int index=0;
			while (index<k){
				char c = answerKey.charAt(i+index);
				stringBuilder.setCharAt(i+index,c=='F'?'T':'F');
				++index;
			}
			maxLength=Math.max(maxLength,returnMaxLength(stringBuilder.toString()));
			
		}
		return maxLength;
	}
	
	
	public int returnMaxLength(String answerKey){
		int maxLength = 1;
		int index1 = 1;
		int index2 = 1;
		boolean flag = true;
		//TTTFFF
		for (int i = 1; i < answerKey.length(); i++) {
			if (answerKey.charAt(i - 1) == answerKey.charAt(i)) {
				maxLength = Math.max(flag ? ++index1 : ++index2, maxLength);
			} else {
				if (flag) {
					index1 = 1;
				} else {
					index2 = 1;
				}
				flag=!flag;
			}
			
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().maxConsecutiveAnswers("F",1));;
	}
	
}

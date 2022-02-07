package com.dair.sbxx.year2021.day38;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/10/10
 ************************************************************/
public class Test3 {
	
	public int maxConsecutiveAnswers(String answerKey, int k) {
		int left = 0;
		int right = 0;
		int numT = 0;
		int numF = 0;
		int n = answerKey.length();
		int res = 0;
		while (right < n) {
			
			if (answerKey.charAt(right) == 'T') {
				numT++;
			} else {
				numF++;
			}
			while (numF > k && numT > k) {
				//需要左移left
				if (answerKey.charAt(left) == 'T') {
					numT--;
				} else {
					numF--;
				}
				left++;
			}
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test3().maxConsecutiveAnswers("FTFTT",1));
	}
}

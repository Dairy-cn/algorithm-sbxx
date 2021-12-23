package com.dair.sbxx.day68;

/**
 * @author Dair
 * @since
 */
public class Test {


//	public int repeatedStringMatch(String a, String b) {
//		//如果重叠后2*a.length()>b.length()还找不到，则不存在子串
//		int n = a.length();
//		int m = b.length();
//		int res = 1;
//		String c = a;
//		int index = 1;
//		while (index <= m) {
//			if (isSubStringByKmp(c, b)) {
//				return res;
//			}
//			c = c + "" + a;
//			res++;
//			index++;
//		}
//
//		return -1;
//	}
	
	//	public int repeatedStringMatch(String a, String b) {
//		//如果重叠后2*a.length()>b.length()还找不到，则不存在子串
//		StringBuilder sb = new StringBuilder();
//		int ans = 0;
//		while (sb.length() < b.length() && ++ans > 0) {
//			sb.append(a);
//		}
//		sb.append(a);
//		int indexOf = isSubStringByKmp(sb.toString(), b);
//		if (indexOf != -1) {
//			return indexOf + b.length() > a.length() * ans ? ans + 1 : ans;
//		}
//
//		return -1;
//	}
	private int isSubStringByKmp(String a, String b) {
		if (b == null && b.length() == 0) {
			return 0;
		}
		if (a.length() < b.length()) {
			return -1;
		}
		
		int[] nextArr = getNextArr(b);
		int index = 0;
		
		for (int i = 0; i < a.length(); i++) {
			while (index > 0 && a.charAt(i) != b.charAt(index)) {
				index = nextArr[index - 1];
			}
			if (a.charAt(i) == b.charAt(index)) {
				index++;
			}
			if (index == b.length()) {
				return i - index + 1;
			}
		}
		return -1;
	}
	
	
	public int repeatedStringMatch(String a, String b) {
		//如果重叠后2*a.length()>b.length()还找不到，则不存在子串
		int ans=0;
		String c=a;
		while(c.length()<b.length() && ++ans>0){
			c=c+a;
		}
		c=c+a;
		int indexOf=strHash(c, b);
		if ( indexOf!= -1) {
			return indexOf+b.length()>ans*a.length()?ans+1:ans;
		}
		return -1;
	}
	
	private boolean isSubString(String a, String b) {
		if (a.length() < b.length()) {
			return false;
		}
		int index = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(index)) {
				i = i - index;
				index = 0;
				continue;
			} else {
				index++;
			}
			if (index == b.length()) {
				return true;
			}
		}
		return false;
	}
	
	private int[] getNextArr(String m) {
		int n = m.length();
		int[] next = new int[n + 1];
		next[0] = 0;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (m.charAt(j) == m.charAt(i)) {
				next[i] = j + 1;
				j++;
			} else {
				while (j != 0 && m.charAt(i) != m.charAt(j)) {
					j = next[j - 1];
				}
				if (j == 0 && m.charAt(i) != m.charAt(j)) {
					next[i] = 0;
				} else {
					next[i] = j + 1;
					j++;
				}
				
			}
		}
		return next;
		
	}
	int strHash(String ss, String b) {
		int P = 131;
		int n = ss.length(), m = b.length();
		String str = ss + b;
		int len = str.length();
		int[] h = new int[len + 10], p = new int[len + 10];
		p[0] = 1;
		for (int i = 0; i < len; i++) {
			p[i + 1] = p[i] * P;
			h[i + 1] = h[i] * P + str.charAt(i);
		}
		int r = len, l = r - m + 1;
		int target = h[r] - h[l - 1] * p[r - l + 1]; // b 的哈希值
		for (int i = 1; i <= n; i++) {
			int j = i + m - 1;
			int cur = h[j] - h[i - 1] * p[j - i + 1]; // 子串哈希值
			if (cur == target) return i - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {

//		System.out.println(new Test().getNextArr("aaabbab"));
		System.out.println(new Test().repeatedStringMatch("abcd", "cdabcdab"));
	}
}

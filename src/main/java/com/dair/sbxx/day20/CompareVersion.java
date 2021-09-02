package com.dair.sbxx.day20;

/**
 * @author Dair
 * @since
 */
public class CompareVersion {
	
	
	public int compareVersion(String version1, String version2) {
		if (version1 == null || version2 == null) {
			return 0;
		}
		int x = 0, y = 0;
		int m = version1.length();
		int n = version2.length();
		while (x < m || y < n) {
			int i = 0;
			for (; x < m && version1.charAt(x) != '.'; x++) {
				i = 10 * i + version1.charAt(x)-'0';
			}
			++x; // 跳过点号
			int j = 0;
			for (; y < n && version2.charAt(y) != '.'; y++) {
				j = 10 * j + version2.charAt(y)-'0';
			}
			++y; // 跳过点号
			if (i != j) {
				return i > j? 1 : -1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new CompareVersion().compareVersion("1.101", "1.001"));
	}
}

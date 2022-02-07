package com.dair.sbxx.year2021.day66;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
	 *
	 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
	 *
	 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
	 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
	 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
	 *
	 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
	 *
	 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
	 *
	 *  
	 *
	 * 示例 1：
	 *
	 * 输入：secret = "1807", guess = "7810"
	 * 输出："1A3B"
	 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
	 * "1807"
	 *   |
	 * "7810"
	 * 示例 2：
	 *
	 * 输入：secret = "1123", guess = "0111"
	 * 输出："1A1B"
	 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
	 * "1123"        "1123"
	 *   |      or     |
	 * "0111"        "0111"
	 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param secret
	 * @param guess
	 * @return
	 */
	public String getHint(String secret, String guess) {
		int[] arr=new int[10];
		int[] arr2=new int[10];
		int a=0;
		int b=0;
		for (int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i)==guess.charAt(i)){
				a++;
			}else {
			 arr[secret.charAt(i)-'0']++;
			 arr2[guess.charAt(i)-'0']++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if( arr[i]>0 && arr2[i] >0){
				if(arr2[i]==arr[i]){
					b+=arr[i];
				}else {
					b+=Math.min(arr2[i],arr[i]);
				}
				
			}
		}
		return a+"A"+b+"B";
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().getHint("1", "0"));
		
		
	}
	
	/**
	 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
	 * <p>
	 * 如果小镇的法官真的存在，那么：
	 * <p>
	 * 小镇的法官不相信任何人。
	 * 每个人（除了小镇法官外）都信任小镇的法官。
	 * 只有一个人同时满足条件 1 和条件 2 。
	 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
	 * <p>
	 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：n = 2, trust = [[1,2]]
	 * 输出：2
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/find-the-town-judge
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public int findJudge2(int n, int[][] trust) {
		int[] inArr = new int[n + 1];
		int[] outArr = new int[n + 1];
		for (int i = 0; i < trust.length; i++) {
			int[] ints = trust[i];
			int outInt = ints[0];
			int inInt = ints[1];
			inArr[inInt]++;
			outArr[outInt]++;
		}
		for (int i = 1; i <= n; i++) {
			if (inArr[i] == n - 1 && outArr[i] == 0) {
				return i;
			}
		}
		return -1;
		
	}
}

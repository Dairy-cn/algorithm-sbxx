package com.dair.sbxx.year2022.day03;

/**
 * @author Dair
 * @since
 */
public class Test3 {
	
	/**
	 * 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
	 * <p>
	 * 实部 是一个整数，取值范围是 [-100, 100]
	 * 虚部 也是一个整数，取值范围是 [-100, 100]
	 * i2 == -1
	 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
	 * <p>
	 *  
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：num1 = "1+1i", num2 = "1+1i"
	 * 输出："0+2i"
	 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
	 * 示例 2：
	 * <p>
	 * 输入：num1 = "1+-1i", num2 = "1+-1i"
	 * 输出："0+-2i"
	 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String complexNumberMultiply(String num1, String num2) {
		String[] str1 = num1.split("\\+");
		String[] str2 = num2.split("\\+");
		
		int a = Integer.valueOf(str1[0]) * Integer.valueOf(str2[0]);
		int b = Integer.valueOf(str1[0]) * Integer.valueOf(str2[1].replace("i", ""));
		int c = Integer.valueOf(str2[0]) * Integer.valueOf(str1[1].replace("i", ""));
		int d = Integer.valueOf(str1[1].replace("i", "")) * Integer.valueOf(str2[1].replace("i", ""));
		
		String res = (a + d * -1) +"+"+( (b + c) + "i");
		return res;
	}
	
	public static void main(String[] args) {
		
		System.out.println(0%1);
		System.out.println(0/1);
		
		
		System.out.println(new Test3().complexNumberMultiply("1+-1i", "1+-1i"));
	}
}

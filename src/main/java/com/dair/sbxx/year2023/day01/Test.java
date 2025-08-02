package com.dair.sbxx.year2023.day01;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
	 * <p>
	 * 最初，黑板上有一个数字n。在每个玩家的回合，玩家需要执行以下操作：
	 * 4 1 2
	 * 选出任一x，满足0 < x < n且n % x == 0。
	 * 用 n - x替换黑板上的数字n 。 3 2
	 * 如果玩家无法执行这些操作，就会输掉游戏。
	 * <p>
	 * 只有在爱丽丝在游戏中取得胜利时才返回true。假设两个玩家都以最佳状态参与游戏。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode.cn/problems/divisor-game
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param n
	 * @return
	 */
	public boolean divisorGame(int n) {
		boolean flg = false;
		while (n > 1) {
			n = n - 1;
			flg=!flg;
			
		}
		return flg;
	}
	
	public static void main(String[] args) {
		System.out.println(new Test().divisorGame(2));
		
	}
}

package com.dair.sbxx.year2021.day84;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dair
 * @since
 */
public class Test {
	/**
	 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
	 * <p>
	 * 我们这样定义「子文件夹」：
	 * <p>
	 * 如果文件夹folder[i]位于另一个文件夹folder[j]下，那么folder[i]就是folder[j]的子文件夹。
	 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
	 * <p>
	 * /后跟一个或者多个小写英文字母。
	 * 例如，/leetcode和/leetcode/problems都是有效的路径，而空字符串和/不是。
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	public List<String> removeSubfolders(String[] folder) {
		Map<String, List<String>> listMap = new HashMap<>();
//		"/a","/a/b","/c/d","/c/d/e","/c/f"
		for (String s : folder) {
			if (s != "") {
			
			}
		}
		return null;
	}
}

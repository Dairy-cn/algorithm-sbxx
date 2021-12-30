package com.dair.sbxx.day71;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	private Trie trie = new Trie();
	
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i] == "") {
				continue;
			}
			//判断当前字符串是否存在
			if (dfs(words[i], 0)) {
				ans.add(words[i]);
			} else {
				trie.insert(words[i]);
			}
		}
		return ans;
	}
	
	private boolean dfs(String word, int start) {
		if (start >= word.length()) {
			return true;
		}
		//cat cats catcats
		Trie node = trie;
		for (; start < word.length(); start++) {
			int index = word.charAt(start) - 'a';
			node = node.nodes[index];
			if (node == null) {
				return false;
			}
			if (node.isEnd) {
				if(dfs(word, start+1)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	class Trie {
		
		private Trie[] nodes;
		
		private boolean isEnd;
		
		public Trie() {
			nodes = new Trie[26];
			isEnd = false;
		}
		
		public void insert(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				if (node.nodes[index] == null) {
					node.nodes[index] = new Trie();
				}
				node = node.nodes[index];
			}
			node.isEnd = true;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Test2().findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
	}
}

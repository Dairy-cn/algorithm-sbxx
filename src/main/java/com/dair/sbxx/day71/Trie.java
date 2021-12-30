package com.dair.sbxx.day71;

/**
 * @author Dair
 * @since
 */
public class Trie {
	
	private Trie[] nodes=null;
	
	private boolean isEnd;
	
	public Trie() {
		nodes=new Trie[26];
		isEnd=false;
	}
	
	public void insert(String word) {
		
		int n=word.length();
		Trie node=this;
		for(int i=0;i<n;i++){
			int index=word.charAt(i)-'a';
			if(node.nodes[index]==null){
				node.nodes[index]=new Trie();
			}
			node=node.nodes[index];
		}
		isEnd=true;
	}
	
	public boolean search(String word) {
		Trie node=searchPreFix(word);
		return node!=null && node.isEnd;
	}
	
	public boolean startsWith(String prefix) {
		Trie node=searchPreFix(prefix);
		return node!=null ;
	}
	
	private Trie searchPreFix(String word){
		int n=word.length();
		Trie node=this;
		for(int i=0;i<n;i++){
			int index=word.charAt(i)-'a';
			if(node.nodes[index]==null){
				return null;
			}
			node=node.nodes[index];
		}
		return node;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
	}
}
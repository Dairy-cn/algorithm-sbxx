package com.dair.sbxx.day29;

/**
 * @author Dair
 * @since
 */
public class MyHashMap<K, V> {
	
	static class Node<K, V> {
		
		private K key;
		
		private V value;
		
		private Node<K, V> next;
		
		public Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public K getKey() {
			return key;
		}
		
		public void setKey(K key) {
			this.key = key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		
		public Node<K, V> getNext() {
			return next;
		}
		
		public void setNext(Node<K, V> next) {
			this.next = next;
		}
	}
	
	
	private Node[] tables;
	
	
	public MyHashMap() {
		this.tables = new Node[16];
	}
	
	
	public int hash(K key) {
		int h = 0;
		return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
	}
	
	public Node<K, V> getTables(int hashCode) {
		
		int n = tables.length;
		int index = (n - 1) & hashCode;
		return tables[index];
	}
	
	public V get(K key) {
		//通过key hash后取模通过index获取Node
		Node<K, V> node = getTables(hash(key));
		if (node != null) {
			while (node != null) {
				K k = node.key;
				if (k == key || key.equals(k)) {
					return node.value;
				} else {
					node = node.next;
				}
			}
		}
		return null;
	}
	
	
	public V put(K key, V value) {
		int hash = hash(key);
		int length = tables.length;
		int index = (length - 1) & hash;
		if (tables[index] == null) {
			tables[index] = new Node(key, value, null);
		} else {
			Node table = tables[index];
			if (hash((K) table.key) == hash && (key == table.key || (key != null && key.equals(table.key)))) {
				V oldValue = (V) table.getValue();
				table.setValue(value);
				return oldValue;
			} else {
				while (table.next != null) {
					table = table.next;
					if (hash((K) table.key) == hash  && (key == table.key || (key != null && key.equals(table.key)))) {
						V oldValue = (V) table.getValue();
						table.setValue(value);
						return oldValue;
					}
				}
				table.next = new Node(key, value, null);
			}
		}
		return null;
	}
}

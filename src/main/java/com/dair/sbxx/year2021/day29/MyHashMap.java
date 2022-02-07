package com.dair.sbxx.year2021.day29;

/**
 * @author Dair
 * @since
 */
public class MyHashMap<K, V> {
	
	
	/**
	 * 链表
	 *
	 * @param <K>
	 * @param <V>
	 */
	static class Node<K, V> {
		
		final K key;
		
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
	
	/**
	 * 初始化为16的容量
	 */
	public MyHashMap() {
		this.tables = new Node[16];
	}
	
	/**
	 * 扰动函数
	 * key.hashCode()=》int类型
	 * hashCode 与 hashCode>>>16 做异或运算，
	 * 混合原始hashCode的高位和低位，以此来加大低位的随机数
	 * 加入高位的一些特征，这样保留的信息就是高位信息+低位信息
	 *
	 *通过扰动函数返回的hash值减少为hash碰撞
	 * @param key
	 * @return
	 */
	static final int hash(Object key) {
		int h = 0;
		return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
	}
	
	public Node<K, V> getTables(int hashCode) {
		
		int n = tables.length;
		int index = indexFor(hashCode, n);
		return tables[index];
	}
	
	public V get(K key) {
		//通过key hash后取模通过index获取Node
		Node<K, V> node = getTables(hash(key));
		if (node != null) {
			while (node != null) {
				K k = node.key;
				if ((hash(key) == hash(k)) && (k == key || (key != null && key.equals(k)))) {
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
		int index = indexFor(hash, length);
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
					if (hash((K) table.key) == hash && (key == table.key || (key != null && key.equals(table.key)))) {
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
	
	/**
	 * 根据hash值和数组长度做与运算，(length-1）后正好是
	 * 数组长度的低位掩码，与散列值做"与"操作后，消除高位，
	 * 只保留低位
	 *
	 * @param hash   散列值
	 * @param length 数组长度，要求为2的整数幂
	 * @return
	 */
	static int indexFor(int hash, int length) {
		return (length - 1) & hash;
	}
}

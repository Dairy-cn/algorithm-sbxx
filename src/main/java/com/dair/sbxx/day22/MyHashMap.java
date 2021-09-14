//package com.dair.sbxx.day22;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author Dair
// * @since
// */
//public class MyHashMap<K, V> implements Map<K, V> {
//
//
//	static class Node<K, V> implements Map.Entry<K, V> {
//
//		int hash;
//
//		K key;
//
//		V value;
//
//		Node<K, V> next;
//
//		public Node(int hash, K key, V value, Node<K, V> next) {
//			this.hash = hash;
//			this.key = key;
//			this.value = value;
//			this.next = next;
//		}
//
//		@Override
//		public K getKey() {
//			return key;
//		}
//
//		@Override
//		public V getValue() {
//			return value;
//		}
//
//		@Override
//		public V setValue(V value) {
//			V oldValue = this.value;
//			this.value = value;
//			return oldValue;
//		}
//	}
//
//	static final int hash(Object k) {
//		int h;
//		return k == null ? 0 : (h = k.hashCode()) ^ (h >>> 16);
//
//	}
//
//	@Override
//	public int size() {
//		return 0;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return false;
//	}
//
//	@Override
//	public boolean containsKey(Object key) {
//		return false;
//	}
//
//	@Override
//	public boolean containsValue(Object value) {
//		return false;
//	}
//
//	@Override
//	public V get(Object key) {
//		Node<K, V> node;
//		return hash(key);
//	}
//
//
//	public Node<K, V> getNode(int h, Object key) {
//
//	}
//
//	@Override
//	public Object put(Object key, Object value) {
//		int h = hash(key);
//		//1、扩容
//
//		//2、确认位置，如果链表为空，新增
//
//		//3、链表不为空，则返回旧值并修改值
//
//
//		return null;
//	}
//
//	@Override
//	public Object remove(Object key) {
//		return null;
//	}
//
//	@Override
//	public void putAll(Map m) {
//
//	}
//
//	@Override
//	public void clear() {
//
//	}
//
//	@Override
//	public Set keySet() {
//		return null;
//	}
//
//	@Override
//	public Collection values() {
//		return null;
//	}
//
//	@Override
//	public Set<Entry> entrySet() {
//		return null;
//	}
//}

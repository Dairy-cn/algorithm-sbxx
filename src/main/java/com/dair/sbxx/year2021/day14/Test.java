package com.dair.sbxx.year2021.day14;

import java.util.*;

/*************************************************************
 * Description: 
 * Author: Dair
 * Date: year2021/6/22
 ************************************************************/
public class Test {
	
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("www.baidu.com");
		list.add("www.baidu.com");
		list.add("www.baidu.com1");
		list.add("www.baidu.com2");
		list.add("www.baidu.com3");
		list.add("www.baidu.com1");
		list.add("www.baidu.com2");
		list.add("www.baidu.com1");
		list.add("www.baidu.com1");
		
		print(list,3);
	}
	
	
	private static void print(List<String> list, Integer n){
		if(list==null || list.size()==0){
			return;
		}
		HashMap map=new HashMap<String,Integer>();
		for (String s : list) {
			Integer count= (Integer) map.get(s);
			if(count==null){
				count=1;
			}else {
				++count;
			}
			map.put(s,count);
		}
		List<Map.Entry<String,Integer>> entries=new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				Integer int1=o1.getValue();
				Integer int2=o2.getValue();
				return int2-int1;
			}
		});
		int index=1;
		for (Map.Entry<String, Integer> entry : entries) {
			if(index++<=n){
				System.out.println("url为："+entry.getKey()+"的出现次数为："+entry.getValue());
			}else {
				break;
			}
		}
		
	}
}

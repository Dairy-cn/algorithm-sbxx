package com.dair.sbxx.day72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public String[] findOcurrences(String text, String first, String second) {
		String[] s = text.split(" ");
		List<String> list = new ArrayList<>();
		for (int i = 2; i < s.length; i++) {
			if (s[i - 2].equals(first) && s[i - 1].equals(second)) {
				list.add(s[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}
		public static void main (String[]args){
			System.out.println(new Test2().findOcurrences("obo jvezipre obo jnvavldde jvezipre jvezipre jnvavldde jvezipre jvezipre jvezipre y jnvavldde jnvavldde obo jnvavldde jnvavldde obo jnvavldde jnvavldde jvezipre",
					"jnvavldde", "y"));
		}
		
		
	}

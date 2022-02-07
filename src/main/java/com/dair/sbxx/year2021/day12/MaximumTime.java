package com.dair.sbxx.year2021.day12;




/**
 * @author Dair
 * @since
 */
public class MaximumTime {
	
	
	public String solution(String time){
		if (time == null || time.equals("")) {
			return time;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < time.length(); i++) {
			if (time.charAt(i) == ':' || time.charAt(i) != '?') {
				stringBuilder.append(time.charAt(i));
				continue;
				
			}
			switch (i) {
				case 0:
					if (time.charAt(i + 1) != '?' && time.charAt(i + 1) > '3') {
						stringBuilder.append(1);
					} else {
						stringBuilder.append(2);
					}
					break;
				case 1:
					if (stringBuilder.charAt(i - 1) != '2')
						stringBuilder.append('9');
					else
						stringBuilder.append('3');
					break;
				case 2:
					stringBuilder.append(':');
					break;
				case 3:
					stringBuilder.append('5');
					break;
				case 4:
					stringBuilder.append('9');
					break;
				default:
					break;
			}
			
		}
		ThreadLocal threadLocal=new ThreadLocal();
		threadLocal.set("sss");
		return stringBuilder.toString();
		
	}
}

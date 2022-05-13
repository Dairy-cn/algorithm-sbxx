package com.dair.sbxx.year2022.day15;

/**
 * @author Dair
 * @since
 */
public class Test2 {
	
	public static void main(String[] args) {
		
		
		String[] arr1 = new String[1];
		String[] arr2 = new String[2];
		StringBuilder sb = new StringBuilder("insert into `t_chg_common_config` (`config_type`," +
				" `config_key`, " +
				"`config_value_one`, " +
				"`config_value_second`, " +
				"`config_desc`, `create_user`, `create_date`, `last_upd_user`, `last_upd_date`, `enable_flg`) values('productDomainNameSuffix',");
		
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < arr1.length; i++) {
			out.append(sb);
			out.append("'" + arr1[i] + "',");
			out.append("'" + arr1[i] + "',");
			out.append("'" + arr2[i] + "',");
			out.append("'生产域名后缀" + (i + 12) + "" + arr1[i] + "',");
			out.append("'admin',");
			out.append("SYSDATE(),");
			out.append("'admin',");
			out.append("SYSDATE(),");
			out.append("'1');\n");
		}
		Integer b1 = Integer.valueOf(111111111);
		int a1 = 111111111;
		
		Integer c1 = 128;
		System.out.println(a1 == b1);
		System.out.println(c1 == b1);
	}
	
	
}

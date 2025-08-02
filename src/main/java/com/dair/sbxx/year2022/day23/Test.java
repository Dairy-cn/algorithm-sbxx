package com.dair.sbxx.year2022.day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dair
 * @since
 */
public class Test {
	
	private static long checkId = 200;
	
	public static void main(String[] args) throws IOException {
		int count = 1000;
		String sql = "insert into `t_quality_plan_sx` (  `id`,`plan_code`, `plan_name`, `project_code`, " +
				"`project_name`, `sys_code`, `sys_name`, `plan_content`, " +
				"`creater_name`, `is_out`, `plan_start`, `plan_end`, " +
				"`plan_status`, `reason`, `creater`, `create_date`," +
				" `updater`, `update_date`, `enable_flg`)" +
				" values (";
		int year = 2019;
		String palnCode = "P";
		StringBuilder sb = new StringBuilder();
		
		String[] status = new String[]{"save", "new", "dealing", "pause", "finished"};
		String minusHoursDateThree = "2019-01-01 00:00:00";
		
		String minusHoursDateTwfour = "2022-07-30 23:59:59";
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			sb.append(sql);
			long id = 500 + i;
			sb.append("'" + id + "',");
			Date start = Test.randomDate(minusHoursDateThree, minusHoursDateTwfour);
			String nowDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start);
			String codeStr = new SimpleDateFormat("yyyyMMdd").format(start);
			map.put(codeStr, map.getOrDefault(codeStr, 0) + 1);
			sb.append("'" + palnCode + codeStr + Test.makeUpZero(Long.valueOf(i + 1), 4) + "',");
			sb.append("'压测计划" + Test.makeUpZero(Long.valueOf(i + 1), 4) + "',");
			sb.append("'PJ2022A028','测试0216','T0001619','集团2017IT管理云平台','检查测试缺陷结果','徐晓梅','0',");
			
			sb.append("'" + nowDateStr + "',");
			Date end = Test.randomDate(nowDateStr, minusHoursDateTwfour);
			String endStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(end);
			sb.append("'" + endStr + "',");
			String status1 = status[i % status.length];
			sb.append("'" + status1 + "',");
			sb.append("'测试',");
			sb.append("'xuxiaomei-008',");
			sb.append("'" + nowDateStr + "','xuxiaomei-008',");
			sb.append("'" + nowDateStr + "','1')");
			sb.append(";\n");
			String s = taskSql(2700 + (i * 10), id, codeStr, map.get(codeStr) - 1, nowDateStr, endStr, status1);
			sb.append(s);
			
		}
		System.out.println(sb.toString());
		
		try {
			File fileOutputStream = new File("c:\\Users\\dairui-004\\Desktop\\1444411.sql");
			FileWriter fileWriter = new FileWriter(fileOutputStream);
			fileWriter.write(sb.toString());
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 自动补0
	 *
	 * @param value
	 * @return
	 */
	public static String makeUpZero(Long value, Integer length) {
		String str = String.valueOf(value);
		if (str.length() >= length) {
			return str;
		}
		int num = length - str.length();
		String zero = "";
		for (int i = 0; i < num; i++) {
			zero += "0";
		}
		return zero + str;
	}
	
	private static Date randomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);
			Date end = format.parse(endDate);
			
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}
	
	private static String taskSql(long id, Long planId, String codeStr, Integer count, String startDate, String endDate, String planStatus) {
		String sql = "insert into `t_quality_plan_task_sx` (`id`,`plan_id`, " +
				"`task_code`, `task_name`, `task_type`, `project_name`," +
				" `project_code`, `sys_name`, `sys_code`, `task_content`," +
				" `creater_name`, `dev_team_code`, `dev_team`, `implementer_p13`, " +
				"`implementer_name`, `task_start`, `task_end`, `check_object`, " +
				"`check_type`, `check_son`, `versions`, `programs`, `audit_report_name`, " +
				"`real_start`, `real_end`, `workload`, `task_status`, `pre_task_status`," +
				" `execute_content`, `suspend_reason`, `reassignment_reason`, `is_out`, `creater`," +
				" `create_date`, `updater`, `update_date`, `enable_flg`) " +
				"values(";
		StringBuilder sb = new StringBuilder();
		String taskCode = "QA";
		String[] status = new String[]{"save"};
		String[] types = new String[]{"质量审计", "通用-审计","质量复盘", "通用-非审计", "通用-非审计", "质量内审","质量总结","文件评审","质量改进","质量总结"};
		for (int i = 0; i < 10; i++) {
			sb.append(sql);
			long taskId = id + i;
			sb.append("'" + taskId + "',");
			sb.append("'" + planId + "',");
			sb.append("'" + taskCode + codeStr + Test.makeUpZero(Long.valueOf(i + 1 + (count * 10)), 4) + "',");
			sb.append("'压测任务" + Test.makeUpZero(Long.valueOf(i + 1 + (count * 10)), 4) + "',");
			String type = types[i % types.length];
			sb.append("'" + type + "',");
			
			sb.append("'测试0216','PJ2022A028','集团2017IT管理云平台','T0001619','任务测试1测试任务2','徐晓梅',");
			String status1 = "";
			if (planStatus.equals("finished")) {
				status1 = "finished";
			} else if (planStatus.equals("dealing")) {
				status1 = "status";
			} else if (planStatus.equals("pause")) {
				status1 = "pause";
			} else {
				status1 = status[i % status.length];
			}
			sb.append("'G00000010104,TB10053008','集团公司/集团信息技术中心,共享平台事业群','xuxiaomei-008','徐晓梅',");
			sb.append("'" + startDate + "',");
			sb.append("'" + endDate + "',");
			sb.append("'需求','交付物检查','代码','2022-08-17','1','2',");
			sb.append("'" + startDate + "',");
			sb.append("'" + endDate + "',");
			sb.append("'1',");
			sb.append("'" + status1 + "',");
			sb.append("'save','1',NULL,NULL,'0',");
			sb.append("'xuxiaomei-008',");
			sb.append("'" + startDate + "','xuxiaomei-008',");
			sb.append("'" + startDate + "','1')");
			sb.append(";\n");
			
			if ("质量审计".equals(type) || "质量内审".equals(type)) {
				String sss = checkSql(planId, taskId);
				sb.append(sss);
			}
		}
		return sb.toString();
	}
	
	
	private static String checkSql(Long planId, Long taskId) {
		String sql = "insert into `t_quality_plan_task_check_sx` (`id`,`plan_id`, `task_id`, `programs`, `project_name`, `project_code`, `sys_name`, `sys_code`, `versions`, `real_start`, `real_end`, `dev_team_code`, `dev_team`, `project_manager_p13`, `project_manager`, `quality_p13`, `quality_name`, `num1`, `num1_lv`, `num2`, `num2_lv`, `num3`, `num3_lv`, `num4`, `num4_lv`, `num5`, `num5_lv`, `coincidence`, `result_content`, `summarize`, `task_status`, `send_mails_flg`, `send_mails_p13`, `send_mails`, `copy_mails_p13`, `copy_mails`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values" +
				"(";
		StringBuilder sb = new StringBuilder(sql);
		Long id = checkId++;
		sb.append("'" + id + "',");
		sb.append("'" + planId + "',");
		sb.append("'" + taskId + "',");
		sb.append("'111','','','集团2017IT管理云平台','T0001619','2022-08-08','2022-08-15 00:00:00','2022-09-08 23:59:59','TB10053008','共享平台事业群','yening-003','叶宁','jiaguimin','贾桂敏','5','71.43%','1','14.29%','1','14.29%','0','0.00%','7','100%','80.00%','RTETRErrrrrr','HFDHDHFHrrrrrrrrr',NULL,'1','xuxiaomei-008,chenjialuo','徐晓梅,陈伽罗','chenjialuo','陈伽罗','baijun-001','2022-08-08 15:59:20','jiaguimin','2022-08-11 16:30:32','1');\n");
		sb.append(checkItem(id));
		sb.append(checkItemRes(id));
		return sb.toString();
	}
	
	private static String checkItem(Long id) {
		String sql = "insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','1','检查项编号','质量管理-000001','1','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','2','检查项名称','测试报告检查测试报告检查测试报告检查测试报告检查测试报告检查测试报告检查测试报告检查测试报告检查测试','2','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','3','检查项内容','检查测试用例、测试脑图，测试工作是否规范，测试效率等检查测试用例、测试脑图，测试工作是否规范，测试效','3','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','4','检查项等级','5','4','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','5','参考标准','检查测试用例、测试脑图，测试工作是否规范，测试效率等检查测试用例、测试脑图，测试工作是否规范，测试效','5','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','6','检查对象','检查测试用例、测试脑图，测试工作是否规范，测试效率等检查测试用例、测试脑图，测试工作是否规范，测试效','6','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','7','适用项目类型','所有检查测试用例、测试脑图，测试工作是否规范，测试效率等检查测试用例、测试脑图，测试工作是否规范，测','7','1','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','1','检查项编号','质量管理-000002','1','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','2','检查项名称','测试报告','2','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','3','检查项内容','测试报告内容','3','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','4','检查项等级','2','4','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','5','参考标准','检查内容是否完整','5','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','6','检查对象','测试报告','6','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n" +
				"insert into `t_quality_check_item_sx` (`check_id`, `sign_code`, `clu_name_id`, `clu_name`, `item`, `clu_order_num`, `order_num`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','7','适用项目类型','集团项目','7','2','baijun-001','2022-08-08 15:59:20','baijun-001','2022-08-08 15:59:20','1');\n";
		
		sql.replace("" + id + "", "'" + id + "'");
		return sql;
	}
	
	private static String checkItemRes(Long id) {
		String sql = "insert into `t_quality_check_item_result_sx` (`check_id`, `sign_code`, `result`, `defect_des`, `remark`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000001','1','RERERE','RERERE','jiaguimin','2022-08-11 16:30:32','jiaguimin','2022-08-11 16:30:32','1');\n" +
				"insert into `t_quality_check_item_result_sx` (`check_id`, `sign_code`, `result`, `defect_des`, `remark`, `creater`, `create_date`, `updater`, `update_date`, `enable_flg`) values(" + id + ",'质量管理-000002','2','r','r','jiaguimin','2022-08-11 16:30:32','jiaguimin','2022-08-11 16:30:32','1');\n";
		
		return sql;
	}
}

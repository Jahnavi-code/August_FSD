package com.hexaware.lms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplyLeaveInsert {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/lms/jdbc.xml");
		LeaveHistoryDao dao = (LeaveHistoryDao)ctx.getBean("leaveHistoryDao");
		LeaveHistory history = new LeaveHistory();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employ Id  ");
		history.setEmpId(sc.nextInt());
		
		System.out.println("Enter LeaveStart-Date  (yyyy-MM-dd)  ");
		String str = sc.next();
		java.util.Date ud1 = sdf.parse(str);
		java.sql.Date sq1 = new java.sql.Date(ud1.getTime());
		history.setLeaveStartDate(sq1);
		
		System.out.println("Enter LeaveEnd-Date  (yyyy-MM-dd)  ");
		str = sc.next();
		ud1 = sdf.parse(str);
		sq1 = new java.sql.Date(ud1.getTime());
		history.setLeaveEndDate(sq1);
		
		System.out.println("Enter Leave Type (EL/PL/ML)  ");
		history.setLeaveType(sc.next());
		
		System.out.println("Enter Leave Reason ");
		history.setLeaveReason(sc.next());
		
		System.out.println(dao.applyLeave(history));
	}
}

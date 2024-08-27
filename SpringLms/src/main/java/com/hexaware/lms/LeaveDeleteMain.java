package com.hexaware.lms;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LeaveDeleteMain {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/lms/jdbc.xml");
		LeaveHistoryDao dao = (LeaveHistoryDao)ctx.getBean("leaveHistoryDao");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter leave id: ");
		int leaveId = sc.nextInt();
		System.out.println(dao.deleteLeaveById(leaveId));
	}
}

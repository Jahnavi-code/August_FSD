package com.hexaware.lms;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LeaveShowMain {
	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/lms/jdbc.xml");
		LeaveHistoryDao dao = (LeaveHistoryDao)ctx.getBean("leaveHistoryDao");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter leaveId: ");
		int leaveId = sc.nextInt();
		LeaveHistory history = dao.getLeaveDetailsById(leaveId);
		
		if (history != null) {
            System.out.println("Leave ID: " + history.getLeaveId());
            System.out.println("Employ ID: " + history.getEmpId());
            System.out.println("Leave Start Date: " + history.getLeaveStartDate());
            System.out.println("Leave End Date: " + history.getLeaveEndDate());
            System.out.println("Number of Days: " + history.getNoOfDays());
            System.out.println("Leave Type: " + history.getLeaveType());
            System.out.println("Leave Status: " + history.getLeaveStatus());
            System.out.println("Leave Reason: " + history.getLeaveReason());
        } else {
            System.out.println("No leave details found for the given Leave Id.");
        }
	}
}

package com.hexaware.lms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LeaveUpdateMain {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/lms/jdbc.xml");
		LeaveHistoryDao dao = (LeaveHistoryDao) ctx.getBean("leaveHistoryDao");
		LeaveHistory history = new LeaveHistory();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Leave Id to update: ");
		int leaveId = sc.nextInt();

		history = dao.getLeaveDetailsById(leaveId);
		if (history == null) {
			System.out.println("No record found for the given Leave Id.");
		} else {
			System.out.println("Enter new Employ Id (Current: " + history.getEmpId() + "): ");
			history.setEmpId(sc.nextInt());

			System.out.println("Enter new Leave Start Date (yyyy-MM-dd) (Current: " + history.getLeaveStartDate() + "): ");
			String str = sc.next();
			java.util.Date ud1 = sdf.parse(str);
			java.sql.Date sq1 = new java.sql.Date(ud1.getTime());
			history.setLeaveStartDate(sq1);

			System.out.println("Enter new Leave End Date (yyyy-MM-dd) (Current: " + history.getLeaveEndDate() + "): ");
			str = sc.next();
			ud1 = sdf.parse(str);
			sq1 = new java.sql.Date(ud1.getTime());
			history.setLeaveEndDate(sq1);

			System.out.println("Enter new Leave Type (Current: " + history.getLeaveType() + "): ");
			history.setLeaveType(sc.next());

			System.out.println("Enter new Leave Reason (Current: " + history.getLeaveReason() + "): ");
			history.setLeaveReason(sc.next());

			System.out.println("Enter new Manager Comments (Current: " + history.getManagerComments() + "): ");
			sc.nextLine();  // Consume the newline
			history.setManagerComments(sc.nextLine());

			// Calculate and update the number of days
			long days = (history.getLeaveEndDate().getTime() - history.getLeaveStartDate().getTime()) / (1000 * 60 * 60 * 24) + 1;
			history.setNoOfDays((int) days);

			// Set leave status as PENDING
			history.setLeaveStatus("PENDING");

			System.out.println(dao.updateLeaveDetails(history));
		}
	}
}

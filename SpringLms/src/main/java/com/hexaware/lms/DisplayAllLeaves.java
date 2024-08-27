package com.hexaware.lms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class DisplayAllLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/hexaware/lms/jdbc.xml");
		LeaveHistoryDao dao = (LeaveHistoryDao) ctx.getBean("leaveHistoryDao");
		
		 List<LeaveHistory> leaveList = dao.displayAllLeaveDetails();
	        
	        // Check if the list is empty
	        if (leaveList.isEmpty()) {
	            System.out.println("No leave records found.");
	        } else {
	            // Iterate through the list and print each leave record
	            for (LeaveHistory leave : leaveList) {
	                System.out.println(leave);
	            }
	        }
	}

}

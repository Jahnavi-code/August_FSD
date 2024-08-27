package com.hexaware.lms;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class LeaveHistoryDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String applyLeave(LeaveHistory history) {
		java.util.Date d1 = new java.util.Date(history.getLeaveStartDate().getTime());
		java.util.Date d2 = new java.util.Date(history.getLeaveEndDate().getTime());
		long days = (d2.getTime() - d1.getTime())/(1000*60*60*24);
		days++;
		int d = (int)days;
		history.setNoOfDays(d);
		history.setLeaveStatus("PENDING");
		String cmd = "Insert into Leave_History(EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE, "
				+ " LEAVE_NO_OF_DAYS, LEAVE_TYPE, LEAVE_STATUS, LEAVE_REASON) "
				+ " values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {history.getEmpId(), history.getLeaveStartDate(),
			history.getLeaveEndDate(), history.getNoOfDays(), history.getLeaveType(),
			history.getLeaveStatus(), history.getLeaveReason()
			});
		return "Leave Applied...";
	}
	
	public LeaveHistory getLeaveDetailsById(int leaveId) {
		String cmd = "SELECT * FROM leave_history WHERE leave_id = ?";
		return jdbcTemplate.queryForObject(cmd, new Object[] { leaveId },
				new BeanPropertyRowMapper<>(LeaveHistory.class));
	}
	
	 public List<LeaveHistory> displayAllLeaveDetails() {
	        String cmd = "SELECT * FROM leave_history";
	        return jdbcTemplate.query(cmd, new BeanPropertyRowMapper<>(LeaveHistory.class));
	    }
	
	public String deleteLeaveById(int leaveId) {
		String cmd = "DELETE FROM leave_history WHERE leave_id = ?";
		int rowsAffected = jdbcTemplate.update(cmd, leaveId);
		if (rowsAffected > 0) {
			return "Record deleted successfully.";
		} else {
			return "No record found for the given Leave ID.";
		}
	}
	
	public String updateLeaveDetails(LeaveHistory history) {
		String cmd = "UPDATE leave_history SET EMP_ID = ?, LEAVE_START_DATE = ?, LEAVE_END_DATE = ?, "
				+ "LEAVE_NO_OF_DAYS = ?, LEAVE_TYPE = ?, LEAVE_STATUS = ?, LEAVE_REASON = ?, LEAVE_MNGR_COMMENTS = ? "
				+ "WHERE LEAVE_ID = ?";
		String result;
		int rowsAffected = jdbcTemplate.update(cmd, new Object[] { history.getEmpId(), history.getLeaveStartDate(),
				history.getLeaveEndDate(), history.getNoOfDays(), history.getLeaveType(), history.getLeaveStatus(),
				history.getLeaveReason(), history.getManagerComments(), history.getLeaveId() });
		if (rowsAffected > 0) {
			result = "Leave details updated successfully.";
		} else {
			result = "No record found for the given Leave ID.";
		}
		return result;
	}

	
	 
}

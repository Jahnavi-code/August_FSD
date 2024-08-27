package util;

import java.util.Date;

public class LeaveDetails {
	private int leaveId;
	private int empId;
	private LeaveType leaveType;
	private LeaveStatus leaveStatus;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String leaveReason;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public Date getLeaveStartDate() {
		return leaveStartDate;
	}
	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}
	public Date getLeaveEndDate() {
		return leaveEndDate;
	}
	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public LeaveDetails(int leaveId, int empId, LeaveType leaveType, LeaveStatus leaveStatus, Date leaveStartDate,
			Date leaveEndDate, String leaveReason) {
		super();
		this.leaveId = leaveId;
		this.empId = empId;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.leaveReason = leaveReason;
	}
	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", leaveType=" + leaveType + ", leaveStatus="
				+ leaveStatus + ", leaveStartDate=" + leaveStartDate + ", leaveEndDate=" + leaveEndDate
				+ ", leaveReason=" + leaveReason + "]";
	}
	
}

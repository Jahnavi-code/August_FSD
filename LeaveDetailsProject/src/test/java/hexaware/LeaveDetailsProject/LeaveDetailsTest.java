package hexaware.LeaveDetailsProject;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import util.LeaveDetails;
import util.LeaveStatus;
import util.LeaveType;

public class LeaveDetailsTest {

	
	@Test
	public void testConstructor() {
		
		LeaveDetails leavedetails = new LeaveDetails();
		assertNotNull(leavedetails);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Date leaveStartDate = null;
		Date leaveEndDate = null;
		
	            try {
					leaveStartDate = sdf.parse("2024-08-01");
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					leaveEndDate = sdf.parse("2024-08-05");
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
		LeaveDetails leavedetailsnew = new LeaveDetails(1,101,LeaveType.EL,LeaveStatus.ACCEPTED,leaveStartDate,leaveEndDate,"Vacation");
		assertNotNull(leavedetailsnew);
		assertEquals(1, leavedetailsnew.getLeaveId());
        assertEquals(101, leavedetailsnew.getEmpId());
        assertEquals(LeaveType.EL, leavedetailsnew.getLeaveType());
        assertEquals(LeaveStatus.ACCEPTED, leavedetailsnew.getLeaveStatus());
        assertEquals(leaveStartDate, leavedetailsnew.getLeaveStartDate());
        assertEquals(leaveEndDate, leavedetailsnew.getLeaveEndDate());
        assertEquals("Vacation", leavedetailsnew.getLeaveReason());
	}
	
		@Test
		public void testGetterSetter() {
			 LeaveDetails leavedetails = new LeaveDetails();
			 leavedetails.setLeaveId(1);
			 leavedetails.setEmpId(01);
			 leavedetails.setLeaveType(LeaveType.EL);
			 leavedetails.setLeaveStatus(LeaveStatus.ACCEPTED);
			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        Date leaveStartDate = null;
		        Date leaveEndDate = null;

		        try {
		            leaveStartDate = sdf.parse("2024-08-01");
		            leaveEndDate = sdf.parse("2024-08-05");
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
		        leavedetails.setLeaveStartDate(leaveStartDate);
		        leavedetails.setLeaveEndDate(leaveEndDate);
		        leavedetails.setLeaveReason("Vacation");
		        
		        assertEquals(1,leavedetails.getLeaveId());
		        assertEquals(01,leavedetails.getEmpId());
		        assertEquals(LeaveType.EL,leavedetails.getLeaveType());
		        assertEquals(LeaveStatus.ACCEPTED,leavedetails.getLeaveStatus());
		        assertEquals(leaveStartDate,leavedetails.getLeaveStartDate());
		        assertEquals(leaveEndDate,leavedetails.getLeaveEndDate());
		        assertEquals("Vacation",leavedetails.getLeaveReason());
		 }
		 @Test
		    public void testToString() {
		        String expected = "LeaveDetails [leaveId=1, empId=101, leaveType=EL, leaveStatus=ACCEPTED, leaveStartDate=Thu Aug 01 00:00:00 IST 2024, leaveEndDate=Mon Aug 05 00:00:00 IST 2024, leaveReason=Medical leave]";

		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		        Date leaveStartDate = null;
		        Date leaveEndDate = null;

		        try {
		            leaveStartDate = sdf.parse("2024-08-01");
		            leaveEndDate = sdf.parse("2024-08-05");
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }

		        LeaveDetails leaveDetails = new LeaveDetails(1, 101, LeaveType.EL, LeaveStatus.ACCEPTED, leaveStartDate, leaveEndDate, "Medical leave");
		        assertEquals(expected, leaveDetails.toString());
		    }
		}
	
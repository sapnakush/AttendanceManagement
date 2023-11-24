package codeAlpha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AttendanceManagementSystem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Map<String,List<Boolean>> studentAttendance=new HashMap<>();
		
		while(true) {
			System.out.println("Attendance Management System");
			System.out.println("1. Mark Attendance");
			System.out.println("2. View Attendance");
			System.out.println("3. Exit");
			System.out.print("Enter Your Choice : ");
			 
		    int choice = sc.nextInt();
		    
		    switch(choice) {
		      case 1:
		    	   markAttendance(studentAttendance,sc);
		    	   break;
		      case 2:
		    	   viewAttendance(studentAttendance);
		    	   break;
		      case 3:
		    	   System.out.println("Exiting System.");
		    	   break;
		      default:
		    	   System.out.println("Invalid choice, Please try again......");
		           break;
		    }
		
		}

	}
	private static void markAttendance(Map<String,List<Boolean>> studentAttendance,Scanner sc) {
		System.out.print("Enter Student's Name: ");
		String studentName=sc.next();
		
		if(studentAttendance.containsKey(studentName)) {
			studentAttendance.put(studentName, new ArrayList<>());
		}
		System.out.print("Is the student present? (y/n): ");
		char attendanceStatus=sc.next().charAt(0);
		
		boolean isPresent = attendanceStatus == 'y' || attendanceStatus == 'Y';
		studentAttendance.get(studentName).add(isPresent);
		
		System.out.println("Attendance Marked for "+studentName);
		}
	
	 private static void viewAttendance(Map<String,List<Boolean>> studentAttendance) {
		 System.out.println("Student Attendance: ");
		 for(Map.Entry<String ,List<Boolean>> entry : studentAttendance.entrySet()) {
			 String studentName=entry.getKey();
			 List<Boolean> attendanceList = entry.getValue();
			 int totalClasses = attendanceList.size();
			 long presentClasses = attendanceList.stream().filter(Boolean::booleanValue).count();
			 double attendancePercentage = (presentClasses/totalClasses)*100;
			 System.out.println(studentName + " Total Classes: "+totalClasses+", Present: "+presentClasses+", Aattendance: "+attendanceList);
		 }
	 }

}
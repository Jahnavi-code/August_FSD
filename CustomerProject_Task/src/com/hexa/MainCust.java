package com.hexa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
//import java.time.LocalDate;

public class MainCust {

	public static void main(String[] args) {
		//Add 10 records and print using foreach method
		List<Customer> custList = new ArrayList<Customer>();
		custList.add(new Customer(1,"Jahnavi","Narayanapuram", 82035.32, LocalDate.of(2002, 9, 02)));
		custList.add(new Customer(2,"Chandini","Delhi", 15600.87, LocalDate.of(2003, 8, 16)));
		custList.add(new Customer(3,"Pravalli","Jangareddygudem", 10000.56, LocalDate.of(2002, 5, 22)));
		custList.add(new Customer(4,"Navya","Mandapaka", 92005.90, LocalDate.of(2002, 4, 9)));
		custList.add(new Customer(5,"Madhavi","Kunchanapalli", 10489.32, LocalDate.of(2002, 10, 23)));
		custList.add(new Customer(6,"Gowthami","Koyyalagudem", 50090.80, LocalDate.of(2002, 6, 01)));
		custList.add(new Customer(7,"Jyothi","penugonda", 50069.45, LocalDate.of(2002, 4, 07)));
		custList.add(new Customer(8,"Kavya","Delhi", 12893.98, LocalDate.of(2002, 12, 29)));
		custList.add(new Customer(9,"Sravani","Bhimavaram", 20934.56, LocalDate.of(2002, 10, 02)));
		custList.add(new Customer(10,"Tulasi","Kunavaram", 11045.76, LocalDate.of(2002, 11, 25)));
		
		System.out.print("The Customer details are :");
		System.out.println();
		System.out.println();
		custList.forEach(x -> {
			System.out.println(x);
		});
		System.out.println();
		System.out.println("**********************************************");
		System.out.println();
		
		
		//display records whose premium > 80000
		System.out.println("The Customer details whose preemium is greater than 80000 are :");
		System.out.println();
		Stream<Customer> filter1 = custList.stream().filter(x -> x.getPremium() >= 80000);
		filter1.forEach(x -> {
			System.out.println(x);
		});
		System.out.println();
		System.out.println("**********************************************");
		System.out.println();
		
		
		
		
		//display who belongs to city delhi
		System.out.println("The customers who belongs to city delhi are: ");
		System.out.println();
		custList.stream().filter(x -> x.getCity().equals("Delhi")).forEach(y ->{
			System.out.println(y);
		});
		
		System.out.println();
		System.out.println("**********************************************");
		System.out.println();
		
		
		
		
		//display sorted by dateofbirth
		System.out.println("Customers list in Sorted Order accordinf to their date of birth:");
		System.out.println();
		Collections.sort(custList, (c1,c2) -> {
			return c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
		});
		custList.forEach(x -> {
			System.out.println(x);
		});
		
		System.out.println();
		System.out.println("**********************************************");
		System.out.println();
		
		
		
		
		//display sorted by custName
		System.out.println("Customers list in Sorted Order:");
		System.out.println();
		Collections.sort(custList, (c1,c2) -> {
			return c1.getCustName().compareTo(c2.getCustName());
		});
		custList.forEach(x -> {
			System.out.println(x);
		});
	}

}

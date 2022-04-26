package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = input.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			System.out.print("Id: ");
			int id = input.nextInt();
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Salary :");
			double salary = input.nextDouble();
			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = input.nextInt();
		Integer pos = position(list, idsalary);
		if (pos == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = input.nextDouble();
			list.get(pos).increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee emp : list) {
			System.out.println(emp);
		}

		input.close();

	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}

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
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				System.out.print("Id: ");
				id = input.nextInt();
			}

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

		Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = input.nextDouble();
			emp.increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee e : list) {
			System.out.println(e);
		}

		input.close();

	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {


	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatação de calendario para entrar no metodo date
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.print("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		//aqui temos as primeiras perguntas que botaremos informações.
		
		//instancia do trabalhador
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		//instancia de trabalhador recebendo nome, level da Classe workerLevel, o salario base como string, e a classe new Department
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for ( int i = 1; i<= n ; i++){         //de acordo com o numero de contratos para o programa saber quando para
			System.out.println("Enter contract #" + i + "data: ");
			System.out.print("Date (DD/MM//YYYY): ");
			//chamar variavel do tipo date
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (in hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract);//associamos um contrato ao trabalhador
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY) ");
		String monthAndYear = sc.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		
		System.out.println("Name: " + worker.getName());
		
		System.out.println("Department: " + worker.getDepartment().getName());
		
		System.out.println("Income for " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		
		
		
		sc.close();

	}

}

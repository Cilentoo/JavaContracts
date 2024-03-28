package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	//atributos de worker
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	//associações onde o worker tem 1 department e varios contracts
	//no caso de contracts que é uma composição tem muitos ele não é iniciado no construtor
	//aqui o instanciamos como uma lista do tipo array para que possamos criar as listas de contratos no program.java
	
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//implementando metodos,
	
	//1
	//adicionando contrato ao atributo contracts
	public void addContract(HourContract contract) { 
		contracts.add(contract);
	}
	
	//2
	//removendo contrato do atributo contracts
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	//3
	//calculo de quanto o trabalhador ganhou baseado em ano e mes
	
	public Double income(int year, int month) {
		Double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		//este codigo acima percorre um calendario com o metodo calendar,
		//as duas int sao para que saibamos qual o ano e o mes que queremos
		//o if mostra que se o mes informado no atributo int month e o ano int year for igual aos ints c_o metodo sum vai retornar ele mesmo mais o valor total do salario
		return sum;
	}
}

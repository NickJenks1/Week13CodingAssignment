package pet.store.contoller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {

	// Fields from PetStore.java
	private Long petStoreId;
	private String petStoreName;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreAddress;
	private String petStorePhone;
	private String petStoreZip;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();

	// Constructor with PetStore as parameter
	public PetStoreData(PetStore petStore) {
		petStoreId = petStore.getPetStoreId();
		petStoreName = petStore.getPetStoreName();
		petStoreCity = petStore.getPetStoreCity();
		petStoreState = petStore.getPetStoreState();
		petStoreAddress = petStore.getPetStoreAddress();
		petStorePhone = petStore.getPetStorePhone();
		petStoreZip = petStore.getPetStoreZip();

		for (Customer customer : petStore.getCustomers()) {
			PetStoreCustomer petStoreCustomer = new PetStoreCustomer(customer);
			customers.add(petStoreCustomer);
		}
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreCustomer {

		// Fields from Customer.java
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

		// Constructor with Customer as parameter
		public PetStoreCustomer(Customer customer) {
			customerId = customer.getCustomerId();
			customerFirstName = customer.getCustomerFirstName();
			customerLastName = customer.getCustomerLastName();
			customerEmail = customer.getCustomerEmail();
		}
	}

	@Data
	@NoArgsConstructor
	public static class PetStoreEmployee {

		// Fields from Employee.java
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeeJobTitle;
		private String employeePhone;

		// Constructor with Employee as parameter
		public PetStoreEmployee(Employee employee) {
			employeeId = employee.getEmployeeId();
			employeeFirstName = employee.getEmployeeFirstName();
			employeeLastName = employee.getEmployeeLastName();
			employeeJobTitle = employee.getEmployeeJobTitle();
			employeePhone = employee.getEmployeePhone();
		}
	}
}

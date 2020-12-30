
public class TestSystem {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setPassword(2222);
		
		Administrator administrator = new Administrator();
		administrator.setPassword(221);

		Costumer costumer = new Costumer();
		costumer.setPassword(231);
		
		InternalSystem internalSystem = new InternalSystem();
		internalSystem.authenticate(manager);
		internalSystem.authenticate(administrator);
		internalSystem.authenticate(costumer);
		
	}

}

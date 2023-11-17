
public abstract class Animals {

	//specification of the given subject
	int age; 
	String gender; 
	int weight;  
	
	
	public Animals ( int age, String gender, int weight) {
		
		this.age = age; 
		this.gender = gender;
		this.weight= weight; 
		
	}
	
	// creating the methods( function for the given subject )
	
	public void eat() {
		System.out.println("eating .........");
	}
	
	public void speak() {
		
		System.out.println("I am "+ age + "years old ");
		System.out.println("I am" + gender);
		System.out.println(" I weight about " + weight);
	}
	
	public void sleep() {
		System.out.println(" sleeping..........");
	}
	
	
	//specific method (different specification )
	public abstract void move();
		
	

	
}
 
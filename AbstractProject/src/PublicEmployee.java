
public class PublicEmployee extends AbstractEmployee {
	
	public PublicEmployee() {
		
	}
	public String chgName(String name) {
		this.name = name;
		return name;
	}
	public void printName() {
		System.out.println(name);
	}
}

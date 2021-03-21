
public class User {
	/*For the User class the fields needed are:
	 * Name, age, city, state, dissabilities, and
	 * number of families.
     * 
     * I added simple setters and getters and some boolean methods 
     * that decide whether or not the user is a minor
	 * */
	private String name;
	private int age;
	private String city;
	private String state;
	private String disabilities;
	private int numOfFamMembers;
	public User(String name, int age, String city, String state, String disabilities, int numOfFamMembers) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.state = state;
		this.disabilities = disabilities;
		this.numOfFamMembers = numOfFamMembers;
	}
	public User() {
		this.name = "Left Blank";
		this.age = 18;
		this.city = "Left Blank";
		this.state = "Left Blank";
		this.disabilities = "Left Blank";
		this.numOfFamMembers = 0;
    }
    public void setName(String str){
        name = str;
    }
    public String getName(){
        return name;
    }
	public void setAge(int num) {
		age = num;
    }
    public int getAge(){
        return age;
    }
    public void setCity(String str){
        city = str;
    }
    public String getCity(){
        return city;
    }
    public void setState(String str){
        state = str;
    }
    public String getState(){
        return state;
    }
    public void setDisabilities(String str){
        disabilities = str;
    }
    public String getDisabilities(){
        return disabilities;
    }
    public void setNumFamilyMembers(int num){
        numOfFamMembers = num;
    }
    public int getNumFam(){
        return numOfFamMembers;
    }
    public boolean isAdult(){
        return age>=18;
    }
    public boolean haveFamMembers(){
        return numOfFamMembers>0;
    }
}
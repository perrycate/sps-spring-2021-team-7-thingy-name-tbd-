
public class User {
	/*For the User class the fields needed are:
	 * Name, age, city, state, disabilities, and
	 * number of families.
     * 
     * Class also contains multiple methods for creating and sending the
     * information of the user
     * 
	 * */
	private String name;
	private int age;
	private String city;
	private String state;
	private String disabilities;
    private int numOfFamMembers;
    private static final int ADULT_AGE = 18;
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
        return age>=ADULT_AGE;
    }
    public boolean haveFamMembers(){
        return numOfFamMembers>0;
    }
}
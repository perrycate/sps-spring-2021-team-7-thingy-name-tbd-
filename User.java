
public class User {
	/*For the User class the fields needed are:
	 * Name, age, city, state, disabilities, and
	 * number of families.
     * 
     * Class also contains multiple methods for creating and sending the
     * information of the user
     * 
	 * */
	private String Name;
	private int Age;
    private boolean disabilities;
    private boolean needMedAssist;
    private int NumberOfFamilyMembers;
    private int shelterNeedLength;
    private static final int ADULT_AGE = 18;
	public User(String name, int age, boolean disabilities, boolean needMedAssist, int numOfFamMembers, int shelterNeedLength) {
		this.Name = name;
		this.Age = age;
        this.disabilities = disabilities;
        this.needMedAssist = needMedAssist;
        this.NumberOfFamilyMembers = numOfFamMembers;
        this.shelterNeedLength = shelterNeedLength;
	}
	public User() {
		this.Name = "Left Blank";
		this.Age = 18;
        this.disabilities = false;
        this.needMedAssist = false;
		this.NumberOfFamilyMembers = 0;
    }
    public void setName(String str){
        Name = str;
    }
    public String getName(){
        return Name;
    }
	public void setAge(int num) {
		Age = num;
    }
    public int getAge(){
        return Age;
    }
    public void setDisabilities(boolean str){
        disabilities = str;
    }
    public boolean getDisabilities(){
        return disabilities;
    }
    public void setNumFamilyMembers(int num){
        NumberOfFamilyMembers = num;
    }
    public int getNumFam(){
        return NumberOfFamilyMembers;
    }
    public boolean isAdult(){
        return Age>=ADULT_AGE;
    }
    public boolean haveFamMembers(){
        return NumberOfFamilyMembers>0;
    }
    public void setMedAssist(boolean m){
        needMedAssist = m;
    }
    public boolean getMedAssist(){
        return needMedAssist;
    }
    public void setShelterNeedLength(int shel){
        shelterNeedLength = shel;
    }
    public int getShelterNeedLength(){
        return shelterNeedLength;
    }
}
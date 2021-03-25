

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
	private Integer Age;
    private Boolean disabilities;
    private Boolean needMedAssist;
    private Integer NumberOfFamilyMembers;
    private Integer shelterNeedLength;
    private static final int ADULT_AGE = 18;
	public User(String name, Integer age, Boolean disabilities, Boolean needMedAssist, Integer numOfFamMembers, Integer shelterNeedLength) {
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
	public void setAge(Integer num) {
		Age = num;
    }
    public Integer getAge(){
        return Age;
    }
    public void setDisabilities(Boolean str){
        disabilities = str;
    }
    public Boolean getDisabilities(){
        return disabilities;
    }
    public void setNumFamilyMembers(Integer num){
        NumberOfFamilyMembers = num;
    }
    public Integer getNumFam(){
        return NumberOfFamilyMembers;
    }
    public Boolean isAdult(){
        return Age>=ADULT_AGE;
    }
    public Boolean haveFamMembers(){
        return NumberOfFamilyMembers>0;
    }
    public void setMedAssist(Boolean m){
        needMedAssist = m;
    }
    public Boolean getMedAssist(){
        return needMedAssist;
    }
    public void setShelterNeedLength(Integer shel){
        shelterNeedLength = shel;
    }
    public Integer getShelterNeedLength(){
        return shelterNeedLength;
    }
}
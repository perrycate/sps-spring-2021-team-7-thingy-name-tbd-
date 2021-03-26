package com.google.sps.servlets;

public class User {
	/*For the User class the fields needed are:
	 * Name, age, city, state, disabilities, and
	 * number of families.
     * 
     * Class also contains multiple methods for creating and sending the
     * information of the user
     * 
	 * */
    private static final int ADULT_AGE = 18;

	private String Name;
    private Integer Age;
    private String Gender;
    private Boolean disabilities;
    private Boolean needMedAssist;
    private Integer NumberOfFamilyMembers;
    private Integer shelterNeedLength;
    
    public User(String name, Integer age, String gender,Boolean disabilities, Boolean needMedAssist, 
                Integer numOfFamMembers, Integer shelterNeedLength) {
		this.Name = name;
        this.Age = age;
        this.Gender = gender;
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

    // Getters & Setters
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
    public void setGender(String str) {
		Gender = str;
    }
    public String getGender(){
        return Gender;
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

    public Boolean isAdult(){
        return Age>=ADULT_AGE;
    }

    public Boolean haveFamMembers(){
        return NumberOfFamilyMembers>0;
    }

    // Returns formatted user info string
    @Override
    public String toString() {
        StringBuilder userFormattedData = new StringBuilder();
        userFormattedData.append("------------------------\n");
        userFormattedData.append("Name: " + this.Name + "\n");
        userFormattedData.append("Age: " + this.Age + "\n");
        userFormattedData.append("Gender: " + this.Gender + "\n");
        userFormattedData.append("# Family members: " + this.NumberOfFamilyMembers + "\n");
        userFormattedData.append("Disabilities: " + this.disabilities + "\n");
        userFormattedData.append("Medical Assistance: " + this.needMedAssist + "\n");
        userFormattedData.append("Days: " + this.shelterNeedLength + "\n");
        userFormattedData.append("------------------------" + "\n");
        
        return userFormattedData.toString();
    }

    // Returns true/false depending on the validity of the User data
    public boolean isValid() {
        if (this.Name == null || this.Name.length() < 2) {
            System.out.println("Name is too short");
            return false;
        }
        if (this.Gender == null) {
            System.out.println("Gender not selected");
            return false;
        }
        if (this.Age == null || this.Age < 1 || this.Age > 150) {
            System.out.println("Age is out of range");
            return false;
        }
        if (this.needMedAssist == null) {
            System.out.println("Medical Assistance not selected");
            return false;
        }
        if (this.NumberOfFamilyMembers == null || this.NumberOfFamilyMembers > 25 || 
            this.NumberOfFamilyMembers < 0) {
            System.out.println("NFM is out of range");  
            return false;
        } 
        if (this.disabilities == null) {
            System.out.println("Disabilities not selected");
            return false;
        }
        if (this.shelterNeedLength == null || this.shelterNeedLength < 1 || 
            this.shelterNeedLength > 365) {
            System.out.println("Days out of range");
            return false;
        }

        return true;
    }
}
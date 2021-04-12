package com.google.sps.servlets;

public class Shelter{
/*The shelter class contains contact information for homeless shelters, 
and some validation logic for verifying phone numbers
*/
    private String name;
    private String location;
    private long phoneNum;
    private int ageMin;
    private int ageMax;
    private String description;
    private int matchScore = 0;
    private boolean disability;
    private String gender;

    public Shelter(String name, String location, long phoneNum, String description, int ageMin, int ageMax, boolean disability){
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.description = "Currently blank";
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.disability = disability;
    }
    //specific gender shelters
    public Shelter(String name, String location, long phoneNum, String description, int ageMin, int ageMax, boolean disability, String gender){
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.gender = gender;
        this.description = "Currently blank";
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.disability = disability;
    }
    public Shelter(){
        this.name = "Currently blank";
        this.location = "Currently blank";
        this.phoneNum = 0;
        this.description = "Currently blank";
        this.ageMin = 18;
        this.ageMax = 100;
        this.disability = false;
        
    }
    public void setName(String str){
        name = str;
    }
    public String getName(){
        return name;
    }
    public void setLocation(String str){
        location = str;
    }
    public String getLocation(){
        return location;
    }
    public void setPhoneNum(long num){
        phoneNum = num;
    }
    public long getPhoneNum(){
        return phoneNum;
    }
    public boolean isValidPhoneNum(int phone){
        int num = phone;
        int cnt = 9;
        while(num>1){//Checks to make sure the num given is 9 digits
            num/=10;
            cnt-=1;
        }
        return cnt==0;
    }

    public boolean getDisability(){
        return disability;
    }

    public void setDisability(boolean b){
        disability = b;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String str){
        gender = str;
    }
    
    public void setDescription(String str){
        description = str;
    }
    public String getDescription(){
        return description;
    }
    public int[] getAgeRange(){
        int[] ageRange = {ageMin, ageMax};
        return ageRange;
    } 
    public void setAgeRange(int min, int max){
        this.ageMin = min;
        this.ageMax = max;
    }    
    public void addScore(){
    	this.matchScore++;
    }
    public int getScore(){
    	return this.matchScore;
    }
}

public class Shelter{
/*The shelter class contains a var for the 
name of shelter, location, phone number, and description*/
    private String name;
    private String location;
    private int phoneNum;
    private String desciption;
    public Shelter(String name, String location, int phoneNum, String description){
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.description = "Currently blank";
    }
    public Shelter(){
        this.name = "Currently blank";
        this.location = "Currently blank";
        this.phoneNum = null;
        this.description = "Currently blank";
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
    public void setPhoneNum(int num){
        phoneNum = num;
    }
    public int getPhoneNum(){
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
    public void setDescription(String str){
        desciption = str;
    }
    public String getDescription(){
        return desciption;
    }
}
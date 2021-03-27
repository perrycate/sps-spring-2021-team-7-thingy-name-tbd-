public class Shelter{
/*The shelter class contains contact information for homeless shelters, 
and some validation logic for verifying phone numbers
*/
    private String name;
    private String location;
    private long phoneNum;
    private int Age;
    private String desciption;
    public Shelter(String name, String location, long phoneNum, String description, int age){
        this.name = name;
        this.location = location;
        this.phoneNum = phoneNum;
        this.description = "Currently blank";
        this.age = age;
    }
    public Shelter(){
        this.name = "Currently blank";
        this.location = "Currently blank";
        this.phoneNum = null;
        this.description = "Currently blank";
        this.age = 18;
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
    public boolean isValidPhoneNum(long phone){
        long num = phone;
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
public class Driver{
    public static void main(String[] args){
        Shelter nameOne = new Shelter();
        nameOne.setName();
        nameOne.setLocation();
        nameOne.setPhoneNum();
        nameOne.setDescription();
        nameOne.setAge();

        Shelter nameTwo = new Shelter();
        nameTwo.setName();
        nameTwo.setLocation();
        nameTwo.setPhoneNum();
        nameTwo.setDescription();
        nameTwo.setAge();

        Shelter nameThree = new Shelter();
        nameThree.setName();
        nameThree.setLocation();
        nameThree.setPhoneNum();
        nameThree.setDescription();
        nameThree.setAge();

        Shelter nameFour = new Shelter();
        nameFour.setName();
        nameFour.setLocation();
        nameFour.setPhoneNum();
        nameFour.setDescription();
        nameFour.setAge();

        Shelter nameFive = new Shelter();
        nameFive.setName();
        nameFive.setLocation();
        nameFive.setPhoneNum();
        nameFive.setDescription();
        nameFive.setAge();
    }
}

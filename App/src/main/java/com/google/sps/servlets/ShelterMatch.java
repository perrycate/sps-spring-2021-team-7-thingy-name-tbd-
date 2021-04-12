package com.google.sps.servlets;

import java.util.ArrayList;

public class ShelterMatch{
    
    private static ArrayList<Shelter> list;

    public ShelterMatch(){
        list = new ArrayList<Shelter>();        
    }

    public void addShelters(){
        Shelter nameOne = new Shelter();
        nameOne.setName("Youth Emerging Stronger: Runaway & Homeless Minor Youth Program");
        nameOne.setLocation("1754 Taft Avenue, Los Angeles , CA 90028");
        nameOne.setPhoneNum(3232402253L);
        nameOne.setDescription("90 day program for teens.");
        nameOne.setAgeRange(12,17);
        nameOne.setDisability(false);
        list.add(nameOne);

        Shelter nameTwo = new Shelter();
        nameTwo.setName("Youth Emerging Stronger: Transitional Living Program");
        nameTwo.setLocation("1754 Taft Avenue, Los Angeles , CA 90028");
        nameTwo.setPhoneNum(3232402253L);
        nameTwo.setDescription("18-24 month program for teens");
        nameTwo.setAgeRange(18,24);
        nameTwo.setDisability(false);
        list.add(nameTwo);

        Shelter nameThree = new Shelter();
        nameThree.setName("Ella's Foundation Homeless Services");
        nameThree.setLocation("3006 S. Vermont Ave. Los Angeles, CA 90007");
        nameThree.setPhoneNum(3237616415L);
        nameThree.setDescription("Homeless service for men ony.");
        nameThree.setAgeRange(18,65);
        nameThree.setGender("male");
        list.add(nameThree);

        Shelter nameFour = new Shelter();
        nameFour.setName("PATHCARES for the Disabled");
        nameFour.setLocation("340 N. Madison Ave, Los Angeles, CA 90004");
        nameFour.setPhoneNum(3236442200L);
        nameFour.setDescription("6 month program for people with verified disabilities.");
        nameFour.setAgeRange(18,100);
        nameFour.setDisability(false);
        list.add(nameFour);

        Shelter nameFive = new Shelter();
        nameFive.setName("Salvation Army Hope Harbor Los Angeles");
        nameFive.setLocation("3107 S. Grand Avenue, Los Angeles, CA 90007");
        nameFive.setPhoneNum(2137448186L);
        nameFive.setDescription("9-18 month program for veterans with mental health issues");
        nameFive.setAgeRange(18,100);
        nameFour.setDisability(false);
        list.add(nameFive);

        Shelter nameSix = new Shelter();
        nameSix.setName("Downtown Women’s Center: Permanent Supportive Housing");
        nameSix.setLocation("442 S. San Pedro Street, Los Angeles, CA 90013");
        nameSix.setPhoneNum(2136800600L);
        nameSix.setDescription("Permanent program for homeless women.");
        nameSix.setAgeRange(18,100);
        nameSix.setGender("female");
        nameFour.setDisability(false);
        list.add(nameSix);

        Shelter nameSeven = new Shelter();
        nameSeven.setName("Downtown Women’s Center: Community-Based Housing Program");
        nameSeven.setLocation("442 S. San Pedro Street, Los Angeles, CA 90013");
        nameSeven.setPhoneNum(2136800600L);
        nameSeven.setDescription("Nightly program for homeless women and children.");
        nameSeven.setAgeRange(18,100);
        nameSeven.setGender("female");
        nameFour.setDisability(false);
        list.add(nameSeven);

        Shelter nameEight = new Shelter();
        nameEight.setName("Higher Goals");
        nameEight.setLocation("10510 S Vermont Ave, Los Angeles, CA - 90044");
        nameEight.setPhoneNum(3237559702L);
        nameEight.setDescription("6 month program to get you back on your feet.");
        nameEight.setAgeRange(18,100);
        nameEight.setDisability(false);
        list.add(nameFive);
    }

    //returns a Shelter[] of the sorted results based on score
    public static Shelter[] sortTop3(){
        Shelter[] output = new Shelter[3];
        ArrayList<Shelter> temp = new ArrayList<Shelter>();

        //populating temp with Shelters from list so temp can be altered without effecting list
        for(int i = 0; i < list.size(); i++){
            temp.add(list.get(i));
        }
        
        int count = 0;
        while(count <= output.length-1){
            int posMax = 0;
            int maxScore = temp.get(0).getScore();

            for(int j = 0; j < temp.size(); j++){
                if(maxScore < temp.get(j).getScore()){
                    maxScore = temp.get(j).getScore();
                    posMax = j;
                }
                else if(maxScore == temp.get(j).getScore()){
                    maxScore = maxScore;
                }
            }
            
            output[count] = temp.get(posMax);
            temp.remove(posMax);
            count++;
        }

        //checking to see if any shelters with score of 0 was added to top3
        for(int i = 0; i < output.length; i++){
            if(output[i].getScore() == 0)
                output[i] = new Shelter("No other available shelters",null,0L,null,0,0,false);
        }
        return output;
    }

    public static boolean ageRequire(User person, int i){
        //        
        if(person.getAge() >= list.get(i).getAgeRange()[0] && person.getAge() <= list.get(i).getAgeRange()[1]){
            return true;
        }
        return false;
    }

    public static boolean genderRequire(User person, int i){
        //        
        if(person.getGender().equals(list.get(i).getGender())){
            return true;
        }
        return false;
    }

    public static boolean disability(User person, int i){
        //        
        if(person.getDisabilities().equals(list.get(i).getDisability())){
            return true;
        }
        return false;
    }

    //returns an array of the top 3 shelters matched with the user
    public static Shelter[] isEligible(User person){
        Shelter[] top3 = new Shelter[3];
        
        //comparing each shelter age requirement with the user        
        for(int i = 0; i < list.size(); i++){
            if(ageRequire(person,i))
                list.get(i).addScore();
            if(genderRequire(person,i))
                list.get(i).addScore();
            if(disability(person,i))
                list.get(i).addScore();
        }
        top3 = sortTop3();

        return top3;
    }
}

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
        list.add(nameOne);

        Shelter nameTwo = new Shelter();
        nameTwo.setName("Youth Emerging Stronger: Transitional Living Program");
        nameTwo.setLocation("1754 Taft Avenue, Los Angeles , CA 90028");
        nameTwo.setPhoneNum(3232402253L);
        nameTwo.setDescription("18-24 month program for teens");
        nameTwo.setAgeRange(18,24);
        list.add(nameTwo);

        Shelter nameThree = new Shelter();
        nameThree.setName("Ella's Foundation Homeless Services");
        nameThree.setLocation("3006 S. Vermont Ave. Los Angeles, CA 90007");
        nameThree.setPhoneNum(3237616415L);
        nameThree.setDescription("Homeless service for men ony.");
        nameThree.setAgeRange(18,65);
        list.add(nameThree);

        Shelter nameFour = new Shelter();
        nameFour.setName("PATHCARES for the Disabled");
        nameFour.setLocation("340 N. Madison Ave, Los Angeles, CA 90004");
        nameFour.setPhoneNum(3236442200L);
        nameFour.setDescription("6 month program for people with verified disabilities.");
        nameFour.setAgeRange(18,100);
        list.add(nameFour);

        Shelter nameFive = new Shelter();
        nameFive.setName("Salvation Army Hope Harbor Los Angeles");
        nameFive.setLocation("3107 S. Grand Avenue, Los Angeles, CA 90007");
        nameFive.setPhoneNum(2137448186L);
        nameFive.setDescription("9-18 month program for veterans with mental health issues");
        nameFive.setAgeRange(18,100);
        list.add(nameFive);
    }

    public static void sortShelters(Shelter[] shelters){
        for(int i = 0; i < shelters.length; i++){

        }

    }
    //returns an array of the top 3 shelters matched with the user
    public static Shelter[] isEligible(User person){
        Shelter[] top3 = new Shelter[3];

        //comparing each shelter age requirement with the user        
        for(int i = 0; i < list.size(); i++){
            if(person.getAge() >= list.get(i).getAgeRange()[0] && person.getAge() <= list.get(i).getAgeRange()[1]){
                list.get(i).addScore();
            }
        }
        //comparing shelters among each other to get the top 3
        for(int i = 0; i < top3.length; i++){
            if(list.get(i).getScore() > 0)
                top3[i] = list.get(i);
        }


        for(int i = 0; i < top3.length; i++)
            System.out.println(top3[i] + "\n");
        return top3;
    }
    public static void main(String[] args){
        
        Integer a = 18;
        Boolean b = false;
        User test = new User("Test", a, "female", b,b,a,a);
        System.out.println(isEligible(test));
    }
}

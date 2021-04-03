// populates shelter list with dummy data
// temporary, until ShelterMatch is completed

package com.google.sps.servlets;

import java.util.List;

public class PopulateShelters {
    public static void populate(List<Shelter> shelters) {
        Shelter shelter1 = new Shelter();
        shelter1.setName("Youth Emerging Stronger: Runaway & Homeless Minor Youth Program");
        shelter1.setLocation("1754 Taft Avenue, Los Angeles , CA 90028");
        shelter1.setPhoneNum(0);
        shelter1.setDescription("90 day program for teens.");
        shelter1.setAgeRange(12,17);

        Shelter shelter2 = new Shelter();
        shelter2.setName("Youth Emerging Stronger: Transitional Living Program");
        shelter2.setLocation("1754 Taft Avenue, Los Angeles , CA 90028");
        shelter2.setPhoneNum(0);
        shelter2.setDescription("18-24 month program for teens");
        shelter2.setAgeRange(18,24);

        Shelter shelter3 = new Shelter();
        shelter3.setName("Ella's Foundation Homeless Services");
        shelter3.setLocation("3006 S. Vermont Ave. Los Angeles, CA 90007");
        shelter3.setPhoneNum(0);
        shelter3.setDescription("Homeless service for men ony.");
        shelter3.setAgeRange(12,17);

        shelters.add(shelter1);
        shelters.add(shelter2);
        shelters.add(shelter3);
    }
}
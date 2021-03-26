import java.util.ArrayList;

public class ShelterMatch extends Shelter{
    private ArrayList<Shelter> list;


    public ShelterMatch(){
    	list = new ArrayList<Shelter>();
    }

    public void addShelter(Shelter s){
        list.add(s);
    }

    //returns an array of the top 3 shelters matched with the user
    public Shelter[] isEligible(User person){
        Shelter[] top3 = new Shelter[3];
        //comparing each shelter age requirement with the user
        for(int i = 0; i < list.size(); i++){
            if(person.getAge() >= list.get(i).getAgeRequirement()){
                list.get(i).addScore();
            }
            //comparing shelters among each other to get the top 3
            for(int j = 0; j < top3.length; j++){
            	if(list.get(i).getScore() > top3[j].getScore())
            		top3[j] = list.get(i);
            }
        }
        return top3;
    }
}

import java.util.ArrayList;

public class ShelterMatch extends Shelter{
    private ArrayList<Shelter> list;
    private int score;


    public ShelterMatch(Shelter shelt, int score){
         
    }

    public addShelter(Shelter s){
        ShelterMatch shelt = new ShelterMatch(s, score);
        list.add(shelt);
    }

    //returns an int array representing the top 3 shelters matched with the user
    public int[] isElgibile(User person){
        int[] top3 = new int[3];
        //comparing each shelter age requirement with the user
        for(int i = 0; i < list.size(); i++){
            if(me.getAge() < list.get(i).getAgeRequirement()){
                list.get(i).setScore(this.score++);
            }
        }
        return top3;
    }
}
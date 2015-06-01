package logical;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Profile {
    public ArrayList<Recipe> recipes;
    public ArrayList<disease> DiseaseHistory;
   // private ArrayList<activity> Activities;
   // private ArrayList<physicalState> PhysicalStates;
    public ArrayList<String> DoctersName;
    public ArrayList<String> expertName;
    public String ProfileId;

    public Profile(String Id){
        recipes = new ArrayList<Recipe>();
        DiseaseHistory = new ArrayList<disease>();
        DoctersName = new ArrayList<String>();
        expertName = new ArrayList<String>();
        ProfileId = Id;
    }



}

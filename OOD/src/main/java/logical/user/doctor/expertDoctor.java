package logical.user.doctor;

/**
 * Created by a on 5/8/15.
 */
public class ExpertDoctor extends Doctor {
    private String ExpertType;
    public ExpertDoctor(String username, char[] password, String name, String familyName, String doctorId,String type) {
        super(username, password, name, familyName, doctorId,"Spec");

    }

    public String getExpertType() {
        return ExpertType;
    }

    public void setExpertType(String expertType) {
        ExpertType = expertType;
    }
}

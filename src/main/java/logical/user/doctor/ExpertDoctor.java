package logical.user.doctor;

import data.entities.entityfile.UserEntity;

/**
 * Created by a on 5/8/15.
 */
public class ExpertDoctor extends Doctor {

    private String ExpertType;
    public ExpertDoctor(String username, char[] password, String name, String familyName, String doctorId) {
        super(username, password, name, familyName, doctorId,"Spec");

    }

    public String getExpertType() {
        return ExpertType;
    }

    public void setExpertType(String expertType) {
        ExpertType = expertType;
    }
    public ExpertDoctor(UserEntity user) {
        super(user, "Spec");

    }

    public ExpertDoctor(Doctor doctor) {
        super(doctor.getUsername(), doctor.getPassword(), doctor.getName(), doctor.getFamilyName(), doctor.getId(),"Spec");

    }

}

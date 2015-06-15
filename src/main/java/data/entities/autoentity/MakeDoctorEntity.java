package data.entities.autoentity;

import logical.user.doctor.Doctor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mona on 5/9/2015.
 */
public class MakeDoctorEntity extends MakeEntityFile {

    String contentFile = "";


    public MakeDoctorEntity(Doctor d) throws IOException {
        contentFile += namefile(d, "DoctorEntity");
        contentFile += construct(d, "DoctorEntity");
        contentFile += content(d);
        contentFile += "  private Set<PatientEntity> patients = new HashSet<PatientEntity>(0);\n" +
                "\n" +
                "    @ManyToMany(fetch = FetchType.LAZY, mappedBy = \"doctors\")\n" +
                "    public Set<PatientEntity> getPatients() {\n" +
                "        return this.patients;\n" +
                "    }\n" +
                "\n" +
                "    public void setPatients(Set<PatientEntity> patients) {\n" +
                "        this.patients = patients;\n" +
                "    }\n" +
                "    public void addPatients(PatientEntity patient) {\n" +
                "        patients.add(patient);\n" +
                "    }";
        contentFile += "}";
        File file = new File("src\\main\\java\\data\\entities\\entityfile\\"+ "DoctorEntity" +".java");

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contentFile);

        bw.close();
        // }
    }

    public MakeDoctorEntity() {

    }
}

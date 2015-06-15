package data.entities.autoentity;

import logical.user.patient.Patient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mona on 5/9/2015.
 */
public class MakePatientEntity extends MakeEntityFile {
    String contentFile = "";


    MakePatientEntity(Patient p) throws IOException {
        contentFile += namefile(p, "PatientEntity");
        contentFile += construct(p, "PatientEntity");
        contentFile += content(p);
        contentFile += "    private ArrayList<DoctorEntity> doctors = new ArrayList<DoctorEntity>(0);\n" +
                "\n" +
                "\n" +
                "    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)\n" +
                "    @JoinTable(name = \"patient_doctor\", joinColumns = {\n" +
                "            @JoinColumn(name = \"patient_ID\") },\n" +
                "            inverseJoinColumns = { @JoinColumn(name = \"doctor_ID\") })\n" +
                "    public Set<DoctorEntity> getDoctors() {\n" +
                "        return this.doctors;\n" +
                "    }\n" +
                "\n" +
                "    public void setDoctors(Set<DoctorEntity> doctors) {\n" +
                "        this.doctors = doctors;\n" +
                "    }\n" +
                "    public void addDoctors(DoctorEntity doctor) {\n" +
                "        doctors.add(doctor);\n" +
                "    }\n";
        contentFile += "}";
        File file = new File("src\\main\\java\\data\\entities\\entityfile\\"+ "PatientEntity" +".java");

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contentFile);

        bw.close();
            // }
        }

    }


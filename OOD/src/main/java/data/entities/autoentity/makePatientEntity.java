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
        contentFile += "}";
        File file = new File("src\\main\\java\\data\\entities\\entityfile\\"+ "PatientEntity" +".java");

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contentFile);

        bw.close();
            // }
        }

    }


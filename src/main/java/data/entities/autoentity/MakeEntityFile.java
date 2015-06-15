package data.entities.autoentity;

import javax.persistence.Column;
import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by Mona on 5/8/2015.
 */
public class MakeEntityFile {

    public String content(Object obj) {
        String res = "";


        Class clazz = obj.getClass();

        Field[] field = clazz.getFields();

        for (Field fieldName : field) {
            String type = fieldName.getType().getSimpleName();
            String name = fieldName.getName();
            System.out.println(name + "%%%%%%%%%%");
            if (name.equals("id")) {
                res += " public String "+clazz.getSimpleName().toLowerCase()+"_id;\n   @Id\n" +
                        "    @Column(name = \""+clazz.getSimpleName().toLowerCase()+"_" + name + "\")\n" +
                        "    public String get" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(){\n" +
                        "        return "+clazz.getSimpleName().toLowerCase()+"_" + name + ";\n" +
                        "    }\n" +
                        "    public void set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(" + type + " " + name + ") {\n" +
                        "        this.patient_" + name + " = " + name + ";\n" +
                        "    }\n \n \n ";

            } else {
                res += "public " + type + " " + name + ";\n" +
                        "    @Column(name = \"" + name + "\")\n" + "    @Basic\n" +
                        "    public "+type+" get" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(){\n" +
                        "        return " + name + ";\n" +
                        "    }\n" +
                        "    public void set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(" + type + " " + name + ") {\n" +
                        "        this." + name + " = " + name + ";\n" +
                        "    }\n \n \n ";

            }
        }

        return res;
    }

    public String namefile(Object object, String nameFile) throws IOException {


        Class clazz = object.getClass();

        Field[] field = clazz.getFields();

        //System.out.println(field[0].getName() + " monaaaaaaaaa ");

        String content ="package data.entities.entityfile;\n"+
                "import data.entities.entityfile.MyEntity;\n"+
                "import org.hibernate.annotations.Type;\n" +
                "\n" +
                "import javax.persistence.*;\n" +
                "import java.sql.Timestamp;\n" +
                "import logic.*;" +
                "\n" +"import java.util.HashSet;\n" +
                "import java.util.Set;\n"+

                "@Table(name = \"my"+clazz.getSimpleName()+ "\")\n" +
                "@Entity\n" +
                "public class " + nameFile + " {\n";
        return content;


    }

    public String construct(Object obj, String fileName) {

        Class clazz = obj.getClass();

        Field[] field = clazz.getFields();

        String constr = "    " + clazz.getSimpleName() + " obj;\n" +
                "    public " + fileName + "(" + clazz.getSimpleName() + " obj) {\n" +
                "        this.obj = obj;\n";

        for (Field fieldName : field) {

            String type = fieldName.getType().getSimpleName();
            String name = fieldName.getName();


            constr += "     set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(obj." + name + ");\n";


        }

        constr += "    }\n";

        return constr;

    }
}



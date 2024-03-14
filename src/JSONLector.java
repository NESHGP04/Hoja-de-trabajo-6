import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import org.json.simple.*;
import java.util.*;

public class JSONLector {

    private final ObjectMapper objectMapper;

    public JSONLector() {
        this.objectMapper = new ObjectMapper();
    }

    public File saveStudents(List<Student> students, String path) {
        try {
            File file = new File(path+ ".json");
            objectMapper.writeValue(file, students);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // System.out.println("Seleccione su tipo de formato");
    // System.out.println("0 - CSV");
    // System.out.println("1 - XML");
    // System.out.println("2 - JSON");
    // Scanner scanner = new Scanner (System.in);
    // int fileType = Integer.parseInt(scanner.nextLine());

    // IHash hashGuardar = FactoryHash.getHashMap(fileType);


    // // Guardar estudiantes en un archivo XML
    // File savedFile = hashGuardar.saveStudents(hash, "students");
    // System.out.println("Estudiantes guardados en: " + savedFile.getAbsolutePath());

}

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {

    public static List<Student> readStudentsFromFile(String filePath) {
        List<Student> students = new ArrayList<>();
        try {
            // Leer el contenido del archivo
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            // Crear un JSONArray a partir del contenido del archivo
            JSONArray jsonArray = new JSONArray(content);

            // Iterar sobre cada elemento del JSONArray
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extraer los datos de cada estudiante
                String name = jsonObject.getString("name");
                String phone = jsonObject.getString("phone");
                String email = jsonObject.getString("email");
                String postalZip = jsonObject.getString("postalZip");
                String country = jsonObject.getString("country");

                // Crear una nueva instancia de Student y añadirla a la lista
                students.add(new Student(name, phone, email, postalZip, country));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
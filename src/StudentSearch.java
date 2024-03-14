import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.Function;

public class StudentSearch {
    private Map<String, List<Student>> studentMapOrganic;
    private Map<String, Student> studentMapNonOrganic;
    private Function<Student, String> keyExtractor;
    private boolean isOrganic;

    public StudentSearch(int mapType, Function<Student, String> keyExtractor, boolean isOrganic) {
        this.isOrganic = isOrganic;
        if (isOrganic) {
            // Si es orgánico, utilizamos el MapFactory para obtener la implementación de Map adecuada
            this.studentMapOrganic = MapFactory.getMap(mapType);
        } else {
            // Si no es orgánico, simplemente usamos un HashMap, ya que no se manejarán colisiones
            this.studentMapNonOrganic = new HashMap<>();
        }
        this.keyExtractor = keyExtractor;
    }

    public void addStudent(Student student) {
        String key = keyExtractor.apply(student);
        if (isOrganic) {
            // Si es orgánico, mantenemos la lista de estudiantes
            List<Student> students = studentMapOrganic.computeIfAbsent(key, k -> new ArrayList<>());
            students.add(student);
        } else {
            // Si no es orgánico, simplemente asignamos el estudiante a la clave, sobrescribiendo cualquier valor existente
            studentMapNonOrganic.put(key, student);
        }
    }

    public List<Student> searchByCountry(String country) {
        // Devuelve la lista de estudiantes que corresponde al país o una lista vacía si no hay ninguno
        return studentMapOrganic.getOrDefault(country, new ArrayList<>());
    }

    public Student searchByKey(String key) {
        // Busca un único estudiante por la clave no orgánica
        return studentMapNonOrganic.get(key);
    }
}

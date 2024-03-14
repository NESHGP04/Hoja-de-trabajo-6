import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class StudentSearch {
    private Map<String, List<Student>> studentMapOrganic;
    private Map<String, Student> studentMapNonOrganic;
    private Function<Student, String> keyExtractor;
    private boolean isOrganic;

    public StudentSearch(Map<String, List<Student>> studentMap, Function<Student, String> keyExtractor, boolean isOrganic) {
        this.isOrganic = isOrganic;
        if (isOrganic) {
            // Si es orgánico, utilizamos el MapFactory para obtener la implementación de Map adecuada
            this.studentMapOrganic = studentMap;
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
        if (isOrganic) {
            return studentMapOrganic.getOrDefault(country, new ArrayList<>());
        } else {
            // Si no es orgánico, retornar una lista vacía ya que no se puede buscar por país en un mapa no orgánico
            System.out.println("No se puede buscar por nacionalidad en una búsqueda no orgánica.");
            return new ArrayList<>();
        }
    }

    public Student searchByKey(String key) {
        // Busca un único estudiante por la clave no orgánica
        return studentMapNonOrganic.get(key);
    }

    public boolean isOrganic(){
        return isOrganic;
    }
}

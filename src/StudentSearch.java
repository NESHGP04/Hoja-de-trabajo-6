import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StudentSearch {
    private Map<String, List<Student>> studentMap;

    public StudentSearch(int mapType) {
        // Utiliza la MapFactory para obtener la implementación de Map adecuada
        this.studentMap = MapFactory.getMap(mapType);
    }

    public void addStudent(Student student) {
        // Obtén la lista de estudiantes para el país del estudiante o crea una nueva lista si no existe
        List<Student> students = studentMap.computeIfAbsent(student.getCountry(), k -> new ArrayList<>());
        // Añade el estudiante a la lista
        students.add(student);
    }

    public List<Student> searchByCountry(String country) {
        // Devuelve la lista de estudiantes que corresponde al país o una lista vacía si no hay ninguno
        return studentMap.getOrDefault(country, new ArrayList<>());
    }
}

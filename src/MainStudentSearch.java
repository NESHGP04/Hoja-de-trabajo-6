import java.util.List;

public class MainStudentSearch {
    public static void main(String[] args) {
        // Supongamos que el usuario elige utilizar un TreeMap (esto podría provenir de una entrada de usuario)
        int mapType = MapFactory.TREEMAP_TYPE;
        StudentSearch studentSearch = new StudentSearch(mapType);

        // Añadir algunos estudiantes al buscador
        studentSearch.addStudent(new Student("John Doe", "123456789", "john.doe@example.com", "12345", "USA"));
        studentSearch.addStudent(new Student("Jane Smith", "987654321", "jane.smith@example.com", "54321", "USA"));
        studentSearch.addStudent(new Student("Pedro Gonzalez", "555555555", "pedro.gonzalez@example.com", "11111", "Spain"));

        // Buscar estudiantes por país
        List<Student> studentsInUSA = studentSearch.searchByCountry("USA");
        List<Student> studentsInSpain = studentSearch.searchByCountry("Spain");

        // Imprimir los resultados de la búsqueda
        System.out.println("Students in USA: " + studentsInUSA);
        System.out.println("Students in Spain: " + studentsInSpain);
    }
}

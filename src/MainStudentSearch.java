import java.util.List;

public class MainStudentSearch {
    public static void main(String[] args) {
        // Supongamos que el usuario elige utilizar un TreeMap (esto podría provenir de una entrada de usuario)
        int mapType = MapFactory.TREEMAP_TYPE;
        
        // Crear StudentSearch para la clave 'nacionalidad' con un hash orgánico
        StudentSearch searchByCountry = new StudentSearch(mapType, Student::getCountry, true);

        // Crear StudentSearch para la clave 'correo electrónico' que no es orgánico
        StudentSearch searchByEmail = new StudentSearch(mapType, Student::getEmail, false);

        // Añadir algunos estudiantes al buscador
        Student johnDoe = new Student("John Doe", "123456789", "john.doe@example.com", "12345", "USA");
        Student janeSmith = new Student("Jane Smith", "987654321", "jane.smith@example.com", "54321", "USA");
        Student pedroGonzalez = new Student("Pedro Gonzalez", "555555555", "pedro.g@example.com", "11111", "Spain");

        searchByCountry.addStudent(johnDoe);
        searchByCountry.addStudent(janeSmith);
        searchByCountry.addStudent(pedroGonzalez);

        searchByEmail.addStudent(johnDoe);
        searchByEmail.addStudent(janeSmith);
        // Nota: para la demostración, asegúrate de que los correos electrónicos sean únicos.
        // El siguiente estudiante tiene un correo electrónico que ya existe, y la llave no orgánica no debería permitir colisiones
        searchByEmail.addStudent(new Student("Pedro Gonzalez", "555555555", "john.doe@example.com", "11111", "Spain"));

        // Buscar estudiantes por país
        List<Student> studentsInUSA = searchByCountry.searchByCountry("USA");
        // Buscar estudiantes por correo electrónico
        Student studentWithEmail = searchByEmail.searchByKey("john.doe@example.com");

        // Imprimir los resultados de la búsqueda por país
        System.out.println("Students in USA:");
        for (Student student : studentsInUSA) {
            System.out.println(student);
        }

        // Imprimir el resultado de la búsqueda por correo electrónico
        System.out.println("\nEstudiante con el correo 'john.doe@example.com':");
        System.out.println(studentWithEmail);
    }
}

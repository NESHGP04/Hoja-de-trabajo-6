/*
 * Marinés Garcia - 23391
 * Kevin Villagrán - 23584
 * Hoja 6
 */


import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MainStudentSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que seleccione la implementación de Map
        System.out.println("Seleccione la implementación de Map:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        int mapChoice = Integer.parseInt(scanner.nextLine()) - 1;

        // Solicitar al usuario que seleccione la función hash
        System.out.println("Seleccione la función hash:");
        System.out.println("1) MD5");
        System.out.println("2) SHA-1");
        System.out.println("3) Orgánico (devuelve el mismo dato)");
        int hashFunctionChoice = Integer.parseInt(scanner.nextLine()) - 1;

        // Crear la función hash según la elección del usuario
        IHash hashFunction = FactoryHash.getHashMap(hashFunctionChoice);

        // Leer los estudiantes del archivo JSON
        String filePath = "data/estudiantes.json.json";
        List<Student> students = StudentReader.readStudentsFromFile(filePath);

        // Crear el mapa utilizando MapFactory
        Map<String, List<Student>> studentMapOrganic = MapFactory.getMap(mapChoice);
        Map<String, Student> studentMapNonOrganic = new HashMap<>();

        // Seleccionar el dato para generar la llave, en este caso, el número de teléfono
        Function<Student, String> phoneKeyExtractor = student -> hashFunction.hash(student.getPhone());
        // Seleccionar el dato para generar la llave, en este caso, el país
        Function<Student, String> countryKeyExtractor = Student::getCountry;

        // Crear el StudentSearch para manejar tanto la búsqueda orgánica como la no orgánica
        // Aquí asumimos que la búsqueda por nacionalidad será orgánica y la otra no
        StudentSearch studentSearchOrganic = new StudentSearch(studentMapOrganic, countryKeyExtractor, hashFunctionChoice == FactoryHash.ORGANICO_Hash);
        StudentSearch studentSearchNonOrganic = new StudentSearch(new HashMap<>(), phoneKeyExtractor, false);

        // Añadir estudiantes a cada StudentSearch según el tipo de búsqueda
        students.forEach(student -> {
            if (hashFunctionChoice == FactoryHash.ORGANICO_Hash) {
                studentSearchOrganic.addStudent(student);
            } else {
                studentSearchNonOrganic.addStudent(student);
            }
        });

        // Implementar las opciones de búsqueda
        System.out.println("Ingrese la operación deseada:");
        System.out.println("1) Buscar estudiante por llave única");
        System.out.println("2) Buscar estudiantes por nacionalidad");
        int searchChoice = Integer.parseInt(scanner.nextLine());

        if (searchChoice == 1) {
            System.out.println("Ingrese la llave única (Número de teléfono en este caso):");
            String key = scanner.nextLine();
            Student foundStudent = studentSearchNonOrganic.searchByKey(hashFunction.hash(key));
            System.out.println(foundStudent != null ? foundStudent : "Estudiante no encontrado.");
        } else if (searchChoice == 2) {
            if (!studentSearchOrganic.isOrganic()) {
                System.out.println("No se puede buscar por nacionalidad en una búsqueda no orgánica.");
            } else {
                System.out.println("Ingrese la nacionalidad:");
                String country = scanner.nextLine();
                List<Student> studentsByCountry = studentSearchOrganic.searchByCountry(country);
                if (studentsByCountry.isEmpty()) {
                    System.out.println("No se encontraron estudiantes de esta nacionalidad.");
                } else {
                    studentsByCountry.forEach(System.out::println);
                }
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

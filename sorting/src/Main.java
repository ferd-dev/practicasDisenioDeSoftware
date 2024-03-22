import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        defaultDataStudents(students);

        String field = readEntry();

        ISortStrategy sorter = SorterFactory.createSorter(field);
        sorter.sort(students);

        printStudents(students);
    }

    private static String readEntry() {
        System.out.println("Do you want to sort data by name, age or grade? You can match the data with a comma (,). example: \"name, age\"");
        Scanner in = new Scanner(System.in);

        String field = in.findInLine("[a-zA-Z]+(, [a-zA-Z]+)*");
        return field;
    }

    public static void printStudents(List<Student> students) {
        System.out.println("----------------------------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void defaultDataStudents(List<Student> students) {
        students.add(new Student("Juan", 20, 85.5));
        students.add(new Student("Maria", 22, 90.0));
        students.add(new Student("Carlos", 21, 78.3));
        students.add(new Student("Adriana", 23, 95.3));
        students.add(new Student("Mariana", 19, 75.3));
        students.add(new Student("Alejandro", 24, 65.3));
    }
}
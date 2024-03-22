import java.util.List;

public class SortByName implements ISortStrategy {

    @Override
    public void sort(List<Student> students) {
        students.sort((student1, student2) -> student1.getName().compareTo(student2.getName()));
        // students.sort(Comparator.comparing(student -> student.name));
    }

}

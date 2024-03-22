import java.util.List;

public class SortByGrade implements ISortStrategy {

    @Override
    public void sort(List<Student> students) {
        students.sort((student1, student2) -> Double.compare(student1.getGrade(), student2.getGrade()));
    }

}

import java.util.List;

public class SortByAge implements ISortStrategy {

    @Override
    public void sort(List<Student> students) {
        students.sort((student1, student2) -> student1.getAge() - student2.getAge());
    }

}

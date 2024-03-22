import java.util.List;

public class SortByMultipleFields implements ISortStrategy {
    @Override
    public void sort(List<Student> students) {
        students.sort((student1, student2) -> {
            int namaComparison = student1.getName().compareTo(student2.getName());
            if (namaComparison != 0) {
                return namaComparison;
            }

            int ageComparison = student1.getAge() - student2.getAge();
            if (ageComparison != 0) {
                return ageComparison;
            }

            return Double.compare(student1.getGrade(), student2.getGrade());
        });
    }

}

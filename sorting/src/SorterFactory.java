public class SorterFactory {
    public static ISortStrategy createSorter(String field) {
        switch (field) {
            case "name":
                return new SortByName();
            case "age":
                return new SortByAge();
            case "grade":
                return new SortByGrade();
            default:
                return new SortByMultipleFields();
        }
    }
}

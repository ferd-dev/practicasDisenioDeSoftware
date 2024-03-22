import java.util.ArrayList;
import java.util.List;

class ManageTable {
    private List<Table> tables;

    public ManageTable(int numberTables) {
        tables = new ArrayList<>();
        for (int i = 0; i < numberTables; i++) {
            tables.add(new Table(i));
        }
    }

    public Table getMesa(int numberTable) {
        for (Table table : tables) {
            if (table.getTableNumber() == numberTable) {
                return table;
            }
        }
        return null;
    }

    public void showTables() {
        System.out.println("*******************");
        System.out.println("Table list:");
        for (Table table : tables) {
            String state = table.itsBusy() ? "Busy" : "vacante";
            System.out.println("Table " + table.getTableNumber() + " - " + state);
        }
    }
}

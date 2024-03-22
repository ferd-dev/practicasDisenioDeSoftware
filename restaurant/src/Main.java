public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        addItemMenu(menu);

        ManageTable gestionMessa = new ManageTable(5);

        takeOrder(gestionMessa, 3, menu);

        gestionMessa.showTables();
        menu.show();
    }

    private static void takeOrder(ManageTable gestionMessa, int numberTable, Menu menu) {
        Table mesa = gestionMessa.getMesa(numberTable);
        mesa.occupy();
        Orden orden = mesa.getOrder();

        updateTableOrder(orden, mesa);

        orden.addItem(menu.getItem("Picante Mixto"));
        orden.addItem(menu.getItem("Vino"));
    }

    private static void updateTableOrder(Orden orden, Table mesa) {
        System.out.println("*********************************************");
        orden.addObserver(() -> {
            System.out.println("Order updated for Table " + mesa.getTableNumber() + ":");
            for (IMenu item : orden.getItems()) {
                System.out.println("- " + item.getName() + " $" + item.getPrice());
            }
        });
    }

    private static void addItemMenu(Menu menu) {
        menu.add("Picante Mixto", new priceMenuItem("Picante Mixto", 30.00));
        menu.add("Sopa de Mani", new priceMenuItem("Sopa de Mani", 10.00));
        menu.add("Vino", new priceMenuItem("Vino", 35.00));
    }
}
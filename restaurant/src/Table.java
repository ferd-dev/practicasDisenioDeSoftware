class Table {
    private int number;
    private boolean busy;
    private Orden orden;

    public Table(int _number) {
        this.number = _number;
        this.busy = false;
        this.orden = new Orden();
    }

    public int getTableNumber() {
        return number;
    }

    public boolean itsBusy() {
        return busy;
    }

    public Orden getOrder() {
        return orden;
    }

    public void occupy() {
        busy = true;
    }

    public void vacante() {
        busy = false;
        orden = new Orden();
    }
}

public class ProjectPrices {
    private int id;
    private int prices;

    public ProjectPrices(int id, int prices) {
        this.id = id;
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
               "id=" + id +
               ", prices=" + prices +
               '}';
    }
}

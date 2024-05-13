public class LongestProject {
    private int id;
    private int months;

    public LongestProject(int id, int months) {
        this.id = id;
        this.months = months;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
               "id=" + id +
               ", months=" + months +
               '}';
    }
}

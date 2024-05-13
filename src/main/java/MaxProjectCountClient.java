
public class MaxProjectCountClient {
    private String name;
    private long projectCount;

    public MaxProjectCountClient(String name, long projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
               "name='" + name + '\'' +
               ", projectCount=" + projectCount +
               '}';
    }
}

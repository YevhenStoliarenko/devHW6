public class YoungestEldestWorkers {
    private String name;
    private String birthday;
    private String type;

    public YoungestEldestWorkers(String name, String birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
               "name='" + name + '\'' +
               ", birthday='" + birthday + '\'' +
               ", type='" + type + '\'' +
               '}';
    }
}

public class MaxSalaryWorker {
    private String name;
    private long salary;

    public MaxSalaryWorker(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
               "name='" + name + '\'' +
               ", salary=" + salary +
               '}';
    }
}

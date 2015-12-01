import java.io.Serializable;

/**
 * Created by 46465442z on 01/12/15.
 */
public class Employee implements Serializable{

    private Integer id;
    private String first_name;
    private String last_name;
    private Integer salary;

    public Employee(){}

    public Employee(Integer id, String fn, String ln, Integer sl){
        this.id = id;
        first_name = fn;
        last_name = ln;
        salary = sl;
    }

    public Employee(String fn, String ln, Integer sl){
        first_name = fn;
        last_name = ln;
        salary = sl;
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Integer getSalary() {
        return salary;
    }

    // Setters

    public void setId(Integer id){
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

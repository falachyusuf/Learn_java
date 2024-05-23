import java.util.ArrayList;

public class EmployeeData {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    // Menambahkan data pada list
    void setEmployees(Employee data){
        this.employees.add(data);
    }

    // Menampilkan data pada list
    void getEmployees(){
        System.out.println("================================================================");
        for(Employee pegawai: employees){
            pegawai.showData();
        }
    }

    // Sort data pegawai pada list
    void sortEmployees(){
        employees.stream().filter(i -> i.getSalary() > 500).forEach(x -> System.out.println(x));
    }

    @Override
    public String toString() {
        return "EmployeeData [employees=" + employees + "]";
    }

    

}

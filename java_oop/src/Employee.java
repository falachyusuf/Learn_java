public class Employee {
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
    private String position;
    private Integer salary;
    private Integer bonus;

    // Constructors
    public Employee() {
    }

    public Employee(String name, String age, String address, String phoneNumber, String position, Integer salary,
            Integer bonus) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
        this.bonus = bonus;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getAge() {
        return age;
    }



    public void setAge(String age) {
        this.age = age;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getPosition() {
        return position;
    }



    public void setPosition(String position) {
        this.position = position;
    }



    public Integer getSalary() {
        return salary;
    }



    public void setSalary(Integer salary) {
        this.salary = salary;
    }



    public Integer getBonus() {
        return bonus;
    }



    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }



    // Method untuk menampilkan data
    public void showData() {
        System.out.println("+============================================+");
        System.out.println("Nama: " + this.name );
        System.out.println("Umur: " + this.age );
        System.out.println("Alamat: " + this.address );
        System.out.println("No. Handphone: " + this.phoneNumber );
        System.out.println("Posisi: " + this.position );
        System.out.println("Gaji: " + this.salary );
        System.out.println("Bonus: " + this.bonus );
        System.out.println("+============================================+");
    }
}

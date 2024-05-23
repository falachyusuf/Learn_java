public class App {
    public static void main(String[] args) throws Exception {
        // login sistem
        String [] emails = {"user1@example.com", "user2@example.com", "user3@example.com"};
        String [] passwords = { "user1", "user2", "user3" };
        String [] roles = { "admin", "user", "user"};
        // System.out.println(login("user@example.com", "user1", "admin", emails, passwords, roles));
        // Salary sistem
        Integer [] base_salaries = { 500, 700, 1000 };
        String [] departements = { "Marketing", "Human Resources", "IT" };
        // View user sistem


        System.out.println(login("user2@example.com", "user2", "user", emails, passwords, roles));
        System.out.println(getBaseSalary("user2@example.com", "user2", "user", "Human Resources", departements, base_salaries, emails, passwords, roles));
        countSalary("user2@example.com", "user2", "user", "Human Resources", departements, base_salaries, emails, passwords, roles);

    }

    // Non void methods
    public static boolean login(String email, String password, String role, String[] emails, String[] passwords, String[] roles) {
        for(int i=0; i < emails.length; i++) {
            if (email.equals(emails[i]) && password.equals(passwords[i]) && role.equals(roles[i])) {
                return true;
            }
        }
        return false;
    }

    // Cek base salary
    public static int getBaseSalary(String email, String password, String role, String departement, String [] departements, Integer [] base_salaries, String[] emails, String[] passwords, String[] roles){
        boolean condition = login(email, password, role, emails, passwords, roles);
        if(condition) {
            for(int i=0; i < departements.length; i++){
                if(departement.equals(departements[i])){
                    return base_salaries[i];
                }
            }
        };
        return 0;
    };


    // Void methods
    public static void countSalary(String email, String password, String role, String departement, String [] departements, Integer [] base_salaries, String[] emails, String[] passwords, String[] roles ){
        Integer base_salary = getBaseSalary(email, password, role, departement, departements, base_salaries, emails, passwords, roles);
        if(departement.equals("Marketing")){
            Integer bonus = 100;
            Integer total_salary = base_salary + bonus;
            System.out.println("The total salary of " + email + "is: " + total_salary);
        } else if(departement.equals("Human Resources")){
            Integer bonus = 200;
            Integer total_salary = base_salary + bonus;
            System.out.println("The total salary of " + email + " is: " + total_salary);
        } else if(departement.equals("IT")){
            Integer bonus = 500;
            Integer total_salary = base_salary + bonus;
            System.out.println("The total salary of " + email + " is: " + total_salary);
        } else {
            System.out.println("The total salary of " + email + " is: " + 0);
        }
    };


}


// Variables : wadah untuk menyimpan value
// data_type : tipe data
// value : nilai
// konstanta dalam java : final [tipe_data] [nama_variables]
// Void : fungsi yang tidak mengembalikan nilai
// Non Void : fungsi yang mengembalikan nilai

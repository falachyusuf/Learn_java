import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan username anda: ");
        String email = scanner.nextLine();
        System.out.println("Masukkan password: ");
        String password = scanner.nextLine();
        // Getter and setter
        User user = new User();
        user.setUserName(email);
        user.setPassword(password);

        // Cek status login
        boolean status = user.userLogin(user.getUserName(), user.getPassword());
        if(status){
            // Scanner
            System.out.println("+=============================================================+");
            System.out.println("Anda berhasil login, silahkan lanjutkan mengisi data diri anda");
            System.out.println("+=============================================================+");
            System.out.println("Masukkan nama anda: ");
            GenericsAny <String> employee = new GenericsAny<String>();
            employee.setValue1(scanner.nextLine());
            System.out.println("Masukkan posisi: ");
            employee.setValue2(scanner.nextLine());
            // Getter and setter

            System.out.println("Selamat datang " + employee.getValue1());
            System.out.println("Posisi anda: " + employee.getValue2());
            System.out.println("+===========================================================+");
            System.out.println("Silahkan pilih menu departemet untuk melihat total gaji: ");
            System.out.println("+===========================================================+");
            showDepartement();
            System.out.println("Masukkan pilihan anda: ");
            Integer pilih = scanner.nextInt();


            switch (pilih) {
                case 1:
                HR hr = new HR();
                showDepartement(pilih);
                System.out.println("+===============================================================================================================================+");
                hr.thisDepartment();
                System.out.println("+===============================================================================================================================+");
                GenericsAny <Integer> HumanResources = new GenericsAny <Integer>();
                HumanResources.setValue1(500);
                HumanResources.setValue2(300);
                System.out.println("Total gaji yang didapatkan: $" + HumanResources.Look(HumanResources.getValue1(), HumanResources.getValue2()));
                    break;
                    case 2:
                    IT it = new IT();
                    showDepartement(pilih);
                    System.out.println("+===============================================================================================================================+");
                    it.thisDepartment();
                    System.out.println("+===============================================================================================================================+");
                    GenericsAny <Integer> iT = new GenericsAny <Integer>();
                    iT.setValue1(3000);
                    iT.setValue2(1500);
                    System.out.println("Total gaji yang didapatkan: $" + iT.Look(iT.getValue1(), iT.getValue2()));
                    break;
                    case 3:
                    Marketing marketings = new Marketing();
                    showDepartement(pilih);
                    System.out.println("+===============================================================================================================================+");
                    marketings.thisDepartment();
                    System.out.println("+===============================================================================================================================+");
                    GenericsAny <Integer> marketing = new GenericsAny <Integer>();
                    marketing.setValue1(300);
                    marketing.setValue2(200);
                    System.out.println("Total gaji yang didapatkan: $" + marketing.Look(marketing.getValue1(), marketing.getValue2()));
                    break;
                    case 4:
                        EmployeeData data = new EmployeeData();
                        data.setEmployees(new Employee("John", "22", "Jln.Example", "01234567", "HR", 500, 300));
                        data.setEmployees(new Employee("Jaka", "18", "Jln.Example2", "01234568", "IT", 2000, 1000));
                        data.setEmployees(new Employee("Jojo", "21", "Jln.Example3", "01234569", "Marketing", 800, 500));
                        // data.getEmployees();
                        data.sortEmployees();
                    default:
                    break;
                }
            }else{
                System.out.println("Email dan password yang anda masukkan salah");
            }
        }

        public static void showDepartement(){
            String[] departement = { "HR", "IT", "Marketing", "Masukkan data pegawai"};
            for (int i = 1; i < departement.length + 1; i++) {
                System.out.println(i + ". " + departement[i - 1]);
            }
        }
        public static void showDepartement(Integer pilihan){
            String[] departement = { "HR", "IT", "Marketing", "Masukkan data pegawai"};
            System.out.println("Anda memilih departement "+ departement[pilihan - 1]);
        }
}

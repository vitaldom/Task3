package bnt;

public class Main {

    public static void main(String[] args) {
//        Company company = new Company();
//
//        for (int i = 0; i < 1000; i++) {
//            company.addEmployee(new Employee());
//        }
//
//        int numberOfNulls = 0;
//
//        for (int i = 0; i < company.getEmployees().length; i++) {
//            if (company.getEmployees()[i] == null) {
//                numberOfNulls++;
//                System.out.println("Null!");
//            } else {
//                System.out.println("ok");
//            };
//        }
//
//        System.out.println(company.getEmployees().length);
//        System.out.println("number of nulls: " + numberOfNulls);

        Employee developer = new Developer(40, 20);


        System.out.println(developer instanceof Developer);

//        System.out.println("Developer's salary without bonus: " + developer.getSalary());
        System.out.println("Developer's salary with bonus: " + ((Developer) developer).getSalary(200));

    }
}

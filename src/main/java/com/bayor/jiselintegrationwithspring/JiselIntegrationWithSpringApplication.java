package com.bayor.jiselintegrationwithspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class JiselIntegrationWithSpringApplication implements CommandLineRunner {

    static final String NEWLINE = "\n";

    Logger log = Logger.getLogger(JiselIntegrationWithSpringApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(JiselIntegrationWithSpringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        displayReports();
    }


//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    public JiselIntegrationWithSpringApplication(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    void displayReports() {
//        log.info(
//                format(
//                        """
//
//
//
//
//                                ================ COMMON REPORTS ================
//
//                                > Find by FirstName (containing "o")  or LastName (containing "il":
//                                %s
//
//                                > Find by E-mail Address (containing "email"):
//                                %s
//
//
//
//                                ================ HR REPORTS ================
//
//                                > Count Employees sharing Same Home Address:
//                                %s
//
//                                > Total Accrued Vacation Days per Department:
//                                %s
//
//
//
//                                ================ SECURITY REPORTS ================
//
//                                > Employees with First Name and Last Name listed in More Than 1 Department:
//                                %s
//
//                                > Employees with Different IDs using Same E-mail Addresses:
//                                %s
//
//
//
//                                ================ MANAGEMENT REPORTS ================
//
//                                > Employees who Started More than 5 years ago AND with a current Salary Less than 50000:
//                                %s
//
//
//
//
//
//
//                                """,
//
//                        employeeRepository.findByFirstNameContainingOrLastNameContaining("o", "il").stream()
//                                .map(employee -> format("%s %s", employee.getFirstName(), employee.getLastName()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.findByEmailAddressContaining("email").stream()
//                                .map(employee -> format("%s %s - %s", employee.getFirstName(), employee.getLastName(), employee.getEmailAddress()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.countEmployeesSharingSameHomeAddress().stream()
//                                .map(row -> format("%s %s", row[0].toString(), row[1].toString()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.totalAccruedVacationsPerDepartment().stream()
//                                .map(row -> format("%s %s", row[0].toString(), row[1].toString()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.employeesListedInMoreThan1Department().stream()
//                                .map(employee -> format("%s %s (%s), %s - %s, since %s",
//                                        employee.getFirstName(),
//                                        employee.getLastName(),
//                                        employee.getEmailAddress(),
//                                        employee.getPosition(),
//                                        employee.getDepartment(),
//                                        employee.getStartDate()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.employeesWithDifferentIDsUsingSameEmailAddresses().stream()
//                                .map(employee -> format("%s, %s %s (ID#%s) %s - %s",
//                                        employee.getEmailAddress(),
//                                        employee.getFirstName(),
//                                        employee.getLastName(),
//                                        employee.getId(),
//                                        employee.getPosition(),
//                                        employee.getDepartment()))
//                                .collect(Collectors.joining(NEWLINE)),
//
//                        employeeRepository.employeesWithMoreThanXYearsAndSalaryLessThanY(5, 50000).stream()
//                                .map(row -> format("%s %s, since %s (%s years), salary: %s",
//                                        row[0].toString(), row[1].toString(), row[2].toString(), row[4].toString(), row[3].toString()))
//                                .collect(Collectors.joining(NEWLINE))
//                )
//        );
    }
}

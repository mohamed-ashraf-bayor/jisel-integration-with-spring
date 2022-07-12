package com.bayor.jiselintegrationwithspring;

import com.bayor.jiselintegrationwithspring.repos.detached.CommonReportsRepository;
import com.bayor.jiselintegrationwithspring.repos.detached.HumanResourcesReportsRepository;
import com.bayor.jiselintegrationwithspring.repos.detached.ManagementReportsRepository;
import com.bayor.jiselintegrationwithspring.repos.detached.SecurityReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.String.format;

@SpringBootApplication
public class JiselIntegrationWithSpringApplication implements CommandLineRunner {

    Logger log = Logger.getLogger(JiselIntegrationWithSpringApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(JiselIntegrationWithSpringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        displayReports();
    }

    @Autowired
    CommonReportsRepository commonReportsRepository;
    @Autowired
    HumanResourcesReportsRepository humanResourcesReportsRepository;
    @Autowired
    SecurityReportsRepository securityReportsRepository;
    @Autowired
    ManagementReportsRepository managementReportsRepository;

    void displayReports() {
        log.info(
                format(
                        """




                                ================ COMMON REPORTS ================

                                > Find by FirstName (containing "o")  or LastName (containing "il":
                                %s

                                > Find by E-mail Address (containing "email"):
                                %s



                                ================ HR REPORTS ================

                                > Count Employees sharing Same Home Address:
                                %s

                                > Total Accrued Vacation Days per Department:
                                %s



                                ================ SECURITY REPORTS ================

                                > Employees with First Name and Last Name listed in More Than 1 Department:
                                %s

                                > Employees with Different IDs using Same E-mail Addresses:
                                %s



                                ================ MANAGEMENT REPORTS ================

                                > Employees who Started More than 5 years ago AND with a current Salary Less than 50000:
                                %s






                                """,

                        // ================ COMMON REPORTS ================

                        commonReportsRepository.findByFirstNameContainingOrLastNameContaining("o", "il").stream()
                                .map(employee -> format("%s %s", employee.getFirstName(), employee.getLastName()))
                                .collect(Collectors.joining("\n")),

                        commonReportsRepository.findByEmailAddressContaining("email").stream()
                                .map(employee -> format("%s %s - %s", employee.getFirstName(), employee.getLastName(), employee.getEmailAddress()))
                                .collect(Collectors.joining("\n")),

                        // ================ HR REPORTS ================

                        humanResourcesReportsRepository.countEmployeesSharingSameHomeAddress().stream()
                                .map(row -> format("%s %s", row[0].toString(), row[1].toString()))
                                .collect(Collectors.joining("\n")),

                        humanResourcesReportsRepository.totalAccruedVacationsPerDepartment().stream()
                                .map(row -> format("%s %s", row[0].toString(), row[1].toString()))
                                .collect(Collectors.joining("\n")),

                        // ================ SECURITY REPORTS ================

                        securityReportsRepository.employeesWithFirstNameAndLastNameListedInMoreThan1Department().stream()
                                .map(employee -> format("%s %s (%s), %s - %s, since %s",
                                        employee.getFirstName(),
                                        employee.getLastName(),
                                        employee.getEmailAddress(),
                                        employee.getPosition(),
                                        employee.getDepartment(),
                                        employee.getStartDate()))
                                .collect(Collectors.joining("\n")),

                        securityReportsRepository.employeesWithDifferentIDsUsingSameEmailAddresses().stream()
                                .map(employee -> format("%s, %s %s (ID#%s) %s - %s",
                                        employee.getEmailAddress(),
                                        employee.getFirstName(),
                                        employee.getLastName(),
                                        employee.getId(),
                                        employee.getPosition(),
                                        employee.getDepartment()))
                                .collect(Collectors.joining("\n")),

                        // ================ MANAGEMENT REPORTS ================

                        managementReportsRepository.employeesWithMoreThanXYearsAndSalaryLessThanY(5, 50000).stream()
                                .map(row -> format("%s %s, since %s (%s years), salary: %s",
                                        row[0].toString(), row[1].toString(), row[2].toString(), row[4].toString(), row[3].toString()))
                                .collect(Collectors.joining("\n"))
                )
        );
    }
}

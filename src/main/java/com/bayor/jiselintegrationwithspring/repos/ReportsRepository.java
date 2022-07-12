package com.bayor.jiselintegrationwithspring.repos;

import com.bayor.jiselintegrationwithspring.entities.Employee;
import org.jisel.annotations.Detach;
import org.jisel.annotations.SealFor;
import org.jisel.annotations.TopLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.bayor.jiselintegrationwithspring.repos.ReportsRepository.HUMAN_RESOURCES;
import static com.bayor.jiselintegrationwithspring.repos.ReportsRepository.MANAGEMENT;
import static com.bayor.jiselintegrationwithspring.repos.ReportsRepository.SECURITY;
import static com.bayor.jiselintegrationwithspring.repos.ReportsRepository.TOPLEVEL_KW;

@Detach(profile = TOPLEVEL_KW,
        rename = "CommonReportsRepository",
        applyAnnotations = "@org.springframework.stereotype.Repository",
        superInterfaces = Repository.class,
        firstSuperInterfaceGenerics = {Employee.class, Long.class}
)
@Detach(profile = HUMAN_RESOURCES,
        rename = HUMAN_RESOURCES + "ReportsRepository",
        applyAnnotations = "@org.springframework.stereotype.Repository",
        superInterfaces = PagingAndSortingRepository.class,
        firstSuperInterfaceGenerics = {Employee.class, Long.class}
)
@Detach(profile = SECURITY,
        rename = SECURITY + "ReportsRepository",
        applyAnnotations = "@org.springframework.stereotype.Repository",
        superInterfaces = CrudRepository.class,
        firstSuperInterfaceGenerics = {Employee.class, Long.class}
)
@Detach(profile = MANAGEMENT,
        rename = MANAGEMENT + "ReportsRepository",
        applyAnnotations = "@org.springframework.stereotype.Repository",
        superInterfaces = JpaRepository.class,
        firstSuperInterfaceGenerics = {Employee.class, Long.class}
)
public interface ReportsRepository {

    String TOPLEVEL_KW = "(toplevel)"; // keyword used to tell jisel to detach the top-level interface

    String HUMAN_RESOURCES = "HumanResources";
    String SECURITY = "Security";
    String MANAGEMENT = "Management";

    @TopLevel
    List<Employee> findByFirstNameContainingOrLastNameContaining(String firstNameSearchCriteria, String lastNameSearchCriteria);

    @TopLevel
    List<Employee> findByEmailAddressContaining(String emailAddressSearchCriteria);

    @SealFor(HUMAN_RESOURCES)
    @SealFor(MANAGEMENT)
    @Query(
            nativeQuery = true,
            value = """
                    SELECT home_address, COUNT(id) total
                    FROM employee
                    GROUP BY home_address
                    HAVING total > 1
                    ORDER BY total DESC
                    """
    )
    List<Object[]> countEmployeesSharingSameHomeAddress();

    @SealFor(HUMAN_RESOURCES)
    @SealFor(MANAGEMENT)
    @Query(
            nativeQuery = true,
            value = """
                    SELECT department, SUM(accrued_vacation_days) total
                    FROM employee
                    GROUP BY department
                    ORDER BY total desc
                    """
    )
    List<Object[]> totalAccruedVacationsPerDepartment();

    @SealFor(SECURITY)
    @Query(
            nativeQuery = true,
            value = """
                    SELECT e1.*
                    FROM employee e1
                    INNER JOIN employee e2
                    ON (e1.department <> e2.department
                    AND e1.first_name = e2.first_name
                    AND e1.last_name = e2.last_name)
                    ORDER BY e1.first_name, e1.last_name
                    """
    )
    List<Employee> employeesWithFirstNameAndLastNameListedInMoreThan1Department();

    @SealFor(SECURITY)
    @Query(
            nativeQuery = true,
            value = """
                    SELECT distinct e1.*
                    FROM employee e1
                    INNER JOIN employee e2
                    ON (e1.email_address = e2.email_address
                    AND e1.ID <> e2.ID)
                    ORDER BY email_address
                    """
    )
    List<Employee> employeesWithDifferentIDsUsingSameEmailAddresses();

    @SealFor(MANAGEMENT)
    @Query(
            nativeQuery = true,
            value = """
                    SELECT first_name, last_name, FORMATDATETIME(start_date, 'yyyy-MM-dd'), annual_salary, DATEDIFF(year, start_date, NOW()) totalYears
                    FROM employee
                    WHERE DATEDIFF(year, start_date, NOW()) >= :totalYears
                    AND annual_salary < :annualSalary
                    ORDER BY totalYears DESC
                                    
                    """
    )
    List<Object[]> employeesWithMoreThanXYearsAndSalaryLessThanY(@Param("totalYears") int totalYearsCriteria, @Param("annualSalary") long annualSalaryCriteria);
}
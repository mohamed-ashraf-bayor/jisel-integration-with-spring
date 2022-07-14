package com.bayor.jiselintegrationwithspring.repos.notused;

import com.bayor.jiselintegrationwithspring.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * shows how {@link com.bayor.jiselintegrationwithspring.repos.ReportsRepository} looks like before we apply Jisel annotations
 */
public interface ReportsRepositoryBeforeApplyingJisel /* would extend a known Spring Repository interface */ {

    List<Employee> findByFirstNameContainingOrLastNameContaining(String firstNameSearchCriteria, String lastNameSearchCriteria);

    List<Employee> findByEmailAddressContaining(String emailAddressSearchCriteria);

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
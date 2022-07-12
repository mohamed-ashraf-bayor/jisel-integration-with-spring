package com.bayor.jiselintegrationwithspring.repos.detached;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-11T22:01:41.8416688-04:00",
  comments = "version: 1.2"
)
@org.springframework.stereotype.Repository
public interface ManagementReportsRepository extends org.springframework.data.jpa.repository.JpaRepository<com.bayor.jiselintegrationwithspring.entities.Employee, java.lang.Long> {
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT department, SUM(accrued_vacation_days) total\nFROM employee\nGROUP BY department\nORDER BY total desc\n")
 	java.util.List<java.lang.Object[]> totalAccruedVacationsPerDepartment();
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT first_name, last_name, FORMATDATETIME(start_date, \'yyyy-MM-dd\'), annual_salary, DATEDIFF(year, start_date, NOW()) totalYears\nFROM employee\nWHERE DATEDIFF(year, start_date, NOW()) >= :totalYears\nAND annual_salary < :annualSalary\nORDER BY totalYears DESC\n\n")
 	java.util.List<java.lang.Object[]> employeesWithMoreThanXYearsAndSalaryLessThanY(@org.springframework.data.repository.query.Param("totalYears") int totalYearsCriteria, @org.springframework.data.repository.query.Param("annualSalary") long annualSalaryCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT home_address, COUNT(id) total\nFROM employee\nGROUP BY home_address\nHAVING total > 1\nORDER BY total DESC\n")
 	java.util.List<java.lang.Object[]> countEmployeesSharingSameHomeAddress();
}

package com.bayor.jiselintegrationwithspring.repos;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-12T08:14:52.1987889-04:00",
  comments = "version: 1.2"
)
public sealed interface SealedManagementReportsRepository extends SealedHumanResourcesReportsRepository permits _ReportsRepositoryFinalCass {
 	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT first_name, last_name, FORMATDATETIME(start_date, \'yyyy-MM-dd\'), annual_salary, DATEDIFF(year, start_date, NOW()) totalYears\nFROM employee\nWHERE DATEDIFF(year, start_date, NOW()) >= :totalYears\nAND annual_salary < :annualSalary\nORDER BY totalYears DESC\n\n")
 	java.util.List<java.lang.Object[]> employeesWithMoreThanXYearsAndSalaryLessThanY(@org.springframework.data.repository.query.Param("totalYears") int totalYearsCriteria, @org.springframework.data.repository.query.Param("annualSalary") long annualSalaryCriteria);
}

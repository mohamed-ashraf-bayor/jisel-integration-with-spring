package com.bayor.jiselintegrationwithspring.repos;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-12T08:14:52.2187361-04:00",
  comments = "version: 1.2"
)
public final class _ReportsRepositoryFinalCass implements SealedManagementReportsRepository, SealedSecurityReportsRepository {
 	public java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria) {return null;}
	public java.util.List<java.lang.Object[]> countEmployeesSharingSameHomeAddress() {return null;}
	public java.util.List<java.lang.Object[]> totalAccruedVacationsPerDepartment() {return null;}
	public java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> employeesWithDifferentIDsUsingSameEmailAddresses() {return null;}
	public java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria) {return null;}
	public java.util.List<java.lang.Object[]> employeesWithMoreThanXYearsAndSalaryLessThanY(@org.springframework.data.repository.query.Param("totalYears") int totalYearsCriteria, @org.springframework.data.repository.query.Param("annualSalary") long annualSalaryCriteria) {return null;}
	public java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> employeesWithFirstNameAndLastNameListedInMoreThan1Department() {return null;}
}

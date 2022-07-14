package com.bayor.jiselintegrationwithspring.repos.detached;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-14T07:56:01.2765393-04:00",
  comments = "version: 1.2"
)
@org.springframework.stereotype.Repository
public interface HumanResourcesReportsRepository extends org.springframework.data.repository.PagingAndSortingRepository<com.bayor.jiselintegrationwithspring.entities.Employee, java.lang.Long> {
 	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT home_address, COUNT(id) total\nFROM employee\nGROUP BY home_address\nHAVING total > 1\nORDER BY total DESC\n")
 	java.util.List<java.lang.Object[]> countEmployeesSharingSameHomeAddress();
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT department, SUM(accrued_vacation_days) total\nFROM employee\nGROUP BY department\nORDER BY total desc\n")
 	java.util.List<java.lang.Object[]> totalAccruedVacationsPerDepartment();
}

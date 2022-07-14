package com.bayor.jiselintegrationwithspring.repos;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-14T07:56:00.9873153-04:00",
  comments = "version: 1.2"
)
public sealed interface SealedHumanResourcesReportsRepository extends SealedReportsRepository permits SealedManagementReportsRepository {
 	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT home_address, COUNT(id) total\nFROM employee\nGROUP BY home_address\nHAVING total > 1\nORDER BY total DESC\n")
 	java.util.List<java.lang.Object[]> countEmployeesSharingSameHomeAddress();
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT department, SUM(accrued_vacation_days) total\nFROM employee\nGROUP BY department\nORDER BY total desc\n")
 	java.util.List<java.lang.Object[]> totalAccruedVacationsPerDepartment();
}

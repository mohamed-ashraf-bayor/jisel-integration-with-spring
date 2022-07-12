package com.bayor.jiselintegrationwithspring.repos;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-11T22:01:41.7768411-04:00",
  comments = "version: 1.2"
)
public sealed interface SealedReportsRepository permits SealedHumanResourcesReportsRepository, SealedSecurityReportsRepository {
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
}

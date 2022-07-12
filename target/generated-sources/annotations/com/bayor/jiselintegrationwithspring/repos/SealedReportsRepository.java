package com.bayor.jiselintegrationwithspring.repos;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-12T08:45:01.5346757-04:00",
  comments = "version: 1.2"
)
public sealed interface SealedReportsRepository permits SealedHumanResourcesReportsRepository, SealedSecurityReportsRepository {
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
}

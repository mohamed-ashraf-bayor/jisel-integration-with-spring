package com.bayor.jiselintegrationwithspring.repos.detached;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-12T08:45:01.5995028-04:00",
  comments = "version: 1.2"
)
@org.springframework.stereotype.Repository
public interface CommonReportsRepository extends org.springframework.data.repository.Repository<com.bayor.jiselintegrationwithspring.entities.Employee, java.lang.Long> {
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
}

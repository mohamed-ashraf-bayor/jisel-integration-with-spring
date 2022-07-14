package com.bayor.jiselintegrationwithspring.repos.detached;

@javax.annotation.processing.Generated(
  value = "org.jisel.JiselAnnotationProcessor",
  date = "2022-07-14T07:56:01.2486132-04:00",
  comments = "version: 1.2"
)
@org.springframework.stereotype.Repository
public interface SecurityReportsRepository extends org.springframework.data.repository.CrudRepository<com.bayor.jiselintegrationwithspring.entities.Employee, java.lang.Long> {
 	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT distinct e1.*\nFROM employee e1\nINNER JOIN employee e2\nON (e1.email_address = e2.email_address\nAND e1.ID <> e2.ID)\nORDER BY email_address\n")
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> employeesWithDifferentIDsUsingSameEmailAddresses();
	@org.springframework.data.jpa.repository.Query(nativeQuery=true, value="SELECT e1.*\nFROM employee e1\nINNER JOIN employee e2\nON (e1.department <> e2.department\nAND e1.first_name = e2.first_name\nAND e1.last_name = e2.last_name)\nORDER BY e1.first_name, e1.last_name\n")
 	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> employeesWithFirstNameAndLastNameListedInMoreThan1Department();
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByFirstNameContainingOrLastNameContaining(java.lang.String firstNameSearchCriteria, java.lang.String lastNameSearchCriteria);
	java.util.List<com.bayor.jiselintegrationwithspring.entities.Employee> findByEmailAddressContaining(java.lang.String emailAddressSearchCriteria);
}

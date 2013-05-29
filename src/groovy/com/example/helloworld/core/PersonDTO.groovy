package com.example.helloworld.core

class PersonDTO {
	Long id
	String fullName
	String jobTitle

	PersonDTO() {}

	PersonDTO(Person person) {
		id = person.id
		fullName = person.fullName
		jobTitle = person.jobTitle
	}
}

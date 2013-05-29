package com.example.helloworld

import com.example.helloworld.core.Person
import com.example.helloworld.core.PersonDTO

class PersonService {

	Person create(PersonDTO dto) {
		Person person = new Person(fullName: dto.fullName, jobTitle: dto.jobTitle)
		person.save()
		person
	}
}

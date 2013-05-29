package com.example.helloworld.resources

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.example.helloworld.core.Person
import com.example.helloworld.core.PersonDTO
import com.sun.jersey.api.NotFoundException
import com.yammer.dropwizard.jersey.params.LongParam

@Path('/people/{personId}')
@Produces(MediaType.APPLICATION_JSON)
class PersonDropwizardResource {

	@GET
	PersonDTO getPerson(@PathParam('personId') LongParam personId) {
		Person person = Person.get(personId.get())
		if (!person) {
			throw new NotFoundException('No such user.')
		}
		new PersonDTO(person)
	}
}

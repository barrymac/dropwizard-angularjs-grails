package com.example.helloworld.resources

import com.example.helloworld.core.Person
import com.example.helloworld.core.PersonDTO
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/people/list')
@Produces(MediaType.APPLICATION_JSON)
class PeopleListDropwizardResource {

    def personService

    @POST
    PersonDTO createPerson(PersonDTO dto) {
        Person person = personService.create(dto)
        new PersonDTO(person)
    }

    @GET
    @Timed(name = 'get-requests-people')
    List<PersonDTO> listPeople() {
        Person.list().collect { new PersonDTO(it) }
    }

}

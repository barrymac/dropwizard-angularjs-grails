package com.example.helloworld.resources

import com.example.helloworld.core.Person
import com.example.helloworld.core.PersonDTO
import com.yammer.metrics.annotation.Timed

import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path('/people/save')
@Produces(MediaType.APPLICATION_JSON)
class PeopleCreateDropwizardResource {

    def personService

    @POST
    @Timed(name = 'post-requests-people')
    PersonDTO createPerson(PersonDTO dto) {
        Person person = personService.create(dto)
        new PersonDTO(person)
    }

}

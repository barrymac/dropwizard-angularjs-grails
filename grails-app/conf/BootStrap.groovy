import com.example.helloworld.core.Person

class BootStrap {

    def init = { servletContext ->

        (1..300).each {
            new Person(fullName: "Jones $it", jobTitle: "Name $it").save(flush: true)
            println(it)
        }

        new Person(fullName: 'Person Jones', jobTitle: 'Jefe Grande').save()
    }
}

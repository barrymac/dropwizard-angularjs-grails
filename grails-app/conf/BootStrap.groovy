import com.example.helloworld.core.Person

class BootStrap {

	def init = { servletContext ->
		new Person(fullName: 'Person Jones', jobTitle: 'Jefe Grande').save()
	}
}

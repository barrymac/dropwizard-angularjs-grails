package com.example.helloworld.resources

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

import com.yammer.dropwizard.views.View

@Path('/views')
class ViewDropwizardResource {

	@GET
	@Produces('text/html;charset=UTF-8')
	@Path('/utf8.ftl')
	View freemarkerUTF8() {
		new View('/views/ftl/utf8.ftl') {}
	}

	@GET
	@Produces('text/html;charset=UTF-8')
	@Path('/utf8.mustache')
	View mustacheUTF8() {
		new View('/views/mustache/utf8.mustache') {}
	}
}

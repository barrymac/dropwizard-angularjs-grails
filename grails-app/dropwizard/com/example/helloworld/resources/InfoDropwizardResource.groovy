package com.example.helloworld.resources

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

import com.yammer.dropwizard.config.Configuration

@Path("/info")
class InfoDropwizardResource {

	def dropwizard

	@GET
	Response doGet() {
		Configuration configuration = dropwizard.configuration
		return Response.ok(String.format('Application is running on port : %d connectorType : %s',
			configuration.httpConfiguration.port, configuration.httpConfiguration.connectorType)).build()
	}
}

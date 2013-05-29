package com.example.helloworld.resources

import grails.plugin.dropwizard.ConfigValue

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

import com.example.helloworld.core.Saying
import com.google.common.base.Optional
import com.yammer.dropwizard.jersey.caching.CacheControl
import com.yammer.metrics.annotation.Timed

@Path('/hello-world')
@Produces(MediaType.APPLICATION_JSON)
class HelloWorldDropwizardResource {

	@ConfigValue('dropwizard.hc.template')
	private String template
	private String defaultName = 'Stranger'
	private final AtomicLong counter = new AtomicLong()

	@GET
	@Timed(name='get-requests')
	@CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
	Saying sayHello(@QueryParam('name') Optional<String> name) {
		new Saying(counter.incrementAndGet(), String.format(template, name.or(defaultName)))
	}

	@POST
	void receiveHello(@Valid Saying saying) {
		log.info('Received a saying: {}', saying)
	}
}

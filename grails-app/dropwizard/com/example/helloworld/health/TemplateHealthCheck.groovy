package com.example.helloworld.health

import grails.plugin.dropwizard.ConfigValue

import com.yammer.metrics.core.HealthCheck
import com.yammer.metrics.core.HealthCheck.Result

class TemplateHealthCheck extends HealthCheck {

	@ConfigValue('dropwizard.hc.template')
	private String template

	TemplateHealthCheck() {
		super('template')
	}

	@Override
	protected Result check() {
		final String saying = String.format(template, 'TEST')
		if (saying.contains('TEST')) {
			return Result.healthy()
		}

		return Result.unhealthy("template doesn't include a name")
	}
}

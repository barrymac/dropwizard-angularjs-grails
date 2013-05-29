package com.example.helloworld.health

import com.yammer.metrics.core.HealthCheck
import com.yammer.metrics.core.HealthCheck.Result

class DataSourceHealthCheck extends HealthCheck {

	def dataSource

	DataSourceHealthCheck() {
		super('DataSource')
	}

	@Override
	protected Result check() {
		try {
			dataSource.connection.close()
			return Result.healthy()
		}
		catch (e) {
			return Result.unhealthy(e)
		}
	}
}

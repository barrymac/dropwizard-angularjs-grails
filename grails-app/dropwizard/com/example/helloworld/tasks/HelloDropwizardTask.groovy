package com.example.helloworld.tasks

import com.google.common.collect.ImmutableMultimap
import com.yammer.dropwizard.tasks.Task

class HelloDropwizardTask extends Task {

	HelloDropwizardTask() {
		super('hello-task')
	}

	@Override
	void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) {
		output.println('my task complete.')
	}
}

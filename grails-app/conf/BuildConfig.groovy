grails.servlet.version = '3.0'
grails.project.work.dir = 'target'
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits 'global', {
		excludes 'grails-plugin-log4j', 'log4j'
	}
	log 'warn'
	checksums true

	repositories {
		inherits true
		grailsPlugins()
		grailsHome()
		grailsCentral()
	}

	dependencies {}

	plugins {
//        grails.plugin.location.logback = "home/barry/workspace/grails-logback"
//        grails.plugin.location.dropwizard = "home/barry/workspace/grails-dropwizard"
        runtime ":hibernate:$grailsVersion"
		runtime ':jquery:1.8.0'
		runtime ':resources:1.1.6'

        compile ':angular-scaffolding:1.0-SNAPSHOT'
        compile ':dropwizard:0.1'
	}
}

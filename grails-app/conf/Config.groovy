/*
grails.config.locations = ["classpath:${appName}-config.groovy", "file:./${appName}-config.groovy"]
if (System.properties["${appName}.config.location"]) {
	grails.config.locations << 'file:' + System.properties["${appName}.config.location"]
}
*/

grails.project.groupId = appName
grails.mime.file.extensions = false
grails.mime.use.accept.header = false
grails.mime.types = [
	html: ['text/html','application/xhtml+xml'],
	xml: ['text/xml', 'application/xml'],
	text: 'text/plain',
	js: 'text/javascript',
	rss: 'application/rss+xml',
	atom: 'application/atom+xml',
	css: 'text/css',
	csv: 'text/csv',
	all: '*/*',
	json: ['application/json','text/json'],
	form: 'application/x-www-form-urlencoded',
	multipartForm: 'multipart/form-data'
]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.views.default.codec = 'html'
grails.views.gsp.encoding = 'UTF-8'
grails.converters.encoding = 'UTF-8'
grails.views.gsp.sitemesh.preprocess = true
grails.scaffolding.templates.domainSuffix = ''
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart=false
grails.exceptionresolver.params.exclude = ['password']
grails.hibernate.cache.queries = false

grails.dbconsole.enabled = true

environments {
	development {
		grails.logging.jul.usebridge = true
	}
	production {
		grails.logging.jul.usebridge = false
	}
}

logback = {
	error 'org.codehaus.groovy.grails',
	      'org.springframework',
	      'org.hibernate',
	      'net.sf.ehcache.hibernate'
	debug 'org.hibernate.SQL'
//	trace 'org.hibernate.type.descriptor.sql.BasicBinder'
}



dropwizard.hc.template = 'Hello, %s!'


grails.plugin.dropwizard.banner = '''/
   _____           _ _       _____                          _                  _   _______        _   
  / ____|         (_) |     |  __ \\                        (_)                | | |__   __|      | |  
 | |  __ _ __ __ _ _| |___  | |  | |_ __ ___  _ ____      ___ ______ _ _ __ __| |    | | ___  ___| |_ 
 | | |_ | '__/ _` | | / __| | |  | | '__/ _ \\| '_ \\ \\ /\\ / / |_  / _` | '__/ _` |    | |/ _ \\/ __| __|
 | |__| | | | (_| | | \\__ \\ | |__| | | | (_) | |_) \\ V  V /| |/ / (_| | | | (_| |    | |  __/\\__ \\ |_ 
  \\_____|_|  \\__,_|_|_|___/ |_____/|_|  \\___/| .__/ \\_/\\_/ |_/___\\__,_|_|  \\__,_|    |_|\\___||___/\\__|
                                             | |                                                      
                                             |_|                                                      
'''
//grails.plugin.dropwizard.dropwizardContext = '/dw'
//grails.plugin.dropwizard.autoRegisterTasks = true
//grails.plugin.dropwizard.autoRegisterManaged = false
//grails.plugin.dropwizard.yamlPath = 'classpath:dropwizard.yml'
//grails.plugin.dropwizard.yamlPath = 'file:src/java/dropwizard.yml'

grails.plugin.dropwizard.initializer = { bootstrap, environment, grailsConfiguration, grailsApplication ->
	println "\n\nINIT\n\n"
}

grails.plugin.dropwizard.assets = [['/static_stuff/', '/stuff/', 'index.html']]

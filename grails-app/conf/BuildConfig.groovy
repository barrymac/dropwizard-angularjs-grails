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
        compile ':gson:1.1.4'

        runtime ":hibernate:$grailsVersion",
                ':resources:1.2.RC2',
                ':jquery:1.8.3',
//                ':cached-resources:1.0',
                ':zipped-resources:1.0',
                ':database-migration:1.3.2'

        compile ':angular-scaffolding:1.0-SNAPSHOT'
        compile ':dropwizard:0.1'
    }
}

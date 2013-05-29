modules = {
    application {
        resource url: 'js/application.js'
    }
    bootstrap {
        dependsOn 'jquery'
        resource url: 'bootstrap/css/bootstrap.min.css', exclude: 'minify'
        resource url: 'bootstrap/css/bootstrap-responsive.min.css', exclude: 'minify'
        resource url: 'bootstrap/js/bootstrap.min.js', exclude: 'minify'
    }
    'font-awesome' {
        resource url: 'font-awesome/css/font-awesome.min.css', exclude: 'minify'
    }
    prefixfree {
        resource url: 'prefixfree/prefixfree.min.js', disposition: 'head', exclude: 'minify'
    }
    'ui-common' {
        dependsOn 'bootstrap', 'font-awesome'
        resource url: 'css/ui-common.css'
    }
}


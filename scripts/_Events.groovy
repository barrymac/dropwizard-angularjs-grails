eventCompileStart = {
	ant.copy(todir: buildSettings.resourcesDir, failonerror: false, preservelastmodified: true) {
		fileset(dir: 'src/resources') {
			exclude(name: '*.groovy')
			exclude(name: '*.java')
		}
	}
}

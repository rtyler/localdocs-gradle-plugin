package com.github.rtyler

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.*

class LocaldocsPluginSpec extends Specification {
    private project

    def setup() {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'com.github.rtyler.localdocs'
    }

    def "can create the plugin"() {
        when:
        def plugin = new LocaldocsPlugin()

        then:
        plugin instanceof LocaldocsPlugin
    }
}

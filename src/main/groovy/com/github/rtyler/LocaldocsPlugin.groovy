package com.github.rtyler

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.javadoc.Javadoc

class LocaldocsPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.configurations.create('localJavadocs')

        project.task('generateLocalJavadoc', type: Javadoc) {
            destinationDir = project.file("${project.buildDir}/local-javadocs")

            source = project.configurations.localJavadocs.files.collect { sourceArtifact ->
                zipTree(sourceArtifact).findAll {
                    it.name.endsWith('java')
                }
            }
        }
    }
}

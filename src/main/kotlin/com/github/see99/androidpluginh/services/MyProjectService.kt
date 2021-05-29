package com.github.see99.androidpluginh.services

import com.github.see99.androidpluginh.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

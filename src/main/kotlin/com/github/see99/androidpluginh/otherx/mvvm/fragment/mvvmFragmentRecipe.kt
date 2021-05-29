package com.github.see99.androidpluginh.otherx.mvvm.fragment

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.fragments.blankFragment.res.layout.fragmentBlankXml
import com.android.tools.idea.wizard.template.impl.fragments.blankFragment.res.values.stringsXml
import com.android.tools.idea.wizard.template.impl.fragments.blankFragment.src.app_package.blankFragmentJava
import com.android.tools.idea.wizard.template.impl.fragments.blankFragment.src.app_package.blankFragmentKt
import com.github.see99.androidpluginh.otherx.mvvm.activity.src.mvvmViewModel
import com.github.see99.androidpluginh.otherx.mvvm.fragment.src.mvvmFragmentKt
import com.github.see99.androidpluginh.otherx.mvvm.fragment.xml.mvvmFragmentXml

fun RecipeExecutor.mvvmFragmentRecipe(
        moduleData: ModuleTemplateData,
        className: String,
        layoutName: String
) {
    val (projectData, srcOut, resOut, _) = moduleData
//    val appCompatVersion = moduleData.apis.appCompatVersion
    val packageName = moduleData.packageName
    val applicationPackage = moduleData.projectTemplateData.applicationPackage
    val useAndroidX = moduleData.projectTemplateData.androidXSupport
    val ktOrJavaExt = projectData.language.extension
    addAllKotlinDependencies(moduleData)

//    addDependency("com.android.support:support-v4:${appCompatVersion}.+")
//    mergeXml(stringsXml(), resOut.resolve("values/strings.xml"))
    save(mvvmFragmentXml(className, packageName), resOut.resolve("layout/${layoutName}.xml"))
    open(resOut.resolve("layout/${layoutName}.xml"))
//    val blankFragment = when (projectData.language) {
//        Language.Java -> mvvmFragmentKt(applicationPackage, className, layoutName, packageName, useAndroidX)
//        Language.Kotlin -> mvvmFragmentKt(applicationPackage, className, layoutName, packageName, useAndroidX)
//    }
    save(mvvmFragmentKt(applicationPackage, className, layoutName, packageName, useAndroidX), srcOut.resolve("${className}Fragment.${ktOrJavaExt}"))
    save(mvvmViewModel(projectData.applicationPackage,packageName, className), srcOut.resolve("${className}ViewModel.${ktOrJavaExt}"))
    open(srcOut.resolve("${className}.${ktOrJavaExt}"))


}

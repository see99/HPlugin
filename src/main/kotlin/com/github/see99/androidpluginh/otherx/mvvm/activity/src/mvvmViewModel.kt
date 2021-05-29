package com.github.see99.androidpluginh.otherx.mvvm.activity.src

import com.android.tools.idea.wizard.template.PackageName

fun mvvmViewModel(
        applicationPackage: String?,
        packageName: String,
        activityClass: String,
): String {
    var applicationPackagex:String? = null
    if (applicationPackage==null){
        applicationPackagex = packageName
    }else{
        applicationPackagex = applicationPackage
    }


    return """
    package $packageName
    import $applicationPackagex.base.BaseViewModel
 
    class ${activityClass}ViewModel : BaseViewModel() {
       
    }
"""
}
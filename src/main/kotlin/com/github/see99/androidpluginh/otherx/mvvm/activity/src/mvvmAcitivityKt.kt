package com.github.see99.androidpluginh.otherx.mvvm.activity.src

fun layoutStr2JavaBinding(list: List<String>): String? {
    var str = ""
    for (i in list.indices){
//        if (i==0){
//            str += list[i]
//        }else{
            str += upperFirstLatter(list[i])
//        }
    }
    return str
}

fun upperFirstLatter(letter: String): String? {
    val chars = letter.toCharArray()
    if (chars[0] in 'a'..'z') {
        chars[0] = (chars[0] - 32)
    }
    return String(chars)
}

fun mvvmAcitivityKt(
        applicationPackage: String?,
        activityClass: String,
        layoutName: String,
        packageName: String,
): String {
    var applicationPackagex:String? = null
    if (applicationPackage==null){
        applicationPackagex = packageName
    }else{
        applicationPackagex = applicationPackage
    }

    var bindingClass:String? = null
    var arr = layoutName.split("_")
    bindingClass = if (arr.isEmpty()){
        null
    }else{
        layoutStr2JavaBinding(arr)
    }
    return """
package $packageName
import android.content.Intent
import ${applicationPackagex}.BR
import ${applicationPackagex}.R
import ${applicationPackagex}.base.BaseActivity
import ${applicationPackagex}.dagger.component.ActivityComponent
import ${applicationPackagex}.databinding.${bindingClass}Binding

class ${activityClass}Activity : BaseActivity<${bindingClass}Binding, ${activityClass}ViewModel>() {
    override fun getVariableId(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.${layoutName}
    }

    override fun performInject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    /**
     * 页面一些初始化
     */
    override fun initView() {

    }

    /**
     * 观察数据变化，来修改页面
     */
    override fun initObserver() {
   
    }

    /**
     * 页面跳转
     */
    override fun performRouter() {
        
    }
}
    
"""
}
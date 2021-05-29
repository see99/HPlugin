package com.github.see99.androidpluginh.otherx.mvvm.fragment.src

import com.android.tools.idea.wizard.template.getMaterialComponentName
import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.renderIf
import com.github.see99.androidpluginh.otherx.mvvm.activity.src.layoutStr2JavaBinding

fun mvvmFragmentKt(
        applicationPackage: String?,
        className: String,
        fragmentName: String,
        packageName: String,
        useAndroidX: Boolean
): String {
    val applicationPackageBlock = renderIf(applicationPackage != null) { "import ${applicationPackage}.R" }
    var bindingClass:String? = null
    var arr = fragmentName.split("_")
    bindingClass = if (arr.isEmpty()){
        null
    }else{
        layoutStr2JavaBinding(arr)
    }

    var applicationPackagex:String? = null
    if (applicationPackage==null){
        applicationPackagex = packageName
    }else{
        applicationPackagex = applicationPackage
    }

    return """
package ${escapeKotlinIdentifier(packageName)}

import android.os.Bundle
import ${applicationPackagex}.BR
import ${applicationPackagex}.R
import ${applicationPackagex}.base.BaseFragment
import ${applicationPackagex}.dagger.component.FragmentComponent
import ${applicationPackagex}.databinding.${bindingClass}Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ${className}Fragment : BaseFragment<${bindingClass}Binding, ${className}ViewModel>() {
  
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

     override fun initView() {

    }

    override fun initObserver() {

    }

    override fun getVariableId(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.${fragmentName}
    }

    override fun performInject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)

    }


    companion object {
   
        @JvmStatic fun newInstance(param1: String, param2: String) =
                ${className}Fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
"""
}
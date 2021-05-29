package com.github.see99.androidpluginh.otherx

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.see99.androidpluginh.otherx.mvvm.activity.mvvmActivityTemplate
import com.github.see99.androidpluginh.otherx.mvvm.fragment.mvvmFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template>  = listOf(
            // activity的模板
            mvvmActivityTemplate,
            mvvmFragmentTemplate
    )
}
package com.github.see99.androidpluginh.otherx.mvvm.fragment


import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint.CLASS
import com.android.tools.idea.wizard.template.Constraint.LAYOUT
import com.android.tools.idea.wizard.template.Constraint.NONEMPTY
import com.android.tools.idea.wizard.template.Constraint.UNIQUE
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.LanguageWidget
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.fragmentToLayout
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
import com.github.see99.androidpluginh.otherx.mvvm.activity.mvvmActivityRecipe
import java.io.File

val mvvmFragmentTemplate
    get() = template {
        name = "Fragment (mvvm)"
        revision = 1
        description = "Creates a blank fragment that is compatible back to API level $MIN_API"
        minApi = MIN_API
        minBuildApi = MIN_API
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry)

        val className = stringParameter {
            name = "Fragment Name"
            default = "Blank"
            help = "The name of the fragment class to create"
            constraints = listOf(CLASS, NONEMPTY, UNIQUE)
        }

        val layoutName = stringParameter {
            name = "Fragment Layout Name"
            default = "fragment_blank"
            help = "The name of the layout to create"
            constraints = listOf(LAYOUT, NONEMPTY, UNIQUE)
            suggest = { fragmentToLayout(className.value) }
//            suggest = { "fragmentToLayout(className.value)" }
        }

        widgets(
                TextFieldWidget(className),
                TextFieldWidget(layoutName),
//                LanguageWidget()
        )

        thumb { File("template_blank_fragment.png") }

        recipe = { data: TemplateData ->
            mvvmFragmentRecipe(data as ModuleTemplateData, className.value, layoutName.value)
        }

    }

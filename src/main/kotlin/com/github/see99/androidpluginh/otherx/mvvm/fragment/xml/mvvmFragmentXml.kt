package com.github.see99.androidpluginh.otherx.mvvm.fragment.xml

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmFragmentXml(
        className: String,
        packageName: String
) = """
    <?xml version="1.0" encoding="utf-8"?>
<layout>
    <data>
        <variable
            name="viewModel"
            type="${escapeKotlinIdentifier(packageName)}.${className}ViewModel" />
    </data>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
   >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
</LinearLayout>

</layout>
"""

package com.github.see99.androidpluginh.otherx.mvvm.activity.xml

fun mvvmActivityXml(
        packageName: String,
        activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    >
    <data>
        <variable
            name="viewModel"
            type="${packageName}.${activityClass}ViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:fitsSystemWindows="true"
        tools:context="${packageName}.${activityClass}Activity">
          <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingTop="15dp"
            android:paddingBottom="15dp"
            android:overScrollMode="never"
            >

            <ImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:paddingRight="20dp"
                android:paddingTop="5dp"
                android:paddingBottom="5dp"
                android:src="@mipmap/fanhui"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                android:layout_marginLeft="12dp"
                app:finish="@{true}"
                />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="注x册"
                android:textColor="#ff1f1f1f"
                android:textSize="22sp"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.5"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />

        </androidx.constraintlayout.widget.ConstraintLayout>

    </LinearLayout>
</layout>
"""
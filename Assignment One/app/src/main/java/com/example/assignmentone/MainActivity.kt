package com.example.assignmentone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Create instance of fragment1
        val fragment1 = Fragment1()
        val sentData = Bundle()

        //
        sentData.putString("SomeKey", "SomeValue")
        fragment1.arguments = sentData

        //Use parentFragmentManager if inside a fragment
        val fTrans = supportFragmentManager.beginTransaction()

        // Replace the fragment container
        fTrans.replace(R.id.fragment_container, fragment1, "some_tag")
        fTrans.commit()
    }
}
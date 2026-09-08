package com.example.assignmentone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Android activity that holds 2 fragments. One contains buttons and the other is triggered on a
 * press of a button and displays the text on the selected button.
 *
 * @author Keaton Voordeckers
 * @date September 8th, 2026
 */
class MainActivity : AppCompatActivity() {
    /**
     * ...
     * @param savedInstanceState
     */
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
        val fTrans = supportFragmentManager.beginTransaction()

        // Replace the fragment container
        fTrans.replace(R.id.fragment_container, fragment1, "some_tag")
        fTrans.commit()
    }
}
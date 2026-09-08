package com.example.assignmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Hold five buttons: 1-5, and an additional button to exit the program. On press of a button this
 * fragment navigates to [Fragment2].
 *
 * @author Keaton Voordeckers
 * @date September 8th, 2026
 */
class Fragment1 : Fragment() {

    /**
     * Inflates and returns the layout used by [Fragment1].
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    /**
     * Override to create on click listeners for each button within [Fragment1].
     *
     * @param view Root view of Fragment1's layout.
     * @param savedInstanceState Previously saved fragment saved, null if none exists.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define behavior of all buttons in fragment1
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            // Call method for send data:
            val buttonText = view.findViewById<Button>(R.id.button1).text.toString()
            sendDataToFragment2(buttonText)
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            // Call method for send data:
            val buttonText = view.findViewById<Button>(R.id.button2).text.toString()
            sendDataToFragment2(buttonText)
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            // Call method for send data:
            val buttonText = view.findViewById<Button>(R.id.button3).text.toString()
            sendDataToFragment2(buttonText)
        }

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            // Call method for send data:
            val buttonText = view.findViewById<Button>(R.id.button4).text.toString()
            sendDataToFragment2(buttonText)
        }

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            // Call method for send data:
            val buttonText = view.findViewById<Button>(R.id.button5).text.toString()
            sendDataToFragment2(buttonText)
        }

        view.findViewById<Button>(R.id.exit_button).setOnClickListener {
            // Exit app
            requireActivity().finish()
        }
    }

    /**
     * Takes in the text of the pressed button and then sends it in a bundle to be display in
     * fragment 2. Displays fragment 2 on a button press.
     *
     * @param buttonText String representing the text of the pressed button.
     */
    fun sendDataToFragment2(buttonText: String){
        // Create instance of fragment2
        val fragment2 = Fragment2()
        val sentData = Bundle()
        val fTrans = parentFragmentManager.beginTransaction()

        sentData.putString("selectedButtonText", buttonText)
        fragment2.arguments = sentData

        // Replace the fragment container
        fTrans.replace(R.id.fragment_container, fragment2, "some_tag")
        fTrans.commit()
    }
}
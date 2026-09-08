package com.example.assignmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val ARG_SELECTED_BUTTON_TEXT = "selectedButtonText"

/**
 * A simple [Fragment] subclass.
 * Holds a button to return to [Fragment1] and some text representing the button that was
 * pressed on the previous screen.
 *
 * @author Keaton Voordeckers
 * @date September 8th, 2026
 */
class Fragment2 : Fragment() {
    private var selectedButtonText: String? = null

    /**
     * Retrieves the selected button text passed from Fragment1 and stores it for display after
     * Fragment2's view is created.
     *
     * @param savedInstanceState Previously saved fragment state, null if none exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedButtonText = it.getString(ARG_SELECTED_BUTTON_TEXT)
        }
    }

    /**
     * Inflates and returns the layout used by [Fragment2].
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    /**
     * Override to create on click listeners for buttons and define behavior for
     * textview in [Fragment2].
     *
     * @param view Root view of Fragment2's layout.
     * @param savedInstanceState Previously saved fragment state, null if none exists.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Define behavior of button in fragment2
        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            val fragment1 = Fragment1()
            val fTrans = parentFragmentManager.beginTransaction()

            // Replace the fragment container
            fTrans.replace(R.id.fragment_container, fragment1, "some_tag")
            fTrans.commit()
        }

        // Define behavior for textview in fragment2
        view.findViewById<TextView>(R.id.pressed_text).setText(selectedButtonText)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param selectedButtonText Pressed button text passed in from Fragment1.
         * @return A new instance of fragment Fragment2.
         */
        @JvmStatic
        fun newInstance(selectedButtonText: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_SELECTED_BUTTON_TEXT, selectedButtonText)
                }
            }
    }
}
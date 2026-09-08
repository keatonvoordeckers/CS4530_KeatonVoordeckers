package com.example.assignmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
private const val ARG_SELECTED_BUTTON_TEXT = "selectedButtonText"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    private var selectedButtonText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedButtonText = it.getString(ARG_SELECTED_BUTTON_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    /**
     * Override to create on click listeners for button within fragment2
     * @param view
     * @param savedInstanceState
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
         * @param selectedButtonText Parameter 1.
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
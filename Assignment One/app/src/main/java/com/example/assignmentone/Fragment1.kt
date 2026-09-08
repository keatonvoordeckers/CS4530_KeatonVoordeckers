package com.example.assignmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    // Override to create on click listeners for each button within fragment1
    /**
     *
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
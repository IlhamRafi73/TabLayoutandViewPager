package com.example.loginfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginfragment.databinding.FragmentLoginBinding
import com.example.loginfragment.databinding.FragmentRegisterBinding
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var binding: FragmentLoginBinding
/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
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



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Login.
         */

        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        val user = arrayOf("FeryElas", "CarlJohnson", "Yanto", "YiLongMa")
        val pass = mapOf(
            user[0] to "1234",
            user[1] to "2341",
            user[2] to "3412",
            user[3] to "4123")

        fun isLoginValid(username: String, password: String): Boolean {
            val storedPassword = pass[username]
            return storedPassword != null && storedPassword == password
        }

        with(binding){
            loginBtn.setOnClickListener {
                val username = enterUname.text.toString()
                val password = enterPass.text.toString()

                if (isLoginValid(username, password)) {
                    val intentLoginFragment =
                        Intent(requireContext(), Home::class.java)
                    intentLoginFragment.putExtra(EXTRA_NAME, username)
                    intentLoginFragment.putExtra(EXTRA_PASS, password)
                    startActivity(intentLoginFragment)
                } else {
                    Toast.makeText(requireContext(), "Username atau Password tidak sesuai", Toast.LENGTH_SHORT).show()

                }
            }
        }
        return view
    }
}
package ru.otus.basicarchitecture.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import ru.otus.basicarchitecture.R

class AuthorizationFragment : Fragment() {

    companion object {
        fun newInstance() = AuthorizationFragment()
    }

    private val viewModel: AuthorizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        view.findViewById<Button>(R.id.toAddress).setOnClickListener {
            navController.navigate(R.id.action_to_addressFragment)
        }

        val nameTextInput = view.findViewById<TextInputLayout>(R.id.nameTextInput)
        val surnameTextInput = view.findViewById<TextInputLayout>(R.id.surnameTextInput)
        val birthDataTextInput = view.findViewById<TextInputLayout>(R.id.birthData)

        view.findViewById<Button>(R.id.toAddress).setOnClickListener {

            viewModel.setName(nameTextInput.editText?.text.toString())
            viewModel.setSurname(surnameTextInput.editText?.text.toString())
            viewModel.setBirthDate(birthDataTextInput.editText?.text.toString())
        }
    }
}
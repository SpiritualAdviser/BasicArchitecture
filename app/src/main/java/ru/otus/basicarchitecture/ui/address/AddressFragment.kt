package ru.otus.basicarchitecture.ui.address

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import ru.otus.basicarchitecture.R
@AndroidEntryPoint
class AddressFragment : Fragment() {

    companion object {
        fun newInstance() = AddressFragment()
    }

    private val viewModel: AddressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryTextInput = view.findViewById<TextInputLayout>(R.id.countryTextInput)
        val cityTextInput = view.findViewById<TextInputLayout>(R.id.cityTextInput)
        val addressTextInput = view.findViewById<TextInputLayout>(R.id.addressTextInput)

        val navController = findNavController()
        view.findViewById<Button>(R.id.toInterests).setOnClickListener {

            viewModel.setCountry(countryTextInput.editText?.text.toString())
            viewModel.setCity(cityTextInput.editText?.text.toString())
            viewModel.setAddress(addressTextInput.editText?.text.toString())

            navController.navigate(R.id.action_to_interestsFragment)
        }
    }
}
package ru.otus.basicarchitecture.ui.profile

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.otus.basicarchitecture.R
@AndroidEntryPoint
class PersonProfileFragment : Fragment() {

    companion object {
        fun newInstance() = PersonProfileFragment()
    }

    private val viewModel: PersonProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_person_profile, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView = view.findViewById<TextView>(R.id.namePerson)
        val surnameTextView = view.findViewById<TextView>(R.id.surnamePerson)
        val birthDateTextView = view.findViewById<TextView>(R.id.birthDataPerson)
        val countryTextView = view.findViewById<TextView>(R.id.addressPerson)
        val interestsTextView = view.findViewById<TextView>(R.id.interests)

        nameTextView.text = viewModel.personName
        surnameTextView.text = viewModel.personSurname
        birthDateTextView.text = viewModel.personBirthDate
        countryTextView.text =
            "${viewModel.personCountry}, ${viewModel.personCity}, ${viewModel.personAddress}"
    }
}
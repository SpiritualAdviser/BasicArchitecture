package ru.otus.basicarchitecture.ui.interests

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import ru.otus.basicarchitecture.R

class InterestsFragment : Fragment() {

    companion object {
        fun newInstance() = InterestsFragment()
    }

    private val viewModel: InterestsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_interests, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        view.findViewById<Button>(R.id.toPersonProfile).setOnClickListener {
            navController.navigate(R.id.action_to_personProfileFragment)
        }
        setHobbySpinners()
    }

    private fun setHobbySpinners() {
        view?.let { viewNotNull ->

            val spinnerSports = viewNotNull.findViewById<Spinner>(R.id.hobby_sports)
            val spinnerCreative = viewNotNull.findViewById<Spinner>(R.id.hobby_сreative)
            val spinnerIntelligence = viewNotNull.findViewById<Spinner>(R.id.hobby_intelligence)

            context?.let {
                spinnerSports.adapter = ArrayAdapter.createFromResource(
                    it,
                    R.array.hobby_sports,
                    android.R.layout.simple_spinner_dropdown_item
                )

                spinnerCreative.adapter = ArrayAdapter.createFromResource(
                    it,
                    R.array.hobby_сreative,
                    android.R.layout.simple_spinner_dropdown_item
                )

                spinnerIntelligence.adapter = ArrayAdapter.createFromResource(
                    it,
                    R.array.hobby_intelligence,
                    android.R.layout.simple_spinner_dropdown_item
                )
            }
        }
    }
}
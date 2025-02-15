package ru.otus.basicarchitecture.ui.interests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.otus.basicarchitecture.R

@AndroidEntryPoint
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

            spinnerSports?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.setSports(spinnerSports.selectedItem.toString())
                }
            }

            spinnerCreative?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.setSports(spinnerCreative.selectedItem.toString())
                }
            }

            spinnerIntelligence?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.setSports(spinnerIntelligence.selectedItem.toString())
                }
            }
        }
    }
}
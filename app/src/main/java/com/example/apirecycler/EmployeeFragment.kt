package com.example.apirecycler

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apirecycler.databinding.FragmentEmployeeBinding

class EmployeeFragment : Fragment() {

    private val viewModel: EmployeeViewModel by lazy {
        ViewModelProvider(this).get(EmployeeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmployeeBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }
}
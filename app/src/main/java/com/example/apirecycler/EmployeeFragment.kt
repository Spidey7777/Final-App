package com.example.apirecycler

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apirecycler.databinding.FragmentEmployeeBinding
import com.example.apirecycler.network.EmployeeDetails

class EmployeeFragment : Fragment() {

    private val viewModel: EmployeeViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(this, EmployeeViewModel.Factory(activity.application)).get(EmployeeViewModel::class.java)
    }

//    private var viewModelAdapter: EmployeeListAdapter? = null

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.empList.observe(viewLifecycleOwner, Observer<List<EmployeeDetails>> { empl ->
//            empl?.apply {
//                viewModelAdapter = empl
//            }
//        })
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmployeeBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.employeeList.adapter = EmployeeListAdapter()

        return binding.root
    }
}
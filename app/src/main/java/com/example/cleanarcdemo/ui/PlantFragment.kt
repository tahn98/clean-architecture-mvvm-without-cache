package com.example.cleanarcdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarcdemo.data.Status
import com.example.cleanarcdemo.databinding.FragmentPlantBinding
import com.example.cleanarcdemo.di.Injection
import com.example.cleanarcdemo.ui.adapter.PlantAdapter
import com.example.cleanarcdemo.viewmodel.PlantViewModel

class PlantFragment : Fragment(){

    private lateinit var binding : FragmentPlantBinding
    private lateinit var plantAdapter : PlantAdapter
    private lateinit var plantViewModel : PlantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        plantViewModel = viewModel()
        plantViewModel.getAllPlant()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()
        bindViewModel()
    }

    private fun initAdapter(){
        plantAdapter = PlantAdapter()
        binding.rcvPlant.adapter = plantAdapter
    }

    private fun bindViewModel(){
        plantViewModel.listPlant.observe(viewLifecycleOwner, Observer {
            plantAdapter.setPlantList(it)
        })

        plantViewModel.networkState.observe(viewLifecycleOwner, Observer {
            binding.spinner.visibility = if(it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })
    }

    private fun viewModel() : PlantViewModel{
        val viewModelFactory = Injection.providePlantViewModelFactory()
        return ViewModelProvider(this, viewModelFactory)[PlantViewModel::class.java]
    }
}
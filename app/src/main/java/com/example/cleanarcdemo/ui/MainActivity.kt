package com.example.cleanarcdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.cleanarcdemo.PlantApplication
import com.example.cleanarcdemo.R
import com.example.cleanarcdemo.data.Status
import com.example.cleanarcdemo.databinding.ActivityMainBinding
import com.example.cleanarcdemo.ui.adapter.PlantAdapter
import com.example.cleanarcdemo.viewmodel.PlantViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var plantAdapter : PlantAdapter
    @Inject lateinit var plantViewModel : PlantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as PlantApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        plantViewModel.getAllPlant()
        initAdapter()
        bindViewModel()
    }

    private fun initAdapter(){
        plantAdapter = PlantAdapter()
        binding.rcvPlant.adapter = plantAdapter
    }

    private fun bindViewModel(){
        plantViewModel.listPlant.observe(this, Observer {
            plantAdapter.setPlantList(it)
        })

        plantViewModel.networkState.observe(this, Observer {
            binding.spinner.visibility = if(it.status == Status.RUNNING) View.VISIBLE else View.GONE
        })
    }
}

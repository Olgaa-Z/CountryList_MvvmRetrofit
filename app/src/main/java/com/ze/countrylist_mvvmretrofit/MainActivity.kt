package com.ze.countrylist_mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ze.countrylist_mvvmretrofit.adapter.CountryListAdapter
import com.ze.countrylist_mvvmretrofit.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter : CountryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViwModel()
    }

    private fun initRecyclerView(){
        rvListCountry.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdapter((this))
        rvListCountry.adapter= recyclerAdapter
    }

    private fun initViwModel(){
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this,{
            if(it != null){
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error in getting List ", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }
}
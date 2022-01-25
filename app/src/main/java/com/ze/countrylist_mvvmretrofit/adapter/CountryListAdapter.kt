package com.ze.countrylist_mvvmretrofit.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ze.countrylist_mvvmretrofit.R
import com.ze.countrylist_mvvmretrofit.data.CountryModel
import kotlinx.android.synthetic.main.item_list_country.view.*

class CountryListAdapter(val activity : Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {


    private var listCountry : List<CountryModel>? = null

    fun setCountryList(listCountry : List<CountryModel>?){
        this.listCountry = listCountry
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListAdapter.MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_country, parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryListAdapter.MyViewHolder, position: Int) {
        holder.bind(listCountry?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
       if(listCountry == null) return 0
        else return listCountry?.size!!
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){

        val flagImage = view.flagcountry
        val tvNameCountry = view.countryname
        val tvCapitalCountry = view.countrycapital
        val tvRegionCountry = view.countryregion

        fun bind(data : CountryModel, activity : Activity){
            tvNameCountry.text = data.name
            tvCapitalCountry.text = "Capital : " + data.capital
            tvRegionCountry.text = "Region :" + data.region

            Glide.with(activity).load(data.flag).into(flagImage)





        }

    }

}
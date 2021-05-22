package com.feylabs.lasagna.view.bottom_sheet

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arthurivanets.bottomsheets.BaseBottomSheet
import com.arthurivanets.bottomsheets.config.BaseConfig
import com.arthurivanets.bottomsheets.config.Config
import com.feylabs.lasagna.R
import com.feylabs.lasagna.databinding.OptionHospitalBinding
import com.feylabs.lasagna.databinding.OptionReportUserBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class OptionHospitalBottomSheet(
    val hostActivity: AppCompatActivity,
    config: BaseConfig = Config.Builder(hostActivity).build()
) : BaseBottomSheet(hostActivity, config), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var myVbind: OptionHospitalBinding

    var myLatitude = 0.0
    var myLongitude = 0.0
    var address = ""


    override fun onCreateSheetContentView(context: Context): View {
        val view = LayoutInflater.from(context).inflate(R.layout.option_hospital, this, false)
        myVbind = OptionHospitalBinding.bind(view)
        Config.Builder(myVbind.root.context).dismissOnTouchOutside(false).build()

        val myActivity = hostActivity


        return myVbind.root
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        refreshMap()
    }

    fun refreshMap(){
        val location = LatLng(31.3547, 34.3088)
        mMap.addMarker(MarkerOptions().position(location).title(address))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f))
    }




}
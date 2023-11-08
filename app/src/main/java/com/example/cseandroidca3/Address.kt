package com.example.cseandroidca3

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Address : AppCompatActivity() {

    lateinit var etLatitude: EditText
    lateinit var etLongitude: EditText
    lateinit var btFindLocation: Button
    lateinit var tvAddress: TextView
    lateinit var logout:ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        etLatitude=findViewById(R.id.etLatitude)
        etLongitude=findViewById(R.id.etLongitude)
        btFindLocation=findViewById(R.id.btFindLocation)
        tvAddress=findViewById(R.id.tvAddess)
        logout = findViewById(R.id.lgtBtn)

        btFindLocation.setOnClickListener {
            if (etLatitude.text.toString().isEmpty() || etLongitude.text.toString().isEmpty()){
                Toast.makeText(this,"Enter the required Details", Toast.LENGTH_SHORT).show()
            }
            else{
                getAddressfromLocation(etLatitude.text.toString(),etLongitude.text.toString())
            }
        }
        logout.setOnClickListener {
            val intent = Intent(this, com.example.cseandroidca3.LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun getAddressfromLocation(latitude:String,longitude:String){
        val geocoder= Geocoder(this)
        val lat = latitude.toDouble()
        val lon=longitude.toDouble()
        val list: List<Address> ?= geocoder.getFromLocation(lat,lon,1)
        if (list.isNullOrEmpty()){
            return
        }
        tvAddress.text="Location: ${list[0].getAddressLine(0)}"
        //15.85559249999998
        //78.26458869999999
    }
}
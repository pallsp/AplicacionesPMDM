package com.pablo.aplicacionespmdm.IMCApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import com.pablo.aplicacionespmdm.R
import java.lang.Math.pow
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class imcCalc : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var tvWeight: TextView
    private lateinit var btnSubsWeight: CardView
    private lateinit var btnAddWeight: CardView

    private lateinit var tvAge: TextView
    private lateinit var btnSubsAge: CardView
    private lateinit var btnAddAge: CardView

    private lateinit var btnCalculate: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcapp)

        initComponents()
        initListeners()
        setWeight()
        setAge()
    }

    private fun initListeners() {
        viewMale.setOnClickListener {setComponentColorMale() }
        viewFemale.setOnClickListener {setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            //val result = df.format(value)
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"

        }
        btnAddWeight.setOnClickListener {
            currentWeight+=1
            setWeight()
        }
        btnSubsWeight.setOnClickListener {
            currentWeight-=1
            setWeight()
        }
        btnAddAge.setOnClickListener {
            currentAge+=1
            setAge()
        }
        btnSubsAge.setOnClickListener {
            currentAge-=1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        var intent = Intent(this, imcSegundo::class.java)
        intent.putExtra("resultado",result)
        startActivity(intent)
    }

    private fun calculateIMC():Double{
        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'
        val df = DecimalFormat("#.##")
        df.decimalFormatSymbols = dfs
        val imc = currentWeight / pow(currentHeight.toDouble() / 100,2.0)

        return df.format(imc).toDouble()
    }
    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
    }
    private fun setComponentColorFemale() {
        if(!isFemaleSelected){
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isFemaleSelected = true
            isMaleSelected = false
        }
    }

    private fun setComponentColorMale() {
        if(!isMaleSelected){
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.valorPeso)
        btnSubsWeight = findViewById(R.id.subsPeso)
        btnAddWeight = findViewById(R.id.addPeso)
        tvAge = findViewById(R.id.valorEdad)
        btnSubsAge = findViewById(R.id.subsEdad)
        btnAddAge = findViewById(R.id.addEdad)
        btnCalculate = findViewById(R.id.btnCalcular)
    }
}
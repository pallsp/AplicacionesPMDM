package com.pablo.aplicacionespmdm.ColorsApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pablo.aplicacionespmdm.R

class ColorsActivity : AppCompatActivity() {
    private val verticalBars = mutableListOf(
        VerticalBar(872349696, "V1 (20%)"),
        VerticalBar(1507513872, "V2 (35%)"),
        VerticalBar(2162972681.toInt(), "V3 (50%)"),
        VerticalBar(2797475812.toInt(), "V4 (65%)"),
        VerticalBar(3424315110.toInt(), "V5 (80%)")
    )
    private lateinit var colorsAdapter: ColorsAdapter
    private lateinit var rvVerticalBars: RecyclerView

    private lateinit var cvH1: CardView
    private lateinit var cvH2: CardView
    private lateinit var cvH3: CardView
    private lateinit var btnChangeColor: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        colorsAdapter = ColorsAdapter(verticalBars)
        rvVerticalBars.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvVerticalBars.adapter = colorsAdapter
    }

    private fun initListeners() {
        btnChangeColor.setOnClickListener {showDialog()}
    }

    private fun initComponents() {
        rvVerticalBars = findViewById(R.id.rvColors)
        btnChangeColor = findViewById(R.id.btnChangeColor)
        cvH1 = findViewById(R.id.cvH1)
        cvH2 = findViewById(R.id.cvH2)
        cvH3 = findViewById(R.id.cvH3)
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_colors)

        val btnApplyColor: Button = dialog.findViewById(R.id.btnApplyColor)
        val rgBar: RadioGroup = dialog.findViewById(R.id.rgBars)
        val rgColor: RadioGroup = dialog.findViewById(R.id.rgColors)

        btnApplyColor.setOnClickListener {
            val selectedBar = rgBar.checkedRadioButtonId
            val selectedRadioButtonBar: RadioButton = rgBar.findViewById(selectedBar)
            val selectedColor = rgColor.checkedRadioButtonId
            val selectedRadioButtonColor: RadioButton = rgColor.findViewById(selectedColor)

            val currentColor = when(selectedRadioButtonColor.text){
                getString(R.string.color_white)->"white"
                getString(R.string.color_red)->"red"
                getString(R.string.color_yellow)->"yellow"
                getString(R.string.color_orange)->"orange"
                getString(R.string.color_green)->"green"
                getString(R.string.color_cyan)->"cyan"
                getString(R.string.color_blue)->"blue"
                getString(R.string.color_violet)->"violet"
                else->"black"
            }

            updateColors(selectedRadioButtonBar.text.subSequence(0,2),currentColor)
            dialog.hide()
        }
        dialog.show()
    }

    private fun updateColors(bar: CharSequence, color: String) {
        if(bar=="H1"){
            if(color=="white")
                cvH1.setCardBackgroundColor(getColor(R.color.white20))
            if(color=="red")
                cvH1.setCardBackgroundColor(getColor(R.color.red20))
            if(color=="orange")
                cvH1.setCardBackgroundColor(getColor(R.color.orange20))
            if(color=="yellow")
                cvH1.setCardBackgroundColor(getColor(R.color.yellow20))
            if(color=="green")
                cvH1.setCardBackgroundColor(getColor(R.color.green20))
            if(color=="cyan")
                cvH1.setCardBackgroundColor(getColor(R.color.cyan20))
            if(color=="blue")
                cvH1.setCardBackgroundColor(getColor(R.color.blue20))
            if(color=="violet")
                cvH1.setCardBackgroundColor(getColor(R.color.violet20))
            if(color=="black")
                cvH1.setCardBackgroundColor(getColor(R.color.black20))
        }
        if(bar=="H2"){
            if(color=="white")
                cvH2.setCardBackgroundColor(getColor(R.color.white50))
            if(color=="red")
                cvH2.setCardBackgroundColor(getColor(R.color.red50))
            if(color=="orange")
                cvH2.setCardBackgroundColor(getColor(R.color.orange50))
            if(color=="yellow")
                cvH2.setCardBackgroundColor(getColor(R.color.yellow50))
            if(color=="green")
                cvH2.setCardBackgroundColor(getColor(R.color.green50))
            if(color=="cyan")
                cvH2.setCardBackgroundColor(getColor(R.color.cyan50))
            if(color=="blue")
                cvH2.setCardBackgroundColor(getColor(R.color.blue50))
            if(color=="violet")
                cvH2.setCardBackgroundColor(getColor(R.color.violet50))
            if(color=="black")
                cvH2.setCardBackgroundColor(getColor(R.color.black50))
        }
        if(bar=="H3"){
            if(color=="white")
                cvH3.setCardBackgroundColor(getColor(R.color.white80))
            if(color=="red")
                cvH3.setCardBackgroundColor(getColor(R.color.red80))
            if(color=="orange")
                cvH3.setCardBackgroundColor(getColor(R.color.orange80))
            if(color=="yellow")
                cvH3.setCardBackgroundColor(getColor(R.color.yellow80))
            if(color=="green")
                cvH3.setCardBackgroundColor(getColor(R.color.green80))
            if(color=="cyan")
                cvH3.setCardBackgroundColor(getColor(R.color.cyan80))
            if(color=="blue")
                cvH3.setCardBackgroundColor(getColor(R.color.blue80))
            if(color=="violet")
                cvH3.setCardBackgroundColor(getColor(R.color.violet80))
            if(color=="black")
                cvH3.setCardBackgroundColor(getColor(R.color.black80))
        }
        else{
            var colorVertical = getColor(R.color.white20)
            if(bar=="V1"){
                when(color){
                    "red"->colorVertical = getColor(R.color.red20)
                    "orange"->colorVertical = getColor(R.color.orange20)
                    "yellow"->colorVertical = getColor(R.color.yellow20)
                    "green"->colorVertical = getColor(R.color.green20)
                    "cyan"->colorVertical = getColor(R.color.cyan20)
                    "blue"->colorVertical = getColor(R.color.blue20)
                    "violet"->colorVertical = getColor(R.color.violet20)
                    "black"->colorVertical = getColor(R.color.black20)
                }
                verticalBars[0] = VerticalBar(colorVertical, "V1 (20%)")
            }
            if(bar=="V2"){
                when(color){
                    "white"->colorVertical = getColor(R.color.white35)
                    "red"->colorVertical = getColor(R.color.red35)
                    "orange"->colorVertical = getColor(R.color.orange35)
                    "yellow"->colorVertical = getColor(R.color.yellow35)
                    "green"->colorVertical = getColor(R.color.green35)
                    "cyan"->colorVertical = getColor(R.color.cyan35)
                    "blue"->colorVertical = getColor(R.color.blue35)
                    "violet"->colorVertical = getColor(R.color.violet35)
                    "black"->colorVertical = getColor(R.color.black35)
                }
                verticalBars[1] = VerticalBar(colorVertical, "V2 (35%)")
            }
            if(bar=="V3"){
                when(color){
                    "white"->colorVertical = getColor(R.color.white50)
                    "red"->colorVertical = getColor(R.color.red50)
                    "orange"->colorVertical = getColor(R.color.orange50)
                    "yellow"->colorVertical = getColor(R.color.yellow50)
                    "green"->colorVertical = getColor(R.color.green50)
                    "cyan"->colorVertical = getColor(R.color.cyan50)
                    "blue"->colorVertical = getColor(R.color.blue50)
                    "violet"->colorVertical = getColor(R.color.violet50)
                    "black"->colorVertical = getColor(R.color.black50)
                }
                verticalBars[2] = VerticalBar(colorVertical, "V3 (50%)")
            }
            if(bar=="V4"){
                when(color){
                    "white"->colorVertical = getColor(R.color.white65)
                    "red"->colorVertical = getColor(R.color.red65)
                    "orange"->colorVertical = getColor(R.color.orange65)
                    "yellow"->colorVertical = getColor(R.color.yellow65)
                    "green"->colorVertical = getColor(R.color.green65)
                    "cyan"->colorVertical = getColor(R.color.cyan65)
                    "blue"->colorVertical = getColor(R.color.blue65)
                    "violet"->colorVertical = getColor(R.color.violet65)
                    "black"->colorVertical = getColor(R.color.black65)
                }
                verticalBars[3] = VerticalBar(colorVertical, "V4 (65%)")
            }
            if(bar=="V5"){
                when(color){
                    "white"->colorVertical = getColor(R.color.white80)
                    "red"->colorVertical = getColor(R.color.red80)
                    "orange"->colorVertical = getColor(R.color.orange80)
                    "yellow"->colorVertical = getColor(R.color.yellow80)
                    "green"->colorVertical = getColor(R.color.green80)
                    "cyan"->colorVertical = getColor(R.color.cyan80)
                    "blue"->colorVertical = getColor(R.color.blue80)
                    "violet"->colorVertical = getColor(R.color.violet80)
                    "black"->colorVertical = getColor(R.color.black80)
                }
                verticalBars[4] = VerticalBar(colorVertical, "V5 (80%)")
            }
            colorsAdapter.notifyDataSetChanged()
        }
    }
}
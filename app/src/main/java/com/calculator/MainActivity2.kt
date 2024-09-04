package com.calculator

import android.icu.text.DecimalFormat
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    var str: String = ""
    var ACistrue = true
    var formattedValue: Any? = null
    var firstvalue: String? = null
    var result: Any? = null
    var isadd = false
    var isper = false
    var issub = false
    var ismulti = false
    var isdivide = false
    var ispercentage = false
    var flag = 0
    var secondvalue: String? = null
    var textv: TextView? = null

    var bt09: Button? = null
    var bt08: Button? = null
    var bt07: Button? = null
    var bt06: Button? = null
    var bt05: Button? = null
    var bt04: Button? = null
    var bt03: Button? = null
    var bt02: Button? = null
    var bt01: Button? = null
    var bt00: Button? = null
    var point: Button? = null
    var btnAC: Button? = null
    var btnPosNeg: Button? = null
    var btndivide: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textv = findViewById<TextView>(R.id.edtext1)
        bt09 = findViewById<Button>(R.id.bt09)
        bt08 = findViewById<Button>(R.id.bt08)
        bt07 = findViewById<Button>(R.id.bt07)
        bt06 = findViewById<Button>(R.id.bt06)
        bt05 = findViewById<Button>(R.id.bt05)
        bt04 = findViewById<Button>(R.id.bt04)
        bt03 = findViewById<Button>(R.id.bt03)
        bt02 = findViewById<Button>(R.id.bt02)
        bt01 = findViewById<Button>(R.id.bt01)
        bt00 = findViewById<Button>(R.id.bt00)
        point = findViewById<Button>(R.id.point)
        btnAC = findViewById<Button>(R.id.btnAC)
        btnPosNeg = findViewById<Button>(R.id.btnposnev)
        btndivide = findViewById<Button>(R.id.divide)

    }

    private fun setValueOfField(btn: Button?) {
        str = textv?.text.toString()
        Log.d("str001", "${str}")
        if (str.equals("0")) {
            textv!!.setText("").toString()
        }
        if (flag == 1) {
            textv?.text = "-"
            flag = 0

        } else
        {
            textv?.text = textv?.text?.toString().plus(btn?.text?.toString())
        }


    }
    fun doublevaluecheck(numberString: String): Number?
{
    val doubleValue = numberString.toDoubleOrNull()
        if (doubleValue != null) {
            return doubleValue
        }
        return null
    }

    fun clickSound() {
        val mediaPlayer = MediaPlayer.create(this, R.raw.clicksound)
        mediaPlayer.start()
//        Log.d("hi inside sound ", "baj raha hai")
    }

    private fun clearValueOfField() {
        textv?.text = "0"
    }

    private fun addNumber(a: String, b: String) {

        result = a.toFloat() + b.toFloat()
        formattedValue = DecimalFormat("#.######").format(result)

    }

    private fun subNumber(a: String, b: String) {

        result = a.toFloat() - b.toFloat()
        formattedValue = DecimalFormat("#.######").format(result)

    }

    private fun multipleNumber(a: String, b: String) {
        result = a.toFloat() * b.toFloat()
        formattedValue = DecimalFormat("#.######").format(result)

    }

    private fun percentageNumber(a: String) {
        result = a.toDouble() / 100

    }

    private fun divideNumber(a: String, b: String) {

        result = a.toDouble() / b.toDouble()
        formattedValue = DecimalFormat("#.#####").format(result)

    }

    fun process(V: View) {
        if (V.id == R.id.btnAC) {
            clickSound()
            clearValueOfField()
        }
        if (V.id == R.id.bt01) {
            clickSound()
            setValueOfField(bt01)
        }
        if (V.id == R.id.bt02) {
            clickSound()
            setValueOfField(bt02)
        }
        if (V.id == R.id.bt03) {
            clickSound()
            setValueOfField(bt03)
        }
        if (V.id == R.id.bt07) {
            clickSound()
            setValueOfField(bt07)
        }
        if (V.id == R.id.bt08) {
            clickSound()
            setValueOfField(bt08)
        }
        if (V.id == R.id.bt09) {
            clickSound()
            setValueOfField(bt09)
        }
        if (V.id == R.id.bt04) {
            clickSound()
            setValueOfField(bt04)
        }
        if (V.id == R.id.bt05) {
            clickSound()
            setValueOfField(bt05)
        }
        if (V.id == R.id.bt06) {
            clickSound()
            setValueOfField(bt06)
        }
        if (V.id == R.id.btnposnev) {
            clickSound()
            flag = 1
            setValueOfField(btnPosNeg)
        }
        if (V.id == R.id.btnpercentage) {
            clickSound()
            ispercentage = true
            firstvalue = textv?.text.toString()
        }
        if (V.id == R.id.divide) {
            clickSound()
            isdivide = true
            firstvalue = textv?.text.toString()
            clearValueOfField()
        }

        if (V.id == R.id.btmultiplyer) {
            clickSound()
            ismulti = true
            firstvalue = textv?.text.toString()
            clearValueOfField()
        }

        if (V.id == R.id.subtraction) {
            clickSound()
            issub = true
            firstvalue = textv?.text.toString()
            clearValueOfField()
        }


        if (V.id == R.id.Adddition) {
            clickSound()
            isadd = true
            firstvalue = textv?.text.toString()
            clearValueOfField()
        }
        if (V.id == R.id.bt00) {
            clickSound()
            setValueOfField(bt00)
        }
        if (V.id == R.id.point) {
            clickSound()
            setValueOfField(point)
        }
        if (V.id == R.id.equals) {
            clickSound()
            secondvalue = textv?.text.toString()
            if (isadd) {
                addNumber(firstvalue!!, secondvalue!!)
                textv?.setText(formattedValue.toString())
                isadd = false
            }
            if (issub) {
                subNumber(firstvalue!!, secondvalue!!)
                textv?.setText(formattedValue.toString())
                issub = false

            }
            if (ismulti) {
                multipleNumber(firstvalue!!, secondvalue!!)
                textv?.setText(formattedValue.toString())
                ismulti = false
            }
            if (isdivide) {

                val doubleValue = secondvalue!!.toDoubleOrNull()
                 if(doubleValue!!.rem(1).equals(0.0))
                {
                    result=firstvalue!!.toDouble()/secondvalue!!.toDouble()
                    formattedValue = DecimalFormat("#.#####").format(result)
                    textv?.setText(formattedValue.toString())
                }
                else {
                    divideNumber(firstvalue!!, secondvalue!!)
                    textv?.setText(formattedValue.toString())
                }
                isdivide = false
            }

            if (ispercentage) {
                percentageNumber(firstvalue!!)
                textv?.setText(result.toString())
                ispercentage = false
            }
        }

    }
}
package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_keybroad.*
import kotlin.math.pow
import kotlin.math.sqrt

class KeybroadFragment : Fragment(), View.OnClickListener {
    var result: String = ""
    var operator: String = ""
    var arr = arrayOf("0", "0")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_keybroad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonZero.setOnClickListener(this)
        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivisor.setOnClickListener(this)
        buttonAc.setOnClickListener(this)
        buttonSqrt.setOnClickListener(this)
        buttonMu.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        insert(v)
        if (operator.isNotEmpty()) {
            arr[1] = textResult.text.toString()
        }
        when (v?.id) {
            R.id.buttonAc -> {
                textResult.text = ""
                arr[0] = "0"
                arr[1] = "0"
                operator = ""
                result = ""
            }
            R.id.buttonPlus -> {
                arr[0] = textResult.text.toString()
                operator += "+"
                textResult.text = ""
            }
            R.id.buttonMinus -> {
                arr[0] = textResult.text.toString()
                operator += "-"
                textResult.text = ""
            }
            R.id.buttonDivisor -> {
                arr[0] = textResult.text.toString()
                operator += "/"
                textResult.text = ""
            }
            R.id.buttonMultiply -> {
                arr[0] = textResult.text.toString()
                operator += "*"
                textResult.text = ""
            }
            R.id.buttonSqrt -> {
                if (textResult.text == "") {
                    textResult.text = "0"
                } else {
                    textResult.text =
                        sqrt((textResult?.text.toString().toDouble())).toString().replace(".0", "")
                }
            }
            R.id.buttonMu -> {
                if (textResult?.text == "") {
                    textResult?.text = "0"
                } else {
                    textResult.text =
                        (textResult.text.toString().toDouble()).pow(2).toString().replace(".0", "")
                }
            }
            R.id.buttonEqual -> {
                if (operator != "") {
                    operator = operator[operator.length - 1].toString()
                    if (arr[1].isEmpty()) arr[1] = "0"
                    when (operator) {
                        "+" -> {
                            result = (arr[0].toDouble() + arr[1].toDouble()).toString()
                        }
                        "-" -> {
                            result = (arr[0].toDouble() - arr[1].toDouble()).toString()
                        }
                        "*" -> {
                            result = (arr[0].toDouble() * arr[1].toDouble()).toString()
                        }
                        "/" -> {
                            result = (arr[0].toDouble() / arr[1].toDouble()).toString()
                        }
                    }
                }
                result = result.replace(".0", "")
                textResult.text = result
            }
        }
    }

    private fun insert(v: View?) {
        when (v?.id) {
            R.id.buttonZero -> {
                textResult.append("0")
            }
            R.id.buttonOne -> {
                textResult.append("1")
            }
            R.id.buttonTwo -> {
                textResult.append("2")
            }
            R.id.buttonThree -> {
                textResult.append("3")
            }
            R.id.buttonFour -> {
                textResult.append("4")
            }
            R.id.buttonFive -> {
                textResult.append("5")
            }
            R.id.buttonSix -> {
                textResult.append("6")
            }
            R.id.buttonSeven -> {
                textResult.append("7")
            }
            R.id.buttonEight -> {
                textResult.append("8")
            }
            R.id.buttonNine -> {
                textResult.append("9")
            }
            R.id.buttonDot -> {
                var count = 0
                for (element in textResult.text) {
                    if (element.toString() == ".") {
                        count++
                    }
                }
                if (count == 0) {
                    textResult.append(".")
                }
            }
        }
    }
}




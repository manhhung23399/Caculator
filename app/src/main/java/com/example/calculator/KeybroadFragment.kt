package com.example.calculator



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt


class KeybroadFragment : Fragment(), View.OnClickListener {
    var txtResult: TextView? = null
    var result: String= ""
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
        txtResult = view.findViewById<TextView>(R.id.txtResult)
        val btnZero = view.findViewById<Button>(R.id.btnZero)
        val btnOne = view.findViewById<Button>(R.id.btnOne)
        val btnTwo = view.findViewById<Button>(R.id.btnTwo)
        val btnThree = view.findViewById<Button>(R.id.btnThree)
        val btnFour = view.findViewById<Button>(R.id.btnFour)
        val btnFive = view.findViewById<Button>(R.id.btnFive)
        val btnSix = view.findViewById<Button>(R.id.btnSix)
        val btnSeven = view.findViewById<Button>(R.id.btnSeven)
        val btnEight = view.findViewById<Button>(R.id.btnEight)
        val btnNine = view.findViewById<Button>(R.id.btnNine)
        val btnPlus = view.findViewById<Button>(R.id.btnPlus)
        val btnEqual = view.findViewById<Button>(R.id.btnEqual)
        val btnMultiply = view.findViewById<Button>(R.id.btnMultiply)
        val btnDivisor = view.findViewById<Button>(R.id.btnDivisor)
        val btnAc = view.findViewById<Button>(R.id.btnAc)
        val btnSqrt = view.findViewById<Button>(R.id.btnSqrt)
        val btnMu = view.findViewById<Button>(R.id.btnMu)
        val btnMinus = view.findViewById<Button>(R.id.btnMinus)
        val btnDot = view.findViewById<Button>(R.id.btnDot)
        btnZero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnEqual.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivisor.setOnClickListener(this)
        btnAc.setOnClickListener(this)
        btnSqrt.setOnClickListener(this)
        btnMu.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnDot.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        insert(v)
        if (operator.isNotEmpty()) {
            arr[1] = txtResult?.text.toString()
        }
        when (v?.id) {
            R.id.btnAc -> {
                txtResult?.text = ""
                arr[0] = "0"
                arr[1] = "0"
                operator = ""
                result = ""

            }
            R.id.btnPlus -> {
                arr[0] = txtResult?.text.toString()
                operator += "+"
                txtResult?.text = ""
            }
            R.id.btnMinus -> {
                arr[0] = txtResult?.text.toString()
                operator += "-"
                txtResult?.text = ""
            }
            R.id.btnDivisor -> {
                arr[0] = txtResult?.text.toString()
                operator += "/"
                txtResult?.text = ""
            }
            R.id.btnMultiply -> {
                arr[0] = txtResult?.text.toString()
                operator += "*"
                txtResult?.text = ""
            }
            R.id.btnSqrt -> {
                if (txtResult?.text == "") {
                    txtResult?.text = "0"
                } else {
                    txtResult?.text = sqrt((txtResult?.text.toString().toDouble())).toString().replace(".0", "")
                }
            }
            R.id.btnMu -> {
                if (txtResult?.text == "") {
                    txtResult?.text = "0"
                } else {
                    txtResult?.text = (txtResult?.text.toString().toDouble()).pow(2).toString().replace(".0", "")
                }
            }

            R.id.btnEqual -> {
                if (operator != "") {
                    operator = operator[operator.length - 1].toString()
                    if(arr[1].isEmpty()) arr[1]="0"
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
                txtResult?.text = result

            }

        }


    }

    private fun insert(v: View?) {

        when (v?.id) {
            R.id.btnZero -> {
                txtResult?.append("0")
            }
            R.id.btnOne -> {
                txtResult?.append("1")
            }
            R.id.btnTwo -> {
                txtResult?.append("2")
            }
            R.id.btnThree -> {
                txtResult?.append("3")
            }
            R.id.btnFour -> {
                txtResult?.append("4")
            }
            R.id.btnFive -> {
                txtResult?.append("5")
            }
            R.id.btnSix -> {
                txtResult?.append("6")
            }
            R.id.btnSeven -> {
                txtResult?.append("7")
            }
            R.id.btnEight -> {
                txtResult?.append("8")
            }
            R.id.btnNine -> {
                txtResult?.append("9")
            }
            R.id.btnDot -> {
                var count = 0
                for (i in 0 until txtResult?.text?.length!!) {
                    if (txtResult?.text!![i].toString() == ".") {
                        count++
                    }
                }
                if (count == 0) {
                    txtResult?.append(".")
                }
            }

        }


    }
}
//ahihi



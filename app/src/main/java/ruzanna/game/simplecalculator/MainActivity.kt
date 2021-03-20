package ruzanna.game.simplecalculator

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.number1)
        val secondNumber = findViewById<EditText>(R.id.number2)
        val sub = findViewById<Button>(R.id.sub)
        val min = findViewById<Button>(R.id.min)
        val mult = findViewById<Button>(R.id.mult)
        val div = findViewById<Button>(R.id.div)
        val res = findViewById<TextView>(R.id.result)

        sub.setOnClickListener {
            val fn = firstNumber.text.toString()
            val sn = secondNumber.text.toString()
            if(fn =="" || sn ==""){
                res.setTextColor(Color.parseColor("#D81B60"))
                res.text ="Input first and second numbers"
            }else{
                val number1 = fn.toInt()
                val number2 = sn.toInt()
                res.setTextColor(Color.parseColor("#131313"))
                res.text = calculatorCheckArgO(number1, '+', number2)
            }
        }

        min.setOnClickListener{
            val fn = firstNumber.text.toString()
            val sn = secondNumber.text.toString()
            if(fn =="" || sn ==""){
                res.setTextColor(Color.parseColor("#D81B60"))
                res.text ="Input first and second numbers"
            }else{
                val number1 = fn.toInt()
                val number2 = sn.toInt()
                res.setTextColor(Color.parseColor("#131313"))
                res.text = calculatorCheckArgO(number1, '-', number2)
            }
        }

        mult.setOnClickListener {
            val fn = firstNumber.text.toString()
            val sn = secondNumber.text.toString()
            if(fn =="" || sn ==""){
                res.setTextColor(Color.parseColor("#D81B60"))
                res.text ="Input first and second numbers"
            }else{
                val number1 = fn.toInt()
                val number2 = sn.toInt()
                res.setTextColor(Color.parseColor("#131313"))
                res.text = calculatorCheckArgO(number1, '*', number2)
            }
        }

        div.setOnClickListener {
            val fn = firstNumber.text.toString()
            val sn = secondNumber.text.toString()
            if(fn =="" || sn ==""){
                res.setTextColor(Color.parseColor("#D81B60"))
                res.text ="Input first and second numbers"
            }else{
                val number1 = fn.toInt()
                val number2 = sn.toInt()
                res.setTextColor(Color.parseColor("#131313"))
                res.text = calculatorCheckArgO(number1, '/', number2)
            }
        }
    }

    private fun calculatorCheckArgO(a: Int, ch: Char, b: Int): String {
        return if(ch == '+' || ch == '-' || ch == '*'){
            calculator(a, ch, b).toString()
        }
        else if(ch == '/'){
            if (b != 0) calculator(a, ch, b).toString() else "Zero division error"
        }
        else "Unknown operation"
    }

    private fun calculator(a: Int, c: Char, b: Int): Number  {
        return when(c){
            '+' -> a+b
            '-' -> a-b
            '*' -> a*b
            else -> if (a%b == 0) a/b else a.toFloat()/b.toFloat()
        }
    }

}
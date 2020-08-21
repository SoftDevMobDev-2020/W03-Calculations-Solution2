package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operator: ((String, String) -> Int) = ::add

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
            val result = operator(number1.text.toString(), number2.text.toString())
            answer.text = result.toString()
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioOp)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById<RadioButton>(checkedId)
            when (rb.id) {
                R.id.radioPlus -> operator = ::add
                R.id.radioMult -> operator = ::mult
            }
        }
    }

    // adds two numbers together
    private fun add(number1: String, number2: String): Int = number1.toInt() + number2.toInt()
    private fun mult(number1: String, number2: String): Int = number1.toInt() * number2.toInt()


}
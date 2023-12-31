package co.id.kalukulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import co.id.kalukulator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.result.text = ""
        binding.previewAritmatika.text = ""

        binding.btnC.setOnClickListener {
            binding.previewAritmatika.text = ""
            binding.result.text = ""
        }

        binding.btnZero.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("0")
        }

        binding.btnDot.setOnClickListener {
            binding.previewAritmatika.text = AddToInput(".")
        }

        binding.btnEqual.setOnClickListener {
            showResult()
        }

        binding.btnOne.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("1")
        }

        binding.btnTwo.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("2")
        }

        binding.btnThree.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("3")
        }

        binding.btnPlus.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("+")
        }

        binding.btnFour.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("4")
        }

        binding.btnFive.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("5")
        }

        binding.btnSix.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("6")
        }

        binding.btnMines.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("-")
        }

        binding.btnSeven.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("7")
        }

        binding.btnEight.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("8")
        }

        binding.btnNine.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("9")
        }

        binding.btnMultiplied.setOnClickListener {
            binding.previewAritmatika.text = AddToInput("x")
        }



    }

    private fun AddToInput(buttonInput: String): String {
        return "${binding.previewAritmatika.text}$buttonInput"
    }

    private fun getInputExpression(): String {
        var expression = binding.previewAritmatika.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("x"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // error
                binding.result.text = "Error"
            } else {
                binding.result.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            binding.result.text = "Error"

        }
    }


}
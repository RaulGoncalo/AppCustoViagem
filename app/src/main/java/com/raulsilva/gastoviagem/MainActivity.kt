package com.raulsilva.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.raulsilva.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate){
            calculate()
        }
    }

    private fun isValidate(): Boolean{
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate(){

        if(isValidate()){
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = distance * price / autonomy
            binding.textValueTotal.text = "R$ ${"%.2f".format(totalValue)}"

        }else{
            Toast.makeText(this, R.string.validate_fill_all_fields, Toast.LENGTH_SHORT).show()
        }


        //Toast.makeText(this, "Funcionando", Toast.LENGTH_SHORT).show()
    }

}

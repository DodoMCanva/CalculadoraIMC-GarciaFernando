package garcia.fernando.asignacion4_calculadoraimc_garcia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var imc : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtpeso : EditText = findViewById(R.id.peso)
        val txtaltura : EditText = findViewById(R.id.altura)
        val txtimc : TextView = findViewById(R.id.imc)
        val txtrango : TextView = findViewById(R.id.rango)
        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener(){
            var peso = txtpeso.text.toString().toDoubleOrNull()
            var altura = txtaltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null){
                imc=peso/(altura*altura)
                txtimc.setText(imc.toString())
            }


            when {
                imc in 1.0..18.5 -> {
                    txtrango.setText("Bajo Peso")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                imc in 18.5..24.9 -> {
                    txtrango.setText("Normal")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                imc in 25.0..29.9 -> {
                    txtrango.setText("Sobrepeso")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
                }
                imc in 30.0..34.9 -> {
                    txtrango.setText("Obesidad 1")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
                }
                imc in 35.0..39.9 -> {
                    txtrango.setText("Obesidad 2")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                }
                40 <= imc -> {
                    txtrango.setText("Obesidad 3")
                    txtrango.setBackgroundColor(ContextCompat.getColor(this, R.color.brown))
                }
            }

        }

    }
}
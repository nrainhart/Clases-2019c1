package ar.edu.utn.frba.mobile.a2019c1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Conversor de Unidades de temperatura"

        val conversor = ConversorUnidades()

        botonCelsius.isEnabled = false
        temperaturaIngresadaC.doOnTextChanged { _, _, _, _ ->
            botonCelsius.isEnabled = temperaturaIngresadaC.text.isNotBlank()
        }

        botonCelsius.setOnClickListener {
            // Llamo a celsiustof y celsius to k
            val valorC = temperaturaIngresadaC.text.toString().toDouble()
            temperaturaIngresadaF.setText(conversor.celsiusToF(valorC).toString())
            temperaturaIngresadaK.setText(conversor.celsiusToK(valorC).toString())
        }

        botonKelvin.setOnClickListener {
            // Llamo a kelvintoc y kelvintof
            val valorK = temperaturaIngresadaK.text.toString().toDouble()
            temperaturaIngresadaC.setText(conversor.kelvinToC(valorK).toString())
            temperaturaIngresadaF.setText(conversor.kelvinToF(valorK).toString())
        }

        botonFahrenheit.setOnClickListener {
            // Llamo a fahtoc y fahtok
            val valorF = temperaturaIngresadaF.text.toString().toDouble()
            temperaturaIngresadaC.setText( conversor.fahToC(valorF).toString())
            temperaturaIngresadaK.setText(conversor.fahToK(valorF).toString())
        }

    }

}

package com.example.paintcolores

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.paintcolores.PaintConfig.Companion.ListaColores
import com.example.paintcolores.PaintConfig.Companion.LapizActual
import com.example.paintcolores.PaintConfig.Companion.pathList


class MainActivity : AppCompatActivity() {

    companion object{
        var Path = Path()
        var Lapiz = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // VARIABLES PARA OBTENER LOS BOTONES...

        val Amarillo = findViewById<ImageButton>(R.id.Yellow)
        val Rojo = findViewById<ImageButton>(R.id.Red)
        val Azul = findViewById<ImageButton>(R.id.Blue)
        val Verde = findViewById<ImageButton>(R.id.Green)
        val Negro = findViewById<ImageButton>(R.id.Black)
        val Borrador = findViewById<ImageButton>(R.id.White)

        val newLapiz = Paint(Lapiz)

        // LISTENER DE LOS BOTONES PARA LOS COLORES SELECCIONADOS...

        Amarillo.setOnClickListener {

            Lapiz.color = Color.YELLOW
            ColorActual(Lapiz.color)
        }

        Rojo.setOnClickListener {

            Lapiz.color = Color.RED
            ColorActual(Lapiz.color)
        }

        Azul.setOnClickListener {

            Lapiz.color = Color.BLUE
            ColorActual(Lapiz.color)
        }

        Verde.setOnClickListener {

            Lapiz.color = Color.GREEN
            ColorActual(Lapiz.color)
        }

        Negro.setOnClickListener {

            Lapiz.color = Color.BLACK
            ColorActual(Lapiz.color)
        }

        // BORRADOR QUE LIMPIA LA PANTALLA...

        Borrador.setOnClickListener {

            pathList.clear()
            ListaColores.clear()
            Path.reset()
        }
    }

    // FUNCION QUE CONTROLA EL COLOR ACTUAL...

    private fun ColorActual(color: Int){
        LapizActual = color
        Path = Path()
    }
}
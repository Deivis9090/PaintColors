package com.example.paintcolores

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintcolores.MainActivity.Companion.Lapiz
import com.example.paintcolores.MainActivity.Companion.Path

class PaintConfig : View {

    var params : ViewGroup.LayoutParams? = null

    var currentStrokeWidth = 20f

    companion object{

        var pathList = ArrayList<Path>()
        var ListaColores = ArrayList<Int>()
        var LapizActual = Color.BLACK
    }

    // CONSTRUCTORES...

    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init(){
        Lapiz.isAntiAlias = true
        Lapiz.color = LapizActual
        Lapiz.style = Paint.Style.STROKE
        Lapiz.strokeJoin = Paint.Join.ROUND
        Lapiz.strokeWidth = 20f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                Path.lineTo(x, y)
                pathList.add(Path)
                ListaColores.add(LapizActual)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices){
            Lapiz.setColor(ListaColores[i])
            Lapiz.strokeWidth = currentStrokeWidth
            canvas.drawPath(pathList[i], Lapiz)
            invalidate()
        }
    }
}
package handtracking

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceView

class CameraOverlaySurfaceView(
        val ctx: Context
) : SurfaceView(ctx) {

    init {
        setWillNotDraw(false)
    }


    override fun onDraw(canv: Canvas) {
        val paint = Paint()

        paint.color = Color.WHITE
        paint.textSize = 50.0f
        canv.drawText("Some Text", 100.0f, 205.0f, paint)
    }
}
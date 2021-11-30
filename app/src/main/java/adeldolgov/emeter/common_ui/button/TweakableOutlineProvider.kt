package adeldolgov.emeter.common_ui.button

import android.graphics.Outline
import android.graphics.Rect
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.FloatRange

/*
*@author Adel Dolgov on 04,Апрель,2021
*/
internal class TweakableOutlineProvider(
    private val cornerRadius: Float = 0f,
    private val scaleX: Float = 1f,
    private val scaleY: Float = 1f,
    private val yShift: Float = 0f
) : ViewOutlineProvider() {

    private val rect: Rect = Rect()

    override fun getOutline(view: View?, outline: Outline?) {
        view?.background?.copyBounds(rect)
        rect.scale(scaleX, scaleY)
        rect.offset(0, yShift.toInt())
        outline?.setRoundRect(rect, cornerRadius)
    }
}

private fun Rect.scale(
    @FloatRange(from = -1.0, to = 1.0) scaleX: Float,
    @FloatRange(from = -1.0, to = 1.0) scaleY: Float
) {
    val newWidth = width() * scaleX
    val newHeight = height() * scaleY
    val deltaX = (width() - newWidth) / 2
    val deltaY = (height() - newHeight) / 2

    set((left + deltaX).toInt(), (top + deltaY).toInt(), (right - deltaX).toInt(), (bottom - deltaY).toInt())
}
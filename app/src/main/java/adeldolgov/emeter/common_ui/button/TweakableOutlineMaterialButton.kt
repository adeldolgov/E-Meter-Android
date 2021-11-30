package adeldolgov.emeter.common_ui.button

import adeldolgov.emeter.R
import adeldolgov.emeter.common.extensions.lazyUnsafe
import adeldolgov.emeter.common_ui.extensions.dp
import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.google.android.material.button.MaterialButton

/*
*@author adeld on 04,Апрель,2021
*/
class TweakableOutlineMaterialButton @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialButton(context, attributeSet, defStyleAttr) {

    private var outlineCornerRadius: Float = 0f
    private var outlineScaleX: Float = 1f
    private var outlineScaleY: Float = 1f
    private var outlineYShift: Float = 0f
    private var oldProperties: TweakableMaterialButtonProperties
    private val loadingDrawable by lazyUnsafe {
        CircularProgressDrawable(this.context).apply {
            iconSize = 24.dp
            strokeWidth = 8f
        }
    }

    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.TweakableOutlineButton, defStyleAttr, 0).let {
            outlineCornerRadius =
                it.getDimension(R.styleable.TweakableOutlineButton_outline_cornerSize, outlineCornerRadius)
            outlineScaleX = it.getFloat(R.styleable.TweakableOutlineButton_outline_scaleX, outlineScaleX)
            outlineScaleY = it.getFloat(R.styleable.TweakableOutlineButton_outline_scaleY, outlineScaleY)
            outlineYShift = it.getDimension(R.styleable.TweakableOutlineButton_outline_yShift, outlineYShift)
        }
        oldProperties = getCurrentProperties()
    }

    private fun getCurrentProperties() = TweakableMaterialButtonProperties(
        text = text.toString(),
        icon = icon,
        iconGravity = iconGravity,
        iconPadding = iconPadding
    )

    override fun onAttachedToWindow() {
        this.outlineProvider = TweakableOutlineProvider(outlineCornerRadius, outlineScaleX, outlineScaleY, outlineYShift)
        super.onAttachedToWindow()
    }

    fun showLoading(show: Boolean) {
        isEnabled = !show
        if (show) {
            oldProperties = getCurrentProperties()
            setLoaderProperties()
        } else {
            setOldProperties()
        }
    }

    private fun setOldProperties() {
        loadingDrawable.stop()
        text = oldProperties.text
        icon = oldProperties.icon
        iconPadding = oldProperties.iconPadding
        iconGravity = oldProperties.iconGravity
    }

    private fun setLoaderProperties() {
        text = ""
        iconPadding = 0
        iconGravity = ICON_GRAVITY_TEXT_TOP
        icon = loadingDrawable
        loadingDrawable.start()
    }
}
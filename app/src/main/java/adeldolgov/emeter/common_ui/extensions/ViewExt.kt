package adeldolgov.emeter.common_ui.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import com.facebook.shimmer.ShimmerFrameLayout

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun TextView.setEndDrawableRes(@DrawableRes drawable: Int?) {
    val resultDrawable: Drawable? = drawable?.let { this.context.getDrawable(it) }
    setCompoundDrawablesWithIntrinsicBounds(null, null, resultDrawable, null)
}

var ShimmerFrameLayout.isShimmering: Boolean
    get() {
        return this.isShimmerStarted
    }
    set(shimmering) {
        this.isVisible = shimmering
        if (shimmering) startShimmer() else stopShimmer()
    }
package adeldolgov.emeter.common_ui.extensions

import android.content.res.Resources

/*
*@author Adel Dolgov on 07,Апрель,2021
*/
val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Float.dp: Float
    get() = (this * Resources.getSystem().displayMetrics.density)
val Int.px: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.sp: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()

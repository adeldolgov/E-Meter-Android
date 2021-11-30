package adeldolgov.emeter.common_ui.button

import android.graphics.drawable.Drawable
import com.google.android.material.button.MaterialButton

/*
*@author Adel Dolgov on 21,Май,2021
*/
class TweakableMaterialButtonProperties(
    val text: String,
    val icon: Drawable? = null,
    val iconGravity: Int = MaterialButton.ICON_GRAVITY_TEXT_START,
    val iconPadding: Int = 0
)

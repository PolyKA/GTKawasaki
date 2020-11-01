package com.github.polyKa.gtKawasaki.view.connect

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.github.polyKa.gtKawasaki.utils.GetDrawablesListFromAssets
import com.github.polyKa.gtKawasaki.utils.ImageGifUtil

/**
 * ViewModel for ConnectFragment.
 * @author Artem Gerasimov.
 */
class ConnectionViewModel(application: Application) : AndroidViewModel(application) {
    private val imageGifUtil = ImageGifUtil()
    private val context = application.applicationContext

    /**
     * The end-of-updates images.
     */
    fun stopChangeImage(){
        imageGifUtil.stopChangeImage()
    }

    /**
     * Start updating images in ImageView.
     */
    fun startChangeImage(directory: String, image: ImageView){
        val getDrawablesListFromAssets = GetDrawablesListFromAssets(context)


        imageGifUtil.startChangeImage(imageList = getDrawablesListFromAssets.get(directory),
                                      imageView = image)
    }
}
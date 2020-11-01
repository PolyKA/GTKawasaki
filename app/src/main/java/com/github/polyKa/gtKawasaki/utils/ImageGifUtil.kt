package com.github.polyKa.gtKawasaki.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This util method allows you to change images in ImageView.
 * @author Artem Gerasimov.
 */
class ImageGifUtil {
    private var imagePosition: MutableLiveData<Int> = MutableLiveData(0)
    private var isWork = false

    /**
     * The end-of-updates images.
     */
    fun stopChangeImage(){
        isWork = false
    }

    /**
     * Start updating images in ImageView.
     * @param imageView - imageView where images change.
     * @param imageList - a set of images that change in ImageView.
     * @param updateRate - time after which the image changes.
     */
    fun startChangeImage(imageView: ImageView,
                         imageList: List<Drawable>,
                         updateRate: Long = 3000){
        isWork = true
        GlobalScope.launch {
            while (isWork){
                delay(updateRate)
                changeValue(imageView, imageList)
            }
        }
    }

    /**
     * Method that updates images in ImageView.
     */
    private fun changeValue(image: ImageView, imageList: List<Drawable>){
        if(imageList.isNotEmpty()){
            GlobalScope.launch(Dispatchers.Main) {
                imagePosition.value = (imagePosition.value?.plus(1))?.rem(imageList.size)

                if(imagePosition.value != null){
                    image.setImageDrawable(imageList[imagePosition.value!!])
                }
            }
        }
    }
}
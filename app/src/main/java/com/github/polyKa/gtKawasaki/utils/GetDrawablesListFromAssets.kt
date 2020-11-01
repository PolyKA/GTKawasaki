package com.github.polyKa.gtKawasaki.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import java.io.File

/**
 * This util method allows you to get files that are stored in the assets Directive.
 * @author Artem Gerasimov.
 */
class GetDrawablesListFromAssets(private val context: Context) {
    /**
     * Get files that are stored in the assets Directive.
     * @param directory - the name of the folder
     * from which you want to upload images.
     * @return array that stores all values from the folder.
     */
    fun get(directory: String): List<Drawable>{
        val am: AssetManager =  context.assets
        val files = am.list(directory)
        val drawables: ArrayList<Drawable> = ArrayList()

        for (file in files!!) {
            val d = Drawable.createFromStream(
                    am.open(
                            "$directory${File.separator}$file"
                    ),
                    null
            )
            drawables.add(d)
        }

        return drawables
    }
}

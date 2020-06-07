package view

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import com.example.comicviewer.base.ActBind
import com.example.comicviewer.databinding.ActMainBinding
import com.example.comicviewer.model.comic.Comic
import custom.*
import model.ItemViewComic
import viewmodel.ViewModelMain



@SuppressLint("Registered")
class ActMain : ActBind<ActMainBinding>() {

    override val binding by lazy { bind(ActMainBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelMain>() }
    //lateinit var accessComic:AccessComic
    val set = mutableSetOf<Comic>()

    override fun ActMainBinding.onBoundView() {
        //accessComic = DatabaseBuilder.getAppDatabase(activity).accessComic()
        recyclerComic.adapter = recyclerAdapter<ItemViewComic>(set)

        viewModel.comicResponse.observe(
            activity,
            Observer {
                it?.run {
                    //it.forEach { comic -> accessComic.insertAll(comic) }
                    set.addAll(it)
                    recyclerComic.update()
                }
            }
        )
        viewModel.getResponse()
    }


}

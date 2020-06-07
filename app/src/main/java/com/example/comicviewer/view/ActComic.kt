package view

import android.os.Bundle
import com.example.comicviewer.base.ActBind
import com.example.comicviewer.databinding.ActComicBinding
import com.example.comicviewer.model.DBComic
import com.example.comicviewer.model.comic.Comic
import com.squareup.picasso.Picasso
import custom.viewModel
import kotlinx.android.synthetic.main.act_comic.*
import viewmodel.ViewModelComic


class ActComic : ActBind<ActComicBinding>() {

    override val binding by lazy { bind(ActComicBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelComic>() }


    override fun Bundle.onExtras() {
        getParcelable<DBComic>("key")?.title
    }

    override fun ActComicBinding.onBoundView() {
        comicTitle.setText()

    }


}

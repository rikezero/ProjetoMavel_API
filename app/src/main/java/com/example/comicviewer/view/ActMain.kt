package view






import android.annotation.SuppressLint
import base.ActBind
import com.example.comicviewer.databinding.ActMainBinding
import custom.get
import custom.recyclerAdapter
import custom.viewModel
import model.ItemViewComic
import model.comic.ComicResponse
import viewmodel.ViewModelMain


@SuppressLint("Registered")
class ActMain : ActBind<ActMainBinding>() {

    override val binding by lazy { bind(ActMainBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelMain>() }
    val set = mutableSetOf<ComicResponse>()
    val comics = set.get(0).comicDataContainer.comics
    override fun ActMainBinding.onBoundView() {
        val adapter = recyclerAdapter<ItemViewComic>(comics)
    }


}

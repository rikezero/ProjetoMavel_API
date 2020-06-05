package model








import com.example.comicviewer.databinding.ItemComicBinding
import com.squareup.picasso.Picasso
import custom.adapter.ItemViewBuilder
import model.comic.Comic


class ItemViewComic : ItemViewBuilder<Comic, ItemComicBinding>() {

    override val binding by lazy { bind(ItemComicBinding::class) }

    override fun ItemComicBinding.onBind(position: Int) {
        (collection as Set<Comic>).elementAt(position).run {
            Picasso.get().load(thumbnail.image).into(comicImage)
            comicName.text = title
        }
    }
}

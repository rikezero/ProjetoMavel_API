package model

import com.example.comicviewer.databinding.ItemComicBinding
import com.example.comicviewer.model.DBComic
import com.example.comicviewer.model.comic.Comic
import com.squareup.picasso.Picasso
import custom.adapter.ItemViewBuilder
import custom.launchActivity
import custom.onClick
import kotlinx.android.synthetic.main.act_comic.view.*
import view.ActComic


class ItemViewComic : ItemViewBuilder<Comic, ItemComicBinding>() {

    override val binding by lazy { bind(ItemComicBinding::class) }

    override fun ItemComicBinding.onBind(position: Int) {
        (collection as Set<Comic>).elementAt(position).run {
            Picasso.get().load(thumbnail.getStandardMedium()).into(comicImage)
            comicName.text = title
            cardView.onClick {
                val parcel = DBComic(
                    title,
                    dates[0].date,
                    thumbnail,
                    images[0],
                    prices[0].toString(),
                    pageCount,
                    description
                )
                context.launchActivity(ActComic::class.java){
                    putParcelable("key", parcel)

                }
            }
        }
    }
}

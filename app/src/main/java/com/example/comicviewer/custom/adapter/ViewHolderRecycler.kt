package custom.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutParams.MATCH_PARENT
import android.support.v7.widget.RecyclerView.LayoutParams.WRAP_CONTENT
import android.view.ViewGroup
import android.viewbinding.ViewBinding

open class RecyclerViewHolder(val builder: ItemViewBuilder<*, *>) :
    RecyclerView.ViewHolder(builder.build())

abstract class ItemViewBuilder<Data, Binding : ViewBinding> : InflateBinding {

    abstract val binding: Binding
    lateinit var collection: Collection<Data>
    lateinit var context: Context
    lateinit var recycler: RecyclerView

    @Suppress("UNCHECKED_CAST")
    fun init(group: ViewGroup, coll: Collection<*>) = apply {
        recycler = group as RecyclerView
        collection = coll as Collection<Data>
        context = group.context
    }

    fun build() = binding.root.apply {
        layoutParams = RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }

    fun onBind(position: Int) = binding.onBind(position)

    abstract fun Binding.onBind(position: Int)
}
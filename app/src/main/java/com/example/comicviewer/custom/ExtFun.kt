package custom

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders


import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.content.res.Resources.getSystem
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import custom.adapter.ItemViewBuilder


fun <T : Any> Context.launchActivity(clazz: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, clazz)
    startActivity(intent.putExtras(Bundle().apply(extras)))
}
/////////////////////////////////////////////////////////////////
fun <T> Collection<T>.get(index: Int): T {
    forEachIndexed { indexed, element -> if (indexed == index) return element }
    throw IndexOutOfBoundsException()
}

inline fun <reified Builder : ItemViewBuilder<*, *>>
        RecyclerView.setup(list: Collection<*>) =
    recyclerAdapter<Builder>(list).apply { adapter = this }

val RecyclerView.recyclerAdapter get() = adapter as RecyclerAdapter?

fun RecyclerView.update() = recyclerAdapter?.notifyDataSetChanged()

fun <T> MutableList<T>.update(collection: MutableList<T>) {
    clear()
    collection.forEach { add(it) }
}

fun Activity.hideKeyBoard() =
    (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?)
        ?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)


val Int.isEven get() = this % 2 == 0

val Int.isOdd get() = this % 2 != 0

val EditText.string get() = text.toString()

val EditText.int get() = string.toInt()

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun String.isDigit(): Boolean {
    for (char in this) {
        if (!char.isDigit()) return false
    }
    return true
}

inline fun <reified Model : ViewModel> FragmentActivity.viewModel(): Model =
    ViewModelProviders.of(this).get(Model::class.java)

inline fun <reified Model : ViewModel> Fragment.viewModel(): Model =
    ViewModelProviders.of(this).get(Model::class.java)

fun <T : Comparable<T>> listOfRange(iterable: Iterable<T>): MutableList<T> {
    val list = mutableListOf<T>()
    iterable.forEach { list.add(it) }
    return list
}

fun <AnyView : View> AnyView.onClick(function: AnyView.() -> Unit = {}) {
    setOnClickListener { function() }
}

@Suppress("UNCHECKED_CAST")
val <Type : Number> Type.dp
    get() = (toFloat() * getSystem().displayMetrics.density) as Type

@Suppress("UNCHECKED_CAST")
val <Type : Number> Type.dpToPx
    get() = (toFloat() / getSystem().displayMetrics.density) as Type

//@Suppress("UNCHECKED_CAST")
//val <Type : Number> Type.dp get() = (toFloat() * getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT) as Type
//
//@Suppress("UNCHECKED_CAST")
//val <Type: Number> Type.dpToPx get() = (toFloat() / getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT) as Type

fun onTextSubmit(block: (String) -> Unit) = object : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(dota: String): Boolean {
        block(dota)
        return false
    }

    override fun onQueryTextChange(s: String): Boolean {
        return false
    }
}


















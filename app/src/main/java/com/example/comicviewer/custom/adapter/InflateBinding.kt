package custom.adapter

import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.viewbinding.ViewBinding

import kotlin.reflect.KClass

interface InflateBinding {

    @Suppress("UNCHECKED_CAST")
    fun <Binding : ViewBinding> ItemViewBuilder<*, Binding>.bind(bindClass: KClass<Binding>) =
        bindClass.java.getMethod("inflate", LayoutInflater::class.java).invoke(
            null, ((recycler.context) as AppCompatActivity).layoutInflater
        ) as Binding

    @Suppress("UNCHECKED_CAST")
    fun <Binding : ViewBinding> ItemViewBuilder<*, Binding>.bind(bindClass: Class<Binding>) =
        bindClass.getMethod("inflate", LayoutInflater::class.java).invoke(
            null, ((recycler.context) as AppCompatActivity).layoutInflater
        ) as Binding

    @Suppress("UNCHECKED_CAST")
    fun <Binding : ViewBinding> AppCompatActivity.bind(bindClass: KClass<Binding>) =
        bind(bindClass.java)

    @Suppress("UNCHECKED_CAST")
    fun <Binding : ViewBinding> AppCompatActivity.bind(bindClass: Class<Binding>) =
        bindClass.getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as Binding

}

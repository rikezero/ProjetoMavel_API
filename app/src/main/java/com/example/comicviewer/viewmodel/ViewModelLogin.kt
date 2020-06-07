package viewmodel


import android.arch.lifecycle.ViewModel
import android.widget.EditText


class ViewModelLogin : ViewModel() {

    //val stringFormatada = MutableLiveData<String>()
    //private val repoWeather = RepositoryWeather()
    fun validade(field1 : EditText, field2 : EditText): Boolean {
        return field1.text.isEmpty()||field2.text.isEmpty()
    }

}

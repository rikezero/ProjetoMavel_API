package viewmodel


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import model.comic.Comic
import repository.RepositoryMarvel


class ViewModelMain : ViewModel() {

    val comicResponse = MutableLiveData<MutableSet<Comic>>()
    private val repositoryMarvel = RepositoryMarvel()

    fun getResponse(page: Int = 1) = CoroutineScope(IO).launch {
        comicResponse.postValue(repositoryMarvel.getResponse().comicDataContainer.comics)
    }

}

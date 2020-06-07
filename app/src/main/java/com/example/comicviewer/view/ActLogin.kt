package view

import com.example.comicviewer.base.ActBind
import com.example.comicviewer.R
import com.example.comicviewer.databinding.ActLoginBinding
import custom.launchActivity
import custom.toast
import custom.viewModel
import viewmodel.ViewModelLogin


class ActLogin : ActBind<ActLoginBinding>() {

    override val binding by lazy { bind(ActLoginBinding::class) }
    private val viewModel by lazy { viewModel<ViewModelLogin>() }

    override fun ActLoginBinding.onBoundView() {

        button.setOnClickListener {
            if(viewModel.validade(userInput,passInput)){
                toast(getString(R.string.empty_fields))
            }
            else{
            launchActivity(ActMain::class.java)
            }
        }

    }


}

package view

import android.content.Intent
import android.os.Bundle
import com.example.comicviewer.base.ActBase


class ActSplash : ActBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, ActLogin::class.java))
        finish()
    }
}
package br.borba.gitapiconsume.clean.presenter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.borba.cleanmvvm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}
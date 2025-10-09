package com.jasonharris97.jaysports.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.jasonharris97.jaysports.ui.R
import com.jasonharris97.jaysports.ui.searchTeams.view.SearchTeamsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.main_fragment_container, SearchTeamsFragment())
        }
    }
}
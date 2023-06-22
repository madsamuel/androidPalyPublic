package com.seattledevcamp.samplelistview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class StreetDetailsActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_street_details)

        val toolbar: Toolbar = findViewById(R.id.toolbarDetails)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val street = intent.getStringExtra("street")
        val description = intent.getStringExtra("description")

        val streetTextView: TextView = findViewById(R.id.streetTextView)
        streetTextView.text = street

        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        descriptionTextView.text = description
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.street_details_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
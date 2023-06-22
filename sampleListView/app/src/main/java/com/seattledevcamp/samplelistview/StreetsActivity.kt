package com.seattledevcamp.samplelistview

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class StreetsActivity : AppCompatActivity() {
    private val descriptionMap = mapOf(
        "Melbourne" to mapOf(
            "Street 1" to "Description of Street 1 in Melbourne",
            "Street 2" to "Description of Street 2 in Melbourne",
            "Street 3" to "Description of Street 3 in Melbourne"
        ),
        "Vienna" to mapOf(
            "Street A" to "Description of Street A in Vienna",
            "Street B" to "Description of Street B in Vienna",
            "Street C" to "Description of Street C in Vienna"
        ),
        "Vancouver" to mapOf(
            "Street X" to "Description of Street X in Vancouver",
            "Street Y" to "Description of Street Y in Vancouver",
            "Street Z" to "Description of Street Z in Vancouver"
        )
        // Add more descriptions as needed
    )

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streets)

        val city = intent.getStringExtra("city")
        val streets: Array<String> = intent.getStringArrayExtra("streets") ?: arrayOf()

        val adapter = ArrayAdapter(this, R.layout.listview_item, streets)

        val listView: ListView = findViewById(R.id.listview_streets)
        listView.adapter = adapter

        toolbar = findViewById(R.id.toolbar)
        setupToolbar(city)

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedStreet = streets[position]
                val description = descriptionMap[city]?.get(selectedStreet)

                val intent = Intent(this, StreetDetailsActivity::class.java).apply {
                    putExtra("street", selectedStreet)
                    putExtra("description", description)
                }
                startActivity(intent)
            }
    }

    private fun setupToolbar(city: String?) {
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Streets in $city"
            setDisplayHomeAsUpEnabled(true)
        }

        // Add a button to the Toolbar
        toolbar.inflateMenu(R.menu.streets_menu)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_button -> {
                    // Handle button click event
                    // Perform any desired action here
                    true
                }
                else -> false
            }
        }
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

package com.seattledevcamp.samplelistview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val cities = arrayOf(
        "Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary",
        "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg",
        "Munich", "New York", "Sydney", "Paris", "Cape Town",
        "Barcelona", "London", "Bangkok"
    )

    private val streetsMap = mapOf(
        "Melbourne" to arrayOf("Street 1", "Street 2", "Street 3"),
        "Vienna" to arrayOf("Street A", "Street B", "Street C"),
        "Vancouver" to arrayOf("Street X", "Street Y", "Street Z"),
        // Add more cities and streets as needed
    )

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
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.id.activity_main)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, R.layout.listview_item, cities)

        val listView: ListView = findViewById(R.id.listview_1)
        listView.adapter = adapter

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCity = cities[position]

                // Show a Toast with the selected city
                Toast.makeText(applicationContext, "Selected city: $selectedCity", Toast.LENGTH_SHORT).show()

                // Open a new activity with streets for the selected city
                openStreetsActivity(selectedCity)
            }
        }
    }

    private fun openStreetsActivity(city: String) {
        val streets = streetsMap[city]

        if (streets != null) {
            val intent = Intent(this, StreetsActivity::class.java)
            intent.putExtra("city", city)
            intent.putExtra("streets", streets)
            startActivity(intent)
        } else {
            Toast.makeText(this, "No streets found for $city", Toast.LENGTH_SHORT).show()
        }
    }
}

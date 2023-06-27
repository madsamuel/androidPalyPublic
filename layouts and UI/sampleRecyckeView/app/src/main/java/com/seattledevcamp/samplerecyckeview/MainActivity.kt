package com.seattledevcamp.samplerecyckeview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.IOException
import java.io.InputStream
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView  = findViewById(R.id.recyclerView)

        // Load the XML list
        try {
            val itemList = ArrayList<MyItems>()
            val istream: InputStream = assets.open("contacts.xml")

            val builderFactory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            val docBuilder: DocumentBuilder = builderFactory.newDocumentBuilder()
            val doc: Document = docBuilder.parse(istream)
            val itemListNode: NodeList = doc.getElementsByTagName("item")

            for (i in 0 until itemListNode.length) {
                if (itemListNode.item(i).nodeType == Node.ELEMENT_NODE) {
                    val itemNode: Element = itemListNode.item(i) as Element

                    val tempName = itemNode.getAttribute("name")
                    val tempEmail =  itemNode.getAttribute("email")
                    val tempImageId = itemNode.getAttribute("imageId")

                    // convert string to drawable
                    val resID = resources.getIdentifier(itemNode.getAttribute("imageId"), "drawable", packageName)

                    itemList.add(MyItems(tempName, tempEmail, resID))

                    Log.d("MyMainActivity", "Added item: $tempName, $tempEmail, $tempImageId")
                }
            }

            // val adapter = MyViewAdapter(this, itemList)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = MyViewAdapter(applicationContext, itemList)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParserConfigurationException) {
            e.printStackTrace()
        }
    }
}


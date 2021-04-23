package com.example.currencyonverter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var doc: Document
    private var secThread: Thread? = null
    private var runnable: Runnable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        runnable = Runnable { hTML }
        secThread = Thread(runnable)
        secThread!!.start()
    }

    private val hTML: Unit
        private get() {
            try {
                doc = Jsoup.connect("https://minfin.com.ua/currency/").get()
                Log.d("MyLog", "getHTML: " + doc.title())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
}
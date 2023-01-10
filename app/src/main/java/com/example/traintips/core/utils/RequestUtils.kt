package com.example.traintips.core.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.traintips.core.ConfigBean
import com.example.traintips.core.JourneyBean
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths

const val CONFIG_FILE = "config.json"

@RequiresApi(Build.VERSION_CODES.O)
val READER: Reader = Files.newBufferedReader(Paths.get(CONFIG_FILE))

const val URL_API_SNCF =
    "https://api.sncf.com/v1/coverage/sncf"

@RequiresApi(Build.VERSION_CODES.O)
object RequestUtils {
    private var client = OkHttpClient()
    private var gson = Gson()
    private var config = gson.fromJson(READER, ConfigBean::class.java)
    var current_options = ""

    val addPages = { pages :Array<String> -> "$URL_API_SNCF/${pages.joinToString("/")}"}

    fun addOptions(options : Array<Pair<String, String>>): String {
        current_options = "$URL_API_SNCF?${options[0].first}=${options[0].second}"
        for(index in 1 until options.size) {
            current_options += "&${options[index].first}=${options[index].second}"
        }
        return current_options
    }

    fun loadJourneys(): JourneyBean {
        val json: String = sendGet(URL_API_SNCF)
        return gson.fromJson(json, JourneyBean::class.java)
    }

    private fun sendGet(url: String): String {
        println("url : $url")
        val request = Request
            .Builder()
            .url(url)
            .addHeader("Authorization", config.api_key)
            .build()
        return client.newCall(request).execute().use {
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}:${it.message}")
            }
            it.body.string()
        }
    }
}
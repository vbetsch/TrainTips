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

const val URL_API_SNCF_JOURNEYS =
    "https://api.sncf.com/v1/coverage"

@RequiresApi(Build.VERSION_CODES.O)
object RequestUtils {
    private var client = OkHttpClient()
    private var gson = Gson()


    private var config = gson.fromJson(READER, ConfigBean::class.java)

    fun loadJourneys(lat :Double, lon :Double): JourneyBean {
        val json: String = sendGet(URL_API_SNCF_JOURNEYS)
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
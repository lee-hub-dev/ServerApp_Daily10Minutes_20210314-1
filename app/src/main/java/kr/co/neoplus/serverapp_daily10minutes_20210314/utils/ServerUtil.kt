package kr.co.neoplus.serverapp_daily10minutes_20210314.utils

import okhttp3.*
import java.io.IOException

class ServerUtil {

    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(id : String, pw : String) {

            val urlString = "${HOST_URL}/user"

            val formData = FormBody.Builder()
                .add("email", id)
                .add("password", pw)
                .build()

            val request = Request.Builder()
                .url(urlString)
                .post(formData)
                .build()

            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {

                    val bodyString = response.body!!.string()

                    Log.d("서버응답본문", bodyString)

                }

            })

        }

    }

}
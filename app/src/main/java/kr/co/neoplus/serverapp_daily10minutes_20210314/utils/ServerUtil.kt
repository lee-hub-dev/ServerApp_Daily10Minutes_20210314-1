package kr.co.neoplus.serverapp_daily10minutes_20210314.utils

import okhttp3.FormBody

class ServerUtil {

    companion object {

        val HOST_URL = "http://15.164.153.174"

        fun postRequestLogin(id : String, pw : String) {

            val urlString = "${HOST_URL}/user"

            val formData = FormBody.Builder()
                .add("email", id)
                .add("password", pw)
                .build()

        }

    }

}
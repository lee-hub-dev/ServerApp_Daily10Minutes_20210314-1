package kr.co.neoplus.serverapp_daily10minutes_20210314.utils

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JsonResponseHandler {
        fun onResponses(json : JSONObject)
    }

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

                    val jsonObj = JSONObject(bodyString)
                    Log.d("서버응답본문", jsonObj.toString())

                    val codeNum = jsonObj.getInt("code")

                    if (codeNum == 200) {
                        Log.d("로그인결과", "성공")
                    }
                    else {
                        Log.d("로그인결과", "실패")
                        val msgStr = jsonObj.getString("message")
                        Log.e("로그인실패사유", msgStr)
                    }

                }

            })

        }

    }

}
package kr.co.neoplus.serverapp_daily10minutes_20210314.utils

import android.content.Context

class ContextUtil {

    companion object {

        private val prefName = "Daily10MinutePref"

        private val IS_AUTO_LOGIN = "IS_AUTO_LOGIN"

        private val TOKEN = "TOKEN"

        fun setToken(context: Context, token : String) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(TOKEN, token).apply()

        }

        fun getToken(context: Context) : String {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getString(TOKEN, "")!!
        }

        fun setAutoLogin(context : Context, autoLogin : Boolean) {

            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            pref.edit().putBoolean(IS_AUTO_LOGIN, autoLogin).apply()

        }

        fun getAutoLogin(context: Context) : Boolean {

            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getBoolean(IS_AUTO_LOGIN, false)

        }

    }

}
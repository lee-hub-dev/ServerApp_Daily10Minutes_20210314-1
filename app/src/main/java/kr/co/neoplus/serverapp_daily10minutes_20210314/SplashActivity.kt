package kr.co.neoplus.serverapp_daily10minutes_20210314

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kr.co.neoplus.serverapp_daily10minutes_20210314.utils.ContextUtil

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {

        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({

            val savedToken = ContextUtil.getToken(mContext)
            val isAutoLogin = ContextUtil.getAutoLogin(mContext)

                if (savedToken != "" && isAutoLogin) {
                    val myIntent = Intent(mContext, MainActivity::class.java)
                    startActivity(myIntent)
                }
                else {
                    val myIntent = Intent(mContext, LoginActivity::class.java)
                    startActivity(myIntent)
                }

                finish()

        }, 3000)
    }


}
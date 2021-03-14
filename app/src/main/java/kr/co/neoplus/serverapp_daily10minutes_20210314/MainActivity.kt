package kr.co.neoplus.serverapp_daily10minutes_20210314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.neoplus.serverapp_daily10minutes_20210314.utils.ServerUtil
import org.json.JSONObject

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {

            val inputId = emailEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            ServerUtil.postRequestLogin(inputId, inputPw, object : ServerUtil.JsonResponseHandler {
                override fun onResponses(json: JSONObject) {
                }

            })

            }

    }

    override fun setValues() {

    }

}
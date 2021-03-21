package kr.co.neoplus.serverapp_daily10minutes_20210314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import kr.co.neoplus.serverapp_daily10minutes_20210314.utils.ServerUtil
import org.json.JSONObject

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        signUpBtn.setOnClickListener {
            val email = emailEdt.text.toString()
            val pw = pwEdt.text.toString()
            val nick = nicknameEdt.text.toString()

            ServerUtil.putRequestSignUp(email, pw, nick, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {

                    val code = json.getInt("code")

                    runOnUiThread {

                        if (code == 200) {
                            val dataObj = json.getJSONObject("data")
                            val userObj = dataObj.getJSONObject("user")
                            val userName = userObj.getString("nick_name")

                            Toast.makeText(mContext, "${userName}님 환영합니다", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        else {
                            val message = json.getString("message")
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

                        }
                    }

                }

            })

        }

    }

    override fun setValues() {

    }

}
package kr.co.neoplus.serverapp_daily10minutes_20210314

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kr.co.neoplus.serverapp_daily10minutes_20210314.utils.ContextUtil
import kr.co.neoplus.serverapp_daily10minutes_20210314.utils.ServerUtil
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        autoLoginCheckBox.setOnCheckedChangeListener{ buttonView, isChecked ->

            ContextUtil.setAutoLogin(mContext, isChecked)


            if (isChecked) {
                Toast.makeText(mContext, "로그인 성공 시 자동 로그인 됩니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(mContext, "자동 로그인이 해제됩니다.", Toast.LENGTH_SHORT).show()
            }
        }


        signUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }

        loginBtn.setOnClickListener {

            val inputId = emailEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            ServerUtil.postRequestLogin(inputId, inputPw, object : ServerUtil.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {

                    Log.d("화면입장", json.toString())

                    val code = json.getInt("code")

                    if (code == 200) {

                        val dataObj = json.getJSONObject("data")
                        val token = dataObj.getString("token")

                        ContextUtil.setToken(mContext, token)

                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)

                        finish()

                    } else {
                        val message = json.getString("message")
                        runOnUiThread {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    override fun setValues() {

        autoLoginCheckBox.isChecked = ContextUtil.getAutoLogin(mContext)

    }

}
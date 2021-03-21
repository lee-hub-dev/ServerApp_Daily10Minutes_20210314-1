package kr.co.neoplus.serverapp_daily10minutes_20210314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

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
        }

    }

    override fun setValues() {

    }

}
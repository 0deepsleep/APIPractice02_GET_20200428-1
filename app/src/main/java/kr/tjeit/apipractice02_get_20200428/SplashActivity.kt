package kr.tjeit.apipractice02_get_20200428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

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

//        2.5초동안 보여준 뒤 => 로그인 액티비티로 전환
        Handler().postDelayed({

            val myIntent = Intent(mContext, LoginActivity::class.java)
            startActivity(myIntent)
            finish()

        }, 2500)

    }

}

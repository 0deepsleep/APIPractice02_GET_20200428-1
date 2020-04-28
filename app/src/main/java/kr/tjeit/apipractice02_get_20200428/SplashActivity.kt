package kr.tjeit.apipractice02_get_20200428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kr.tjeit.apipractice02_get_20200428.utils.ContextUtil

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

            if (ContextUtil.getUserToken(mContext) == "") {
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()
            }
            else {

//                토큰이 저장되어있다면 => 이 토큰으로 사용자 정보를 받아서
//                GlobalData에 저장 하고 => 액티비티 전환

                val myIntent = Intent(mContext, MyPageActivity::class.java)
                startActivity(myIntent)
                finish()
            }



        }, 2500)

    }

}

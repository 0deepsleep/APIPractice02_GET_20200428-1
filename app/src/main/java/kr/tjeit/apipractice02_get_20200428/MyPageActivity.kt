package kr.tjeit.apipractice02_get_20200428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_my_page.*
import kr.tjeit.apipractice02_get_20200428.utils.ContextUtil
import kr.tjeit.apipractice02_get_20200428.utils.GlobalData

class MyPageActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        logoutBtn.setOnClickListener {

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("로그아웃")
            alert.setMessage("정말 로그아웃 하시겠습니까?")
            alert.setPositiveButton("확인", {dialog, which ->
                ContextUtil.setUserToken(mContext, "")

//            다시 로그인 화면으로 이동
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()
            })
            alert.setNegativeButton("취소", null)
            alert.show()


        }

    }

    override fun setValues() {

        nameTxt.text = GlobalData.loginUser?.name
        phoneTxt.text = GlobalData.loginUser?.phoneNum

    }

}

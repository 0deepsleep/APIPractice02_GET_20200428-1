package kr.tjeit.apipractice02_get_20200428

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_page.*
import kr.tjeit.apipractice02_get_20200428.utils.GlobalData

class MyPageActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        nameTxt.text = GlobalData.loginUser?.name
        phoneTxt.text = GlobalData.loginUser?.phoneNum

    }

}

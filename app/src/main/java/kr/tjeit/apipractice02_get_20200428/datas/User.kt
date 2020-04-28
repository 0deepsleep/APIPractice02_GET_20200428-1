package kr.tjeit.apipractice02_get_20200428.datas

import org.json.JSONObject
import java.util.*

class User {

    companion object {
        fun getUserFromJsonObject(json:JSONObject) : User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            return parsedUser
        }
    }

//    JSON 파싱 기초
    var id = 0
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""


//    JSON 파싱 응용
    var storeCategory = Category()
    var createdAt = Calendar.getInstance()

//    JSONObject를 가지고 => User 객체로 변환해주는 함수.



}
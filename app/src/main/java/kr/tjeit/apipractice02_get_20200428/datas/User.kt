package kr.tjeit.apipractice02_get_20200428.datas

import java.util.*

class User {

//    JSON 파싱 기초
    var id = 0
    var login_id = ""
    var name = ""
    var phoneNum = ""
    var memo = ""


//    JSON 파싱 응용
    var storeCategory = Category()
    var createdAt = Calendar.getInstance()


}
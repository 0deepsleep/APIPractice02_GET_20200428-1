package kr.tjeit.apipractice02_get_20200428.datas

import android.util.Log
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class Post {

    companion object {
        fun getPostFromJson(json:JSONObject) : Post {

            val p = Post()

            p.phoneNum = json.getString("phone_num")
            p.title = json.getString("title")
            p.content = json.getString("content")

            val userJson = json.getJSONObject("writer")
            p.writer = User.getUserFromJsonObject(userJson)

////            p.createdAt 에 2020년 1월 1일 13시 50분 0초 대입.
//            p.createdAt.set(2020, Calendar.JANUARY, 1, 13, 50, 0)
//
////            월만 10월로 변경.
//            p.createdAt.set(Calendar.MONTH, Calendar.OCTOBER)
//
////            200101 로 표시. => 출력할땐 항상 양식 가공. => SimpleDateFormat 사용
//
//            val sdf = SimpleDateFormat("yyMMdd")
//            Log.d("양식출력연습", sdf.format(p.createdAt.time))


//            서버에서 주는 String => p.createdAt (Calendar)로 변환 저장
            val createdStr = json.getString("created_at")

            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            p.createdAt.time = sdf.parse(createdStr)

            return p
        }
    }

    var phoneNum = ""
    var title = ""
    var content = ""

    var writer = User()
    var createdAt = Calendar.getInstance()
}
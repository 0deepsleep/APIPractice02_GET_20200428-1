package kr.tjeit.apipractice02_get_20200428.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.tjeit.apipractice02_get_20200428.R
import kr.tjeit.apipractice02_get_20200428.datas.Post
import kr.tjeit.apipractice02_get_20200428.utils.ConnectServer
import org.json.JSONObject

class BoardFragment : BaseFragment() {

    val posts = ArrayList<Post>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_board, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        getPostsFromServer()

    }

    fun getPostsFromServer() {

        ConnectServer.getRequestPostList(mContext, object : ConnectServer.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
//                Log.d("게시글목록", json.toString())

                val code = json.getInt("code")

                if (code == 200) {
                    val data = json.getJSONObject("data")
                    val blackLists = data.getJSONArray("black_lists")

//                    배열 : 10개 => 0~9
                    for (i in 0..blackLists.length()-1) {
                        val postJson = blackLists.getJSONObject(i)

                    }

                }

            }

        })

    }


}
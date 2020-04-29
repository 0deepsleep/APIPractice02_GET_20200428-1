package kr.tjeit.apipractice02_get_20200428.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_board.*
import kr.tjeit.apipractice02_get_20200428.EditPostActivity
import kr.tjeit.apipractice02_get_20200428.R
import kr.tjeit.apipractice02_get_20200428.adapters.PostAdapter
import kr.tjeit.apipractice02_get_20200428.datas.Post
import kr.tjeit.apipractice02_get_20200428.utils.ConnectServer
import org.json.JSONObject

class BoardFragment : BaseFragment() {

    lateinit var postAdaper:PostAdapter
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
        postBtn.setOnClickListener {
            val myIntent = Intent(mContext, EditPostActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        postAdaper = PostAdapter(mContext, R.layout.post_list_item, posts)
        postListView.adapter = postAdaper

    }

    override fun onResume() {
        super.onResume()

        getPostsFromServer()
    }


    fun getPostsFromServer() {

        ConnectServer.getRequestPostList(mContext, object : ConnectServer.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {
//                Log.d("게시글목록", json.toString())

                val code = json.getInt("code")

                if (code == 200) {

//                    기존에 받아둔 게시글들은 전부 삭제
//                    새로 받아온 게시글로 목록을 채우자.

                    posts.clear()

                    val data = json.getJSONObject("data")
                    val blackLists = data.getJSONArray("black_lists")

//                    배열 : 10개 => 0~9
                    for (i in 0..blackLists.length()-1) {
                        val postJson = blackLists.getJSONObject(i)

//                        게시글 JSON => Post형태로 변경
                        val postObject = Post.getPostFromJson(postJson)

//                        변경된 객체를 posts에 추가
                        posts.add(postObject)

                    }

                    activity?.runOnUiThread {

                        postAdaper.notifyDataSetChanged()
                    }

                    for (post in posts) {
                        Log.d("게시글제목", post.title)
                    }

                }

            }

        })

    }


}
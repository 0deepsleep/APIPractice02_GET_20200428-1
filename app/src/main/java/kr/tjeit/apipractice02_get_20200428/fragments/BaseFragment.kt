package kr.tjeit.apipractice02_get_20200428.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context

//    액티비티가 만들어질때 => 액티비티를 Context로 변환해서 저장.
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mContext = activity as Context
//    }


//    액티비티에 프래그먼트가 붙을때 => context를 그냥 대입.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    abstract fun setupEvents()
    abstract fun setValues()



}
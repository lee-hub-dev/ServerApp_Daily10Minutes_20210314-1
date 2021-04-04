package kr.co.neoplus.serverapp_daily10minutes_20210314.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.neoplus.serverapp_daily10minutes_20210314.R
import kr.co.neoplus.serverapp_daily10minutes_20210314.ViewPhotoActivity
import kr.co.neoplus.serverapp_daily10minutes_20210314.datas.User

class ProjectMemberAdapter(
    val mContext : Context,
    val resId : Int,
    val mList: ArrayList<User>) : ArrayAdapter<User>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow) == null {
            tempRow = inflater.inflate(R.layout.member_list_item, null)
        }

        val Row = tempRow!!

        val memberData = mList[position]

        val memberProfileImg = row.findViewById<ImageView>(R.id.memberProfileImg)
        val memberNickname = row.findViewById<TextView>(R.id.memberNicknameTxt)

        Glide.with(mContext).load(memberData.profileIgsUrls[0])into(memberProfileImg)
        memberNicknameTxt.text = memberData.nickName

//        프로필 사진을 클릭하면 -> 사진 크게 보기 화면을 이동. 어댑터 안에서 코딩.

        memberProfileImg.setOnClickListener {
            Log.d("프사클릭", "${memberData.nickName}의 프사 클릭됨")

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            myIntent.putExtra("user",memberData)

//            어댑터는 스타드액티비티 사용 X (상속 안 받음)
//            mContext 변수 : 어댑터를 사용하는 화면을 들고있는 역할
//            mContext의 기능 중에 startActivity  사용
            mContext.startActivity(myIntent)

        }

        return Row
    }
}
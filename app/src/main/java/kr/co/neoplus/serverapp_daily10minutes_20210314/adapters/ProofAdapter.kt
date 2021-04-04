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
import kr.co.neoplus.serverapp_daily10minutes_20210314.datas.Proof
import kr.co.neoplus.serverapp_daily10minutes_20210314.datas.User
import java.text.SimpleDateFormat

class ProofAdapter(
    val mContext : Context,
    val resId : Int,
    val mList: ArrayList<Proof>) : ArrayAdapter<Proof>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow) == null {
            tempRow = inflater.inflate(R.layout.proof_list_item, null)
        }

        val Row = tempRow!!

        val data = mList[position]

        val writerProfileImg = row.findViewById<ImageView>(R.id.writerProfileImg)
        val writerNicknameTxt = row.findViewById<ImageView>(R.id.writerNicknameTxt)
        val proofDateTimeTxt row.findViewById<ImageView>(R.id.proofDateTimeTxt)
        val contentTxt.findViewById<ImageView>(R.id.contentTxt)
        val ProofImg = row.findViewById<ImageView>(R.id.ProofImg)
        val likeBtn = row.findViewById<ImageView>(R.id.likeBtn)
        val replyBtn = row.findViewById<ImageView>(R.id.replyBtn)

        contentTxt.text = lsdf

        Glide.with(mContext).load(data.writer.profileImgUrls[0]).into(writerProfileImg)
        writerNicknameTxt.text = data.writer.nickName

        val sdf = SimpleDateFormat("yyyy-MM-dd\na H:mm")
        proofDateTimeTxt.text = sdf.format(data.proofDateTime.time)

        return Row

    }

}
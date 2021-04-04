package kr.co.neoplus.serverapp_daily10minutes_20210314.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.neoplus.serverapp_daily10minutes_20210314.R
import kr.co.neoplus.serverapp_daily10minutes_20210314.datas.Project

class ProjectAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : List<Project>) : ArrayAdapter<Project>(mContext,resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.project_list_item, null)
        }
        val row = tempRow!!

        val data = mList[position]

        val projectImg = row.findViewById<ImageView>(R.id.projectImg)
        val projectTitleTxt = row.findViewById<TextView>(R.id.projectTitleTxt)

        Glide.with(mContext).load(data.imageURL).into(projectImg)

        projectTitleTxt.text = data.title

        return row
    }

}
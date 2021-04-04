package kr.co.neoplus.serverapp_daily10minutes_20210314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_photo.*
import kr.co.neoplus.serverapp_daily10minutes_20210314.adapters.PhotoViewPagerAdapter
import kr.co.neoplus.serverapp_daily10minutes_20210314.datas.User
import okhttp3.internal.userAgent

class ViewPhotoActivity : BaseActivity() {

    lateinit var mUser : User

    lateinit var mPhotoAdapter : PhotoViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//      뷰페이저의 페이지 변경되었을 때 -> 이벤트 처리
        val addOnPageChangeListener: Any =
            profilePhotoViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeList)
        positionOffset: Float,

        override fun onPageSelected(position: Int) {

            photoCountTxt.text = "${position+1}"

        }



    }


    }

    override fun setValues() {

        mUser = intent.getSerializableExtra("user") as User

        mPhotoAdapter = PhotoViewPagerAdapter(supportFragmentManager, mUser.profileImgUrls)
        profilePhotoViewPager.adapter = mPhotoAdapter

//        사진이 실제로 몇장인지 받아서 텍스트뷰에 반영
        photoCountTxt.text = "1 / ${mUser.profileIgsUrls.size}"

}
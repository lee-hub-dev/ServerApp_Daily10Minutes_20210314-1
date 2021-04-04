package kr.co.neoplus.serverapp_daily10minutes_20210314.datas

import org.json.JSONObject
import java.io.Serializable

class Project : Serializable {

    var id = 0
    var title = ""
    var imageURL = ""
    var description = ""
    var ongoingUsersCount = 0
    var proofMethod = ""


    var myLastStatus : String? = null


    val hashTags = ArrayList<String>()

    companion object {

        fun getProjectDataFromJson(jsonObj : JSONObject) : Project {

            val projectData = Project()

            projectData.id = jsonObj.getInt("id")
            projectData.title = jsonObj.getString("title")
            projectData.imageURL = jsonObj.getString("img_url")
            projectData.description = jsonObj.getString("description")
            projectData.ongoingUsersCount = jsonObj.getInt("ongoing_users_count")

            projectData.proofMethod = jsonObj.getString("proof_method")

            if (!jsonObj.isNull("my_last_status")) {

                projectData.myLastStatus = jsonObj.getString("my_last_status")
            }

//태그목록을 파싱 -> 스트링만 추출해서 해쉬태그목록에 담아주자
            val tagsArr = jsonObj.getJSONArray("tags")

            for (index in 0 until tagsArr.length()) {
                val tagObj = tagsArr.getJSONObject(index)
                //
                val tagTitle = tagObj.getString("title")
                projectData.hashTags.add(tagTitle)
            }

//완성된 프로젝트데이터 결과가 나가도록
            return projectData

        }

    }

}
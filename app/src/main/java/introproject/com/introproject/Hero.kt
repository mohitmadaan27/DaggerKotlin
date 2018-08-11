package introproject.com.introproject

import com.google.gson.annotations.SerializedName

/**
 * Created by HP on 8/11/2018.
 */

class Hero(@field:SerializedName("name")
           val name: String, val realname: String, val team: String, val firstappearance: String, val createdby: String, val publisher: String, val imageurl: String, val bio: String) {


}
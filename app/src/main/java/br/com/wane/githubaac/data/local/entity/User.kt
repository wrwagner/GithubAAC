package br.com.wane.githubaac.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class User(
        @PrimaryKey
        var id: Int? = 0,
        var login: String? = "",
        var name: String? = "",
        @SerializedName("avatar_url")
        var avatarURL: String? = "",
        var lastRefresh: Date? = null
)
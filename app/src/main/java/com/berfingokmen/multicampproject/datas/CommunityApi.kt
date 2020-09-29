package com.berfingokmen.multicampproject.datas
import com.berfingokmen.multicampproject.datas.model.Infos
import retrofit2.http.GET

interface CommunityApi {
    @GET("multicamp/communities")

    suspend fun getToCommunities():List<Infos>
}
package br.com.wane.githubaac.data.remote

import br.com.wane.githubaac.data.local.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebService {

    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String) : Call<User>
}
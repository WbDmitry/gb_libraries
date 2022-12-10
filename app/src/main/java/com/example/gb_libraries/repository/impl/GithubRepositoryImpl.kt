package com.example.gb_libraries.repository.impl

import com.example.gb_libraries.model.GithubUser

class GithubRepositoryImpl {
    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa"),
    )

    fun getUsers(): List<GithubUser> {
        return repositories
    }
}
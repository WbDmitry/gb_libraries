package com.example.gb_libraries.repository

import com.example.gb_libraries.model.GithubUser
import io.reactivex.Observable

interface GitHubRepository {
    val users: Observable<List<GithubUser>>
}
package com.example.gb_libraries.repository.impl

import com.example.gb_libraries.model.GithubUser
import com.example.gb_libraries.repository.GitHubRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class GithubRepositoryImpl: GitHubRepository {
    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa"),
    )

    private val behaviorSubject = BehaviorSubject.createDefault(repositories)

    override val users: Observable<List<GithubUser>>
        get() = behaviorSubject
}
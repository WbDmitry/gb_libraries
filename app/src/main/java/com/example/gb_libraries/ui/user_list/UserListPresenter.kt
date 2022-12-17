package com.example.gb_libraries.ui.user_list

import com.example.gb_libraries.core.nav.Screens
import com.example.gb_libraries.model.GithubUser
import com.example.gb_libraries.repository.impl.GithubRepositoryImpl
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable

class UserListPresenter(
    private val usersRepo: GithubRepositoryImpl,
    private val router: Router,
) : UserListContract.Presenter() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    class UsersListAdapterPresenter : UserListAdapterPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            view.position?.let {
                val user = users[it]
                view.setLogin(user.login)
            }
        }
    }

    val usersListPresenter = UsersListAdapterPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { userItemView ->
            userItemView.position?.let { index ->
                compositeDisposable.add(
                    usersRepo.users
                        .map { it[index] }
                        .subscribe(
                            { user ->
                                router.navigateTo(Screens.userDetails(user.login))
                            },
                            { thr ->
                                thr.message?.let { viewState.showError(it) }
                            }
                        )
                )
            }
        }
    }

    override fun loadData() {
        compositeDisposable.add(
            usersRepo.users
                .subscribe(
                    { userList ->
                        usersListPresenter.users.addAll(userList)
                        viewState.updateList()
                    },
                    { thr ->
                        thr.message?.let { viewState.showError(it) }
                    }
                )
        )
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

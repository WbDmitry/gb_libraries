package com.example.gb_libraries.ui.user_list

import com.example.gb_libraries.core.nav.Screens
import com.example.gb_libraries.model.GithubUser
import com.example.gb_libraries.repository.impl.GithubRepositoryImpl
import com.github.terrakok.cicerone.Router

class UserListPresenter(
    private val usersRepo: GithubRepositoryImpl,
    private val router: Router,
) : UserListContract.Presenter() {

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
            userItemView.position?.let {
                router.navigateTo(
                    Screens.openUserDetailsFragment(
                        loadUser(it).login
                    )
                )
            }
        }
    }

    override fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    override fun loadUser(position: Int): GithubUser {
        return usersRepo.getUsers()[position]
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}

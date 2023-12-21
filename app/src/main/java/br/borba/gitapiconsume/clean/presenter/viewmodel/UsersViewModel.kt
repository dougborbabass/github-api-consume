package br.borba.gitapiconsume.clean.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.borba.gitapiconsume.clean.domain.GetUsersListUseCase
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.model.toUiModel
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersListUseCase: GetUsersListUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<UsersUiModel>>()
    val users = _users as LiveData<List<UsersUiModel>>

    fun getUsers() {
        viewModelScope.launch {
            val usersList = getUsersListUseCase()

            _users.value = usersList.map { usersFinal ->
                usersFinal.toUiModel()
            }
        }
    }

}


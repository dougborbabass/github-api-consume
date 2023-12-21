package br.borba.gitapiconsume.clean.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.borba.gitapiconsume.clean.domain.GetUsersListUseCase
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.model.toUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsersListUseCase: GetUsersListUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

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

    fun lauchDataLoad(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                _loading.value = true
                block()
            } catch (x: Exception) {
                Log.e("Error", "erro progress")
            } finally {
                _loading.value = false
            }
        }
    }

}


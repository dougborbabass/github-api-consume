package br.borba.gitapiconsume.clean.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.borba.gitapiconsume.clean.domain.GetUserReposUseCase
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.model.toUiModel
import kotlinx.coroutines.launch

class UserReposViewModel(
    private val getUserReposUseCase: GetUserReposUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _userRepoos = MutableLiveData<List<UsersUiModel>>()
    val userRepos = _userRepoos as LiveData<List<UsersUiModel>>

    fun getUserRepos(user: String) {
        viewModelScope.launch {
            val usersList = getUserReposUseCase(user)

            _userRepoos.value = usersList.map { usersFinal ->
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


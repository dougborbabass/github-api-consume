package br.borba.gitapiconsume.clean.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.borba.gitapiconsume.clean.domain.GetUserDetailUseCase
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.model.toUiModel
import kotlinx.coroutines.launch

class UserDetailViewModel(
    private val getUserDetailUseCase: GetUserDetailUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _userDetail = MutableLiveData<UsersUiModel>()
    val userDetail = _userDetail as LiveData<UsersUiModel>

    fun getUserDetail() {
        viewModelScope.launch {
            val usersList = getUserDetailUseCase()

            _userDetail.value = usersList.toUiModel()
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


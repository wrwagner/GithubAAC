package br.com.wane.githubaac.ui.userprofile

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wane.githubaac.data.UserRepository
import br.com.wane.githubaac.data.local.entity.User
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(var userRepository: UserRepository): ViewModel() {

    var user : LiveData<User> = MutableLiveData<User>()

    fun pesquisar(login: String){
        user = userRepository.getUser(login)
    }

}
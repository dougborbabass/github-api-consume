package br.borba.gitapiconsume.clean.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.borba.cleanmvvm.R
import br.borba.cleanmvvm.databinding.FragmentUsersBinding
import br.borba.gitapiconsume.clean.presenter.adapter.UsersListAdapter
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.viewmodel.UserDetailViewModel
import br.borba.gitapiconsume.clean.presenter.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UsersFragment : Fragment() {

    private val viewModelUsersList: UsersViewModel by sharedViewModel()
    private val viewModelDetail: UserDetailViewModel by sharedViewModel()
    private lateinit var binding: FragmentUsersBinding
    private var isNewDetail = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelUsersList.lauchDataLoad { viewModelUsersList.getUsers() }
        binding.progress.visibility = View.VISIBLE

        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(binding) {
            searchView.clearFocus()
            searchView.setOnQueryTextListener(object :
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(strUser: String?): Boolean {
                    println("teste porto = $strUser")
                    viewModelDetail.lauchDataLoad {
                        viewModelDetail.getUserDetail(strUser.toString())
                        searchView.setQuery("", false);
                        searchView.clearFocus()
                        isNewDetail = true
                    }
                    return false
                }
            })
        }
    }

    private fun setObservers() {
        with(viewModelUsersList) {
            users.observe(viewLifecycleOwner) { listUsersUiModel ->
                binding.progress.visibility = View.GONE
                if (listUsersUiModel.isNotEmpty()) {
                    populateUsersList(listUsersUiModel)
                } else {
                    Toast.makeText(
                        activity,
                        getString(R.string.algo_deu_errado_tente_mais_tarde), Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        with(viewModelDetail) {
            userDetail.observe(viewLifecycleOwner) {
                if (isNewDetail) {
                    getDetailToFragmet(it)
                    isNewDetail = false
                }
            }
        }
    }

    private fun populateUsersList(users: List<UsersUiModel>) {
        binding.rvUsers.adapter = UsersListAdapter(users) { onUserItemClick(it) }
    }

    private fun onUserItemClick(user: UsersUiModel) {
        viewModelDetail.getUserDetail(user.userName)
        isNewDetail = true
    }

    private fun getDetailToFragmet(user: UsersUiModel) {
        val bundle = bundleOf("userDetail" to user)
        findNavController().navigate(R.id.action_homeUsers_to_detailFragment, bundle)
    }
}
package br.borba.gitapiconsume.clean.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.borba.cleanmvvm.R
import br.borba.cleanmvvm.databinding.FragmentUsersBinding
import br.borba.gitapiconsume.clean.data.model.UsersListResponse
import br.borba.gitapiconsume.clean.presenter.adapter.UsersListAdapter
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.viewmodel.UserDetailViewModel
import br.borba.gitapiconsume.clean.presenter.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UsersFragment : Fragment() {

    private val viewModelUsersList: UsersViewModel by sharedViewModel()
    private val viewModelDetail: UserDetailViewModel by sharedViewModel()
    private lateinit var binding: FragmentUsersBinding
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
                        searchView.clearFocus();
                    }
                    return false
                }
            })
        }
    }

    private fun setObservers() {
        with(viewModelUsersList) {
            loading.observe(viewLifecycleOwner) { showProgressBar ->
                if (showProgressBar) binding.progress.visibility = View.VISIBLE
                else binding.progress.visibility = View.GONE
            }

            users.observe(viewLifecycleOwner) { listUsersUiModel ->
                populateUsersList(listUsersUiModel)
            }
        }
        with(viewModelDetail) {
            userDetail.observe(viewLifecycleOwner) {
                println("it.id = ${it.id}")
            }
        }
    }

    private fun populateUsersList(users: List<UsersUiModel>) {
        binding.rvUsers.adapter = UsersListAdapter(users) { onUserItemClick(it) }
    }

    private fun onUserItemClick(user: UsersUiModel) {
        val bundle = bundleOf("userDetail" to user)
        findNavController().navigate(R.id.action_homeUsers_to_detailFragment, bundle)
    }

}
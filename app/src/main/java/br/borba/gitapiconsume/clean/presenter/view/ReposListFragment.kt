package br.borba.gitapiconsume.clean.presenter.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.borba.cleanmvvm.R
import br.borba.cleanmvvm.databinding.FragmentReposListBinding
import br.borba.gitapiconsume.clean.presenter.adapter.UserReposAdapter
import br.borba.gitapiconsume.clean.presenter.model.UserRepoUiModel
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.clean.presenter.viewmodel.UserReposViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ReposListFragment : Fragment() {

    private lateinit var binding: FragmentReposListBinding
    private val viewModel: UserReposViewModel by sharedViewModel()
    private lateinit var userDetail: UsersUiModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userDetail = it.getParcelable("userDetail")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReposListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUserRepos(userDetail.userName)

        setObservers()
        setListeners(userDetail)

    }

    private fun setObservers() {
        with(viewModel) {
            userRepos.observe(viewLifecycleOwner) {
                populateReposList(it)
            }
        }
    }

    private fun setListeners(user: UsersUiModel) {
        binding.btnBack.setOnClickListener {
            val bundle = bundleOf("userDetail" to user)
            findNavController().navigate(R.id.action_reposListFragment_to_detailFragment, bundle)
        }
    }

    private fun populateReposList(repos: List<UserRepoUiModel>) {
        binding.rvRepoList.adapter = UserReposAdapter(repos) { onRepoClick(it) }
    }

    private fun onRepoClick(userRepo: UserRepoUiModel) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(userRepo.htmlUrl))
        startActivity(intent)
    }
}
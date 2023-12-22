package br.borba.gitapiconsume.clean.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.borba.cleanmvvm.R
import br.borba.cleanmvvm.databinding.FragmentDetailBinding
import br.borba.gitapiconsume.clean.data.model.UsersListResponse
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
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
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvUserName.text = userDetail.userName

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeUsers)

        }

    }
}
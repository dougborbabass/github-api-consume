package br.borba.gitapiconsume.clean.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.borba.cleanmvvm.R
import br.borba.cleanmvvm.databinding.FragmentDetailBinding
import br.borba.gitapiconsume.clean.presenter.model.UsersUiModel
import br.borba.gitapiconsume.util.NumberFormatter
import coil.load
import coil.transform.RoundedCornersTransformation

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

        initUI()


        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeUsers)

        }

    }

    private fun initUI() {
        with(binding) {
            binding.tvName.text = userDetail.nameFull
            binding.tvUserName.text = userDetail.userName
            ivUserPic.load(userDetail.avatarUrl) {
                crossfade(true)
                transformations(RoundedCornersTransformation(20f))
            }
            tvFollowersFollowing.setTextAndVisibility(
                getFollowersFollowing(
                    userDetail.followers,
                    userDetail.following
                )
            )
            tvRepoCount.text = userDetail.publicRepos.toString()
        }
    }

    private fun getFollowersFollowing(followers: Int, following: Int): String {
        val followersStr = NumberFormatter.formatWithSuffix(followers)
        val followingStr = NumberFormatter.formatWithSuffix(following)
        return "$followersStr followers ▪ $followingStr following"
    }

    private fun TextView.setTextAndVisibility(text: String?) {
        visibility = if (text.isNullOrEmpty()) View.GONE else View.VISIBLE
        text?.let { this.text = it }
    }

}
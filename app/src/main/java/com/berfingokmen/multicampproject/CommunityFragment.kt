package com.berfingokmen.multicampproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.berfingokmen.multicampproject.datas.CommunityAdapter
import com.berfingokmen.multicampproject.datas.RetrofitSupplier
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : Fragment(R.layout.fragment_community) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            val response = RetrofitSupplier.communityApi.getToCommunities()
            recyclerViewCommunities.adapter =
                CommunityAdapter(response.toMutableList()){
                   val direction= CommunityFragmentDirections.actionCommunityFragmentToİnfosFragment(it)
                    findNavController().navigate(direction)
                }
        }



    }
}
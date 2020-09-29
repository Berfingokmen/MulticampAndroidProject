package com.berfingokmen.multicampproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import kotlinx.android.synthetic.main.fragment_infos.*

class InfosFragment : Fragment(R.layout.fragment_infos) {
    private val args by navArgs<InfosFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewComName.text = args.community.name
        imageViewBanner.load(args.community.banner)
        textViewDescription.text = args.community.description
        imageViewLeader.load(args.community.leader.photo)
        textViewLeaderName.text = args.community.leader.name
        instagram.setOnClickListener {
            val instagramLink = Intent(android.content.Intent.ACTION_VIEW)
            instagramLink.data = Uri.parse(args.community.links.instagram)
            startActivity(instagramLink)
        }
        youtube.setOnClickListener {
            val youtubeLink = Intent(android.content.Intent.ACTION_VIEW)
            youtubeLink.data = Uri.parse(args.community.links.youtube)
            startActivity(youtubeLink)
        }
        meetup.setOnClickListener {
            val meetupLink = Intent(android.content.Intent.ACTION_VIEW)
            meetupLink.data = Uri.parse(args.community.links.participation)
            startActivity(meetupLink)
        }
        twitter.setOnClickListener {
            val twitterLink = Intent(android.content.Intent.ACTION_VIEW)
            twitterLink.data = Uri.parse(args.community.links.twitter)
            startActivity(twitterLink)
        }


        homePage.setOnClickListener {
            findNavController().navigate(R.id.action_infosFragment_to_communityFragment)
        }

    }
}
package com.berfingokmen.multicampproject.datas

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.berfingokmen.multicampproject.R
import com.berfingokmen.multicampproject.datas.model.Infos
import kotlinx.android.synthetic.main.info_item.view.*

class CommunityAdapter(private val communitylist: MutableList<Infos>,
                       private val onClick: (Infos) -> Unit):
    RecyclerView.Adapter<CommunityViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        return CommunityViewHolder(parent.inflate(R.layout.info_item))
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        val community = communitylist[position]
        holder.bind(community,onClick)
    }

    override fun getItemCount(): Int =communitylist.size


}
class CommunityViewHolder(view: View) : RecyclerView.ViewHolder(view){


    fun bind(community: Infos, onClick: (Infos) -> Unit) {
        itemView.imageView.load(community.banner)
        itemView.textViewTitle.text=community.name
        itemView.setOnClickListener {
            onClick(community)
        }
    }
}





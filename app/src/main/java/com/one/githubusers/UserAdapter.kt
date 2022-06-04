package com.one.githubusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.one.githubusers.databinding.ItemUserBinding

class UserAdapter(val users: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(private val binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(user: User){
            with(binding){
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions().override(80,80))
                    .into(binding.imgAvatar)

                tvName.text = user.name
                tvCompany.text = user.company

                cvItemUser.setOnClickListener { onItemClickCallback?.onItemClicked(user)}
            }
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}
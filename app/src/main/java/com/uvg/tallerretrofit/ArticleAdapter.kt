package com.uvg.tallerretrofit

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uvg.tallerretrofit.databinding.ItemNewBinding
import com.squareup.picasso.Picasso

class ArticleAdapter(private val articles: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context)
        return ViewHolder(v.inflate(R.layout.item_new, p0, false))
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item:Article = articles[position]
        holder.bindItems(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemNewBinding.bind(itemView)
        @SuppressLint("SetTextIl8n")
        fun bindItems(item: Article) {
            Picasso.get().load(item.urlToImage).into(binding.imgArticle)
            binding.txtDescription.text = item.description
        }
    }
}
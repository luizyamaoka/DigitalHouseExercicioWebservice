package br.com.webservice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_produto.view.*

class ProdutoAdapter(
//    val produtosList : List<Produto>
) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    var produtosList: List<Produto> = listOf<Produto>()
    set(value) {
        if (value == null) return
        field = value
        notifyDataSetChanged()
    }

    class ProdutoViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvNome : TextView = view.tvNome
        val ivProduto : ImageView = view.ivProduto

        fun bindView(produto : Produto) {
            tvNome.text = produto.nome_prod
            Glide.with(view.context).asBitmap()
                .load("https://promoios.com.br/img/produtos/${produto.url}")
                .into(ivProduto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = produtosList.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtosList[position]
        holder.bindView(produto)
    }
}
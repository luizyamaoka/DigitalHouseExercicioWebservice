package br.com.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter : ProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ProdutoAdapter()
        rvProduto.adapter = adapter

        viewModel.aluno.observe(this, Observer {
            tvPrincipal.text = it.toString()
        })

        viewModel.alunosList.observe(this, Observer {
            tvPrincipalList.text = it.toString()
        })

        viewModel.produtosList.observe(this, Observer {
            adapter.produtosList = it
//            rvProduto.adapter = ProdutoAdapter(it)
        })

        viewModel.getAluno()
        viewModel.getAlunos()
        viewModel.getProdutos()
    }
}
package br.com.webservice

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val apiService = RetrofitInitializer().apiService()

    val aluno = MutableLiveData<Aluno>()
    val alunosList = MutableLiveData<List<Aluno>>()
    val produtosList = MutableLiveData<List<Produto>>()

    fun getAluno() {
        viewModelScope.launch {
            try {
                aluno.value = apiService.getSortAluno()
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }

    fun getAlunos() {
        viewModelScope.launch {
            try {
                alunosList.value = apiService.getAlunos()
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }

    fun getProdutos() {
        viewModelScope.launch {
            try {
                produtosList.value = apiService.getProdutos().produtos
                Log.i("MainViewModel", produtosList.value.toString())
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }
}
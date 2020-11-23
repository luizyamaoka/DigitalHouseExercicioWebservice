package br.com.webservice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Resultado(@SerializedName("produtos") @Expose var produtos: List<Produto>) {
}
package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ArrayAdapter

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo conteúdo de visualização
        setContentView(R.layout.activity_main)

        //acessando spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        spn_sexo.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("feminino", "masculino"))

        //acessando idade
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando button
        val btn_button = findViewById<Button>(R.id.btn_calcular)

        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        btn_button.setOnClickListener {

            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toInt()

            var resultado = 0
            resultado = if(sexo == "masculino"){
                65 - idade
            }else{
                60 - idade
            }

            //Atualiza a tela com o resultado necessário
            txt_resultado.text = "Faltam $resultado anos para você se aposentar."

        }


    }
}
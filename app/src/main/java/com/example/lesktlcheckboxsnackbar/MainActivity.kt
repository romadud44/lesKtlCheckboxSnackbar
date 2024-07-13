package com.example.lesktlcheckboxsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain: Toolbar

    private lateinit var inET: EditText
    private lateinit var outTV: TextView

    private lateinit var buttonSaveBTN: Button
    private lateinit var buttonClearBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Ввод и удаление данных"
        toolbarMain.subtitle = "версия 1.0"

        inET = findViewById(R.id.inET)
        outTV = findViewById(R.id.outTV)

        buttonSaveBTN = findViewById(R.id.buttonSaveBTN)
        buttonClearBTN = findViewById(R.id.buttonClearBTN)

        buttonSaveBTN.setOnClickListener {

                R.id.buttonSaveBTN
                if (inET.text.isNotEmpty()) {
                    outTV.text = inET.text
                } else
                {
                   Toast.makeText(this, "Данные не введены", Toast.LENGTH_LONG).show()
                }

        }
        buttonClearBTN.setOnClickListener(this)






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {

            Snackbar.make(
                v!!,                        // почему здесь не дает запустить без "!!"?
                "Очистить данные?",
                Snackbar.LENGTH_LONG
            )
                .setAction("Подтвердить") {
                    inET.text.clear()
                    outTV.text = ""
                    Snackbar.make(
                        v,
                        "Данные удалены",
                        Snackbar.LENGTH_LONG

                    ).show()
                }.show()

    }

}
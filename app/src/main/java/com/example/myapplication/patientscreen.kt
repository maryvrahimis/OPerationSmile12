package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.operationsmile.ui.theme.BgColor
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class patientscreen : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patientscreen)

        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.names_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy'at' HH:mm:ss z")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime
    }

    override fun onItemSelected(parent: AdapterView<*>? , view: View?, position: Int, id: Long) {
        val text = parent?.getItemIdAtPosition(position).toString()
        //Toast.makeText(getParent(), text, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }


}




package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class emailupload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emailupload)
        var button: Button
        var sendto: EditText
        var subject: EditText
        var body: EditText

        sendto = findViewById(R.id.editText1);
        subject = findViewById(R.id.editText2);
        body = findViewById(R.id.editText3);
        button = findViewById(R.id.LsoundsButton);

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val emailsend = sendto.text.toString()
                val emailsubject = subject.text.toString()
                val emailbody = body.text.toString()

                // define Intent object
                // with action attribute as ACTION_SEND
                val intent = Intent(Intent.ACTION_SEND)

                // add three fiels to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailsend))
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject)
                intent.putExtra(Intent.EXTRA_TEXT, emailbody)

                // set type of intent
                intent.type = "message/rfc822"

                // startActivity with intent with chooser
                // as Email client using createChooser function
                startActivity(
                    Intent
                        .createChooser(
                            intent,
                            "Choose an Email client :"
                        )
                )
            }
        })
    }
}
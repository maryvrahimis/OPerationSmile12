package com.example.operationsmile

import android.graphics.Matrix
import android.graphics.RectF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser
import com.example.operationsmile.Retrofit.IMyService
import com.example.operationsmile.Retrofit.RetroClient
import com.example.operationsmile.ui.theme.OperationSmileTheme
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import retrofit2.Retrofit


import androidx.core.content.ContextCompat;
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import com.google.android.material.dialog.MaterialDialogs
import com.rengwuxian.materialedittext.MaterialEditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.w3c.dom.Text

//import com.example.operationsmile.R.layout.activity_patientscreen

class MainActivity : AppCompatActivity() {

    lateinit var iMyService: IMyService
    internal var compositeDisposable = CompositeDisposable()


    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patientscreen)

        val retrofit = RetroClient.getInstance()
        iMyService = retrofit.create(IMyService::class.java)

        val button = findViewById(R.id.btn_login) as Button
        val email1 = findViewById(R.id.email_addr) as Text
        val password1 = findViewById(R.id.password_box) as Text
        val acountcreat = findViewById(R.id.txt_create_account) as TextView
        val name1 = findViewById(R.id.f_name) as Text

        button.setOnClickListener {
            loginUser(email1.toString(), password1.toString())
        }

        acountcreat.setOnClickListener{
            val itemView = LayoutInflater.from(this@MainActivity).inflate(R.layout.register_ui,null)

            MaterialStyledDialog.Builder(this@MainActivity).setIcon(R.drawable.ic_name).setTitle("REGISTRATION").setDescription("Please fill all the fields").setCustomView(itemView).setNegativeText("CANCEL").onNegative{dialog -> }.setPositiveText("REGISTER").onPositive(MaterialDialogs.SingleButtonCallback{ _,_ -> val email_addr:View = itemView.findViewById(R.id.email_addr) as MaterialEditText
                val f_name:View = itemView.findViewById(R.id.f_name) as MaterialEditText
                val password_box:View = itemView.findViewById(R.id.email_addr) as MaterialEditText
                if(TextUtils.isEmpty(email1.toString())) {
                    Toast.makeText(this@MainActivity, "Email can not be null or empty", Toast.LENGTH_SHORT).show()
                    return;
                }
            }
            )
            }


    }

    private fun loginUser(email: String, password: String) {

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this@MainActivity, "Email can not be null or empty", Toast.LENGTH_SHORT).show()
            return;
        }
        if(TextUtils.isEmpty(password)) {
            Toast.makeText(this@MainActivity, "Password can not be null or empty", Toast.LENGTH_SHORT).show()
            return;
        }
        compositeDisposable.add(iMyService.loginUser(email, password).subscribeOn(Schedulers.io())
            .observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe { result ->
            Toast.makeText(this@MainActivity,""+result,Toast.LENGTH_SHORT).show()

        })


    }


    @Composable
    fun SmileHome() {

    }
/* END
 *      OF
 *      Home Screen
 * */

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        OperationSmileTheme {
            SmileHome()
        }
    }
}

private fun MaterialStyledDialog.Builder.onPositive(callback: (MaterialStyledDialog, Any?) -> Unit) {

}

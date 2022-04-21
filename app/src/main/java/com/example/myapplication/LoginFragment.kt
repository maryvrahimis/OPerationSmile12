package com.example.myapplication


import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.FIND_VIEWS_WITH_TEXT
import android.widget.ImageView
import android.widget.TextView

import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.ActivityLoginBinding
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random
import org.apache.commons.codec.binary.Hex
import org.bson.types.ObjectId





import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast

import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


class LoginFragment: Fragment() {


    private var _binding: ActivityLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        lateinit var imageView: ImageView


        _binding = ActivityLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //try {
        //FRAGMENT LISTEN
        //FRAGMENT LISTEN
        super.onViewCreated(view, savedInstanceState)
//        lateinit var realm: Realm
//        //try {
//        //FRAGMENT LISTEN
//        //FRAGMENT LISTEN
//
//        realm = Realm.getDefaultInstance()
//        Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")



//        setFragmentResultListener("requestKey") { requestKey, bundle ->
//            // We use a String here, but any type that can be put in a Bundle is supported
//            val result = bundle.getBoolean("bundleKey")
//            if (result){
//                binding.completedLesson.isVisible = true
//                binding.notCompletedLesson.isVisible = false
//                //binding.totalPointsText.text = opa
//
//            }
//        }

//        binding.streakText.setText((days.toString() + " dias"))
//        binding.lessonsButton.setOnClickListener {
//
//            findNavController().navigate(R.id.action_Home_to_Lessons)
//
//        }
//
//        binding.storeButton.setOnClickListener {
//            findNavController().navigate(R.id.to_Third_fragment)
//        }
//        binding.homeToPatients.setOnClickListener {
//            findNavController().navigate(R.id.action_home_to_updated_patients_screen)
//        }
//        binding.reportsButton.setOnClickListener {
//            findNavController().navigate(R.id.go_to_reports)
//        }
        binding.LoginButton.setOnClickListener {
            //fun callfun(callbackfun: CallBackFun) {
                var email0 = binding.emailaddress.text.toString()
                var pass0 = binding.password.text.toString()

                // loginUser(email_addr.text.toString(), password_box.text.toString())
                // while (email0.isEmpty() == true && pass0.isEmpty() == true) {
                Log.v("THIS IS THE EMAIL", email0)
                Log.v("THIS IS THE PASSWORD", pass0)
            lateinit var realm: Realm
            //try {
            //FRAGMENT LISTEN
            //FRAGMENT LISTEN

            realm = Realm.getDefaultInstance()
            Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")
                if (email0.isEmpty() == false && pass0.isEmpty() == false) {
                    val task2 = realm.where(Login::class.java).equalTo("email", email0).findFirst()
//                    if (task2 != null) {
////                println("THIS IS A TEST ${task2.image}")
//                        // binding.textView6.text = "${task2.word}"
//                    }
                    //val imgUri: Uri = Uri.parse("android.resource://com.example.myapplication/bballbird.png")
                    //uri = Uri.parse("android.resource://your.package.here/drawable/image_name")

                    //val emailG = "${task2!!.email}"
                    val saltG = "${task2!!.salt}"
                    Log.v("this is the SALT", saltG)
                    val passG = "${task2!!.password}"
                    Log.v("this is the hashed data", passG)

                    var hash_data = checkHash(pass0, saltG)
                    Log.v("HASHED DATA", hash_data)
                    Log.v("PASSWORD", passG)
                    if (hash_data.equals(passG)) {
//                        Log.v("HASHED DATA",hash_data)
//                        Log.v("PASSWORD",passG)
                        findNavController().navigate(R.id.action_Login_to_Home)
                    }
                   // callbackfun.onSuccess()
                    realm.close()

                } else {
                    if (email0.isEmpty() == true || pass0.isEmpty() == true) {
                        if (email0.isEmpty() == true) {
                            email0 = binding.emailaddress.text.toString()
                            Log.v("please insert a passwor","PAS")
                        //    callbackfun.onFailure("please insert an email address")
                            // Toast.makeText(LoginFragment,"Please enter a email",Toast.LENGTH_SHORT).show()
                        } else if (pass0.isEmpty() == true) {
                            pass0 = binding.password.text.toString()
                            Log.v("please insert a passwor","PASSSSSSS")
                          //  callbackfun.onFailure("please insert a password")
                        }
                    }
                }
          //  }


        }


        binding.LogToReg.setOnClickListener {
            findNavController().navigate(R.id.action_Login_to_Registration)


        }
        //realm.close()





//
//        // THIS EXECUTES A WRITE TO THE DATABASE (LIKE IN MAIN ACTIVITY)
//        realm.executeTransaction { r: Realm ->
//            // Instantiate the class using the factory function.
//            val turtle = r.createObject(Lessons::class.java, ObjectId())
//            // Configure the instance.
//            turtle.word = "pollo"
//        }
//        // IT PULLS INFO FROM DATABASE AND PUTS IT INTO A VARIABLE
//        // THE VARIABLE IS THEN PRINTED TO SCREEN
//
//
//        val task2 = realm.where(Login::class.java).equalTo("word", "pan").findFirst()
//        if (task2 != null) {
//            println("THIS IS A TEST ${task2.email}")
//            // binding.textView6.text = "${task2.word}"
//        }
//        //val imgUri: Uri = Uri.parse("android.resource://com.example.myapplication/bballbird.png")
//        //uri = Uri.parse("android.resource://your.package.here/drawable/image_name")
//
//        val opa = "${task2!!.word}"
//        val opa3 = "${task2!!.word}"
//        Log.v("EXAMPLE", "Fetched Max: $task2")



    }
    fun createSignature( data: String, key: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(key.toByteArray(), "HmacSHA256")
        sha256Hmac.init(secretKey)

        return Hex.encodeHexString(sha256Hmac.doFinal(data.toByteArray()))
    }
    fun checkHash(userP: String,salt: String): String{
        val passwordData = createSignature(userP,salt)
        return passwordData
    }
    fun saltHashPass(userPass: String): String{
        var salt = (Random.nextBytes(16)).toString()
        var passwordData = createSignature(userPass, salt)
        return passwordData;
    }

//    fun insertEmail(): String {
//        val email = email_addr.text.toString()
//        return email;
//    }
//    fun insertPass(): String {
//        val pass = password_box.text.toString()
//        return pass;
//    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}


interface CallBackFun {
    fun onSuccess()

    fun onFailure(error: String)
}





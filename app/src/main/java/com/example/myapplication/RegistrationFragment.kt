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
import com.example.myapplication.databinding.ActivityRegisterBinding
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

import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.security.SecureRandom


class RegistrationFragment: Fragment() {
    private var _binding: ActivityRegisterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // lateinit var imageView: ImageView


        _binding = ActivityRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var realm2: Realm
        realm2 = Realm.getDefaultInstance()
        Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm2.path}")



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


        binding.buttonreg.setOnClickListener {
            var email1 = binding.emailreg.text.toString()
            var pass1 = binding.passwordreg.text.toString()
            var name1 = binding.namereg.text.toString()
            var pass2 = binding.passwordconf.text.toString()
            var confirmation = false



            var saltP = SaltRand()
            Log.v("THIS IS A TEST",saltP)
            var hashedP = saltHashPass(pass1,saltP)
            Log.v("THIS IS THE SALT",saltP)
            Log.v("THIS IS THE HASHPASS",hashedP)




            realm2.executeTransaction { r: Realm ->
                // Instantiate the class using the factory function.
                var task3 = r.createObject(Login::class.java, ObjectId())
                // Configure the instance.

                task3.name = name1
                task3.email = email1
                task3.salt = saltP
                task3.password = hashedP
            }


//            val emailG = "${task3!!.email}"
//            val saltG = "${task3!!.salt}"
//            val passG = "${task2!!.password}"
//
//            var hash_data = checkHash(pass0,saltG)
//            if(hash_data == passG) {
//                findNavController().navigate(R.id.action_Login_to_Home)
//            }
            realm2.close()
            findNavController().navigate(R.id.action_Registration_to_Login)



        }





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




    }



    private fun SaltRand(): String {
        val random = SecureRandom()
        val salt = ByteArray(6)
        random.nextBytes(salt)
        return salt.toString()

    }



    fun createSignature( data: String, key: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(key.toByteArray(), "HmacSHA256")
        sha256Hmac.init(secretKey)

        return Hex.encodeHexString(sha256Hmac.doFinal(data.toByteArray()))
    }
    //    fun checkHash(userP: String,salt: String): String{
//        val passwordData = createSignature(userP,salt)
//        return passwordData
//    }
    fun saltHashPass(userPass: String,salt: String): String{
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

//    override fun onDestroyView() {
//        super.onDestroyView()
//
//        _binding = null
//    }
}


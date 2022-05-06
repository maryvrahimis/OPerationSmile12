package com.example.myapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentClosetBinding
import com.example.myapplication.databinding.FragmentLessonsBinding
import io.realm.Realm

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ClosetFragment : Fragment() {

    private var _binding: FragmentClosetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClosetBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var realm: Realm
        //try {

        binding.closetToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.actoinClosetToHome)
        }
       // binding.imageView20.setImageDrawable(opa2)
      //  binding.scrollView3.
        var temp = 0
        var closetIt = binding.lin.iterator()
        for (l in arr){
            if(closetIt.hasNext()) {
                if (l.inCloset == true || l.stickerBirdId == currentStickerI) {
                    val bam = closetIt.next()
                    bam.setBackgroundResource(l.stickerBirdId)
                    bam.setOnClickListener {
                        currentStickerI = l.stickerBirdId
                        findNavController().navigate(R.id.actoinClosetToHome)
                    }
                }

                temp++
            }
        }





        }

        //for()







    override fun onDestroyView() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { r: Realm ->
            val save = realm.where(Patients::class.java).equalTo("name", "lee").findFirst()
            if (save != null) {

                save.points = points1
                save.currentStickerID = currentStickerI
                save.currentSticker = currentStickerAppVar
                for(i in arr){
                    if(i.inCloset == true){
                        closeyString = "${closeyString} ${i.birdWeaaringSticker}"

                    }

                }
                save.closetAsAString = closeyString
                realm.insertOrUpdate(save)
                // save.closetAsAString = closetString
            }

        }


        realm.close()
        super.onDestroyView()
        _binding = null
    }
}
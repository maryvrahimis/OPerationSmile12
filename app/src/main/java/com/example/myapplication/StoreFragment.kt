package com.example.myapplication


import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentReportsBinding
import com.example.myapplication.databinding.FragmentStoreBinding
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentLessonsBinding
import io.realm.Realm
import org.bson.types.ObjectId

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getInt("bundleKey")


        }
        binding.imageView11.setImageResource(currentSticker)
        binding.pointsView.text = "${points.toString()} Points"
        binding.toHomeButton.setOnClickListener {
            findNavController().navigate(R.id.store_to_home)
        }
        binding.toShoppingScreen.setOnClickListener {
            findNavController().navigate(R.id.actoinStoreToShopping)
        }
        binding.storeToCloset.setOnClickListener {
            findNavController().navigate(R.id.actoinStoreToCloset)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
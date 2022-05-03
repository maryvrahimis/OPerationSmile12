package com.example.myapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentStoreBinding

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
        binding.imageView11.setImageResource(currentStickerI)
        binding.pointsView.text = "${points1.toString()} Points"
        binding.toHomeButton.setOnClickListener {
            findNavController().navigate(R.id.store_to_home)
        }
        binding.toShoppingScreen.setOnClickListener {
            findNavController().navigate(R.id.action_StoreFragment_to_shoppingFragment)
        }
        binding.storeToCloset.setOnClickListener {
            findNavController().navigate(R.id.action_StoreFragment_to_closetFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
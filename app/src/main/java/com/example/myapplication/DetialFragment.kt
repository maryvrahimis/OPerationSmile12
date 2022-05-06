package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentDetialBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetialFragment : Fragment() {
    private var _binding: FragmentDetialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetialBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported

            val res = bundle.getInt("bundleKey")
            binding.imageView3.setBackgroundResource(res)
           // val temp = 0
            for(i in arr){
                if(i.stickerBirdId == res ){
                    binding.name.text = i.stickerName
                    binding.detailText1.text = i.stickerPrice.toString()
                    binding.detailBuyButton.setOnClickListener{
                        closetStringsArrList.add(i)
                        i.available = false
                        binding.detailBuyButton.isVisible = false
                        points1 = points1 - i.stickerPrice
                        findNavController().navigate(R.id.action_detialFragment_to_shoppingFragment)
                    }

                }
            }


        }

    }
}
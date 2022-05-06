package com.example.myapplication


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentShoppingScreenBinding
import com.example.operationsmile.ui.theme.BgColor


class ShoppingFragment : Fragment() {

    private var _binding: FragmentShoppingScreenBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShoppingScreenBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.points.text = "Puntos: ${points1}"
        val toli = binding.shopLayout.childCount
        for (i in 0..toli-1) {
            if(arr[i].stickerPrice <= points1 && arr[i].available == true && arr[i].inCloset == false){
                binding.shopLayout[i].setBackgroundResource(arr[i].stickerId)
                binding.shopLayout[i].setOnClickListener{
                    res = arr[i].stickerBirdId
                  //  setFragmentResult("requestKey", bundleOf("bundleKey" to res))
                    findNavController().navigate(R.id.action_shoppingFragment_to_detialFragment)

                }
            }
            if(arr[i].available == false){
                binding.shopLayout[i].setBackgroundColor(Color.BLUE)
                

            }
        }





        binding.shoppingScreenToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.actoinShoppingToHome)
        }
        binding.shoppingtoClosetButton.setOnClickListener {
            findNavController().navigate(R.id.shoppintToCloset)
        }



    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun addNewView() {
        // this method inflates the single item layout
        // inside the parent linear layout
       // val inflater = LayoutInflater.from(this).inflate(R.layout.row_add_language, null)


    }
    fun getDrawableByFileName(context: Context, fileName: String?): Drawable? {
        return ContextCompat.getDrawable(
            context,
            context.resources.getIdentifier(fileName, "drawable", context.packageName)
        )
    }




}

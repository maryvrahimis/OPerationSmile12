package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentShoppingScreenBinding
import com.example.myapplication.databinding.FragmentStoreBinding

class ShoppingFragment : Fragment() {

        private var _binding: FragmentShoppingScreenBinding? = null
        val stickies = arrayOf(
            StickerBundle(_id = R.drawable.hat, price = 20 , birdWeaaringSticker = R.drawable.hat),
            StickerBundle(R.drawable.flag, 10, R.drawable.flagbird),
            StickerBundle(R.drawable.sunglasses, 15 ,R.drawable.sunglassesbird) ,
            StickerBundle(R.drawable.tshirt,20 ,R.drawable.tshirtbird ),
            StickerBundle(R.drawable.sneakers,30,R.drawable.sneakersbird),
            StickerBundle(R.drawable.pinkboots,25,R.drawable.pinkbootsbird),
            StickerBundle( R.drawable.santhat, 30, R.drawable.santahatbird),
            StickerBundle(R.drawable.easter,45,R.drawable.easterbird),
            StickerBundle(R.drawable.halloween,45,R.drawable.bballbird),
            StickerBundle(R.drawable.bball,50,R.drawable.halloweenbird)
        )
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

            binding.shoppingScreenToHomeButton.setOnClickListener {
                findNavController().navigate(R.id.actoinShoppingToHome)
            }
            binding.shoppingtoClosetButton.setOnClickListener {
                findNavController().navigate(R.id.shoppintToCloset)
            }

            binding.sneakersButton.setOnClickListener {
                binding.detailSneaker.visibility = CardView.VISIBLE

            }
            binding.exitSneakerDetail.setOnClickListener {
                binding.detailSneaker.visibility = CardView.GONE
            }

            binding.santahatButton.setOnClickListener {
                binding.detailSanta.visibility = CardView.VISIBLE

            }
            binding.exitSantahatButton.setOnClickListener {
                binding.detailSanta.visibility = CardView.GONE

            }
            binding.bballButton.setOnClickListener{
                binding.bballdetail.visibility = CardView.VISIBLE
            }
            binding.exitbballdetail.setOnClickListener{
                binding.bballdetail.visibility = CardView.GONE
            }
            binding.easterButton.setOnClickListener{
                binding.easterDetail.visibility = CardView.VISIBLE
            }
            binding.exitEasterDetail.setOnClickListener{
                binding.easterDetail.visibility = CardView.GONE
            }
            binding.flagButton.setOnClickListener{
                binding.flagDetail.visibility = CardView.VISIBLE
            }
            binding.exitFlagDetail.setOnClickListener{
                binding.flagDetail.visibility = CardView.GONE
            }
            binding.tshirtButton.setOnClickListener{
                binding.detailTshirt.visibility = CardView.VISIBLE
            }
            binding.tishirtExitButton.setOnClickListener{
                binding.detailTshirt.visibility = CardView.GONE
            }
            binding.halloweenButton.setOnClickListener{
                binding.halloweenDetail.visibility = CardView.VISIBLE
            }
            binding.halloweenExitButton.setOnClickListener{
                binding.halloweenDetail.visibility = CardView.GONE
            }
            binding.sunglassesButton.setOnClickListener{
                binding.detailSunglasses.visibility = CardView.VISIBLE
            }
            binding.exitSunglassesDetail.setOnClickListener {
                binding.detailSunglasses.visibility = CardView.GONE
            }
            binding.pinkbootsButton.setOnClickListener {
                binding.detailPinkBoots.visibility = CardView.VISIBLE
            }
            binding.pinkbootsExit.setOnClickListener {
                binding.detailPinkBoots.visibility = CardView.GONE
            }
            binding.hatButton.setOnClickListener {
                binding.hatDetail.visibility = CardView.VISIBLE
            }
            binding.exitHatButton.setOnClickListener {
                binding.hatDetail.visibility = CardView.GONE
            }

        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }


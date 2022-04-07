package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.view.isGone
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
                if(binding.detailSneaker.isVisible){
                    binding.shopScroll.isGone = true
                }
                binding.buySneakers.setOnClickListener {

                }


            }
            binding.exitSneakerDetail.setOnClickListener {
                binding.detailSneaker.visibility = CardView.GONE
                if(!binding.detailSneaker.isVisible){
                    binding.shopScroll.isGone = false
                }
            }

            binding.santahatButton.setOnClickListener {
                binding.detailSanta.visibility = CardView.VISIBLE
                if(binding.detailSanta.isVisible){
                    binding.shopScroll.isGone = true
                }

            }
            binding.exitSantahatButton.setOnClickListener {
                binding.detailSanta.visibility = CardView.GONE
                if(!binding.detailSanta.isVisible){
                    binding.shopScroll.isGone = false
                }

            }
            binding.bballButton.setOnClickListener{
                binding.bballdetail.visibility = CardView.VISIBLE
                if(binding.bballdetail.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.exitbballdetail.setOnClickListener{
                binding.bballdetail.visibility = CardView.GONE
                if(!binding.bballdetail.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.easterButton.setOnClickListener{
                binding.easterDetail.visibility = CardView.VISIBLE
                if(binding.easterDetail.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.exitEasterDetail.setOnClickListener{
                binding.easterDetail.visibility = CardView.GONE
                if(!binding.easterDetail.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.flagButton.setOnClickListener{
                binding.flagDetail.visibility = CardView.VISIBLE
                if(binding.flagDetail.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.exitFlagDetail.setOnClickListener{
                binding.flagDetail.visibility = CardView.GONE
                if(!binding.flagDetail.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.tshirtButton.setOnClickListener{
                binding.detailTshirt.visibility = CardView.VISIBLE
                if(binding.detailTshirt.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.tishirtExitButton.setOnClickListener{
                binding.detailTshirt.visibility = CardView.GONE
                if(!binding.detailTshirt.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.halloweenButton.setOnClickListener{
                binding.halloweenDetail.visibility = CardView.VISIBLE
                if(binding.halloweenDetail.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.halloweenExitButton.setOnClickListener{
                binding.halloweenDetail.visibility = CardView.GONE
                if(!binding.halloweenDetail.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.sunglassesButton.setOnClickListener{
                binding.detailSunglasses.visibility = CardView.VISIBLE
                if(binding.detailSunglasses.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.exitSunglassesDetail.setOnClickListener {
                binding.detailSunglasses.visibility = CardView.GONE
                if(!binding.detailSunglasses.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.pinkbootsButton.setOnClickListener {
                binding.detailPinkBoots.visibility = CardView.VISIBLE
                if(binding.detailPinkBoots.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.pinkbootsExit.setOnClickListener {
                binding.detailPinkBoots.visibility = CardView.GONE
                if(!binding.detailPinkBoots.isVisible){
                    binding.shopScroll.isGone = false
                }
            }
            binding.hatButton.setOnClickListener {
                binding.hatDetail.visibility = CardView.VISIBLE
                if(binding.hatDetail.isVisible){
                    binding.shopScroll.isGone = true
                }
            }
            binding.exitHatButton.setOnClickListener {
                binding.hatDetail.visibility = CardView.GONE
                if(!binding.hatDetail.isVisible){
                    binding.shopScroll.isGone = false
                }
            }

        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }


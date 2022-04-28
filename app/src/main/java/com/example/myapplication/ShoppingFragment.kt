package com.example.myapplication


import android.content.ContentValues
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentShoppingScreenBinding
import io.realm.Realm
import org.bson.types.ObjectId


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
        binding.points.text = "Puntos: ${points}"




        var res: ArrayList<StickerBundle> = ArrayList<StickerBundle>()
        var arr: Array<StickerBundle> = arrayOf(StickerBundle("tshirt",  15,"tshirtbird", stickerId = R.drawable.tshirt, stickerBirdId = R.drawable.tshirtbird, R.id.detailTshirt ),
            StickerBundle("flag",  20,"flagbird", R.drawable.flag, R.drawable.flagbird, R.id.flagDetail),
            StickerBundle("hat",  30,"hatbird", R.drawable.hat, R.drawable.hatbird, R.id.hatDetail),
            StickerBundle("sunglasses",  15,"sunglasses", R.drawable.sunglasses, R.drawable.sunglassesbird, R.id.detailSunglasses),
            StickerBundle("sneakers", 30,"sneakersbird", R.drawable.sneakers, R.drawable.sneakersbird, R.id.detailSneaker),
            StickerBundle("pinkboots",  20,"pinkbootsbird", R.drawable.pinkboots, R.drawable.pinkbootsbird, R.id.detailPinkBoots),
            StickerBundle("bball",  50,"bballbird", R.drawable.bball, R.drawable.bballbird, R.id.bballdetail),
            StickerBundle("easter",  50,"easterbird", R.drawable.easter, R.drawable.easterbird, R.id.easterDetail),
            StickerBundle("halloween",  50,"halloweenbird", R.drawable.halloween, R.drawable.halloweenbird, R.id.halloweenDetail),
            StickerBundle("santahat",  10,"santahatbird", R.drawable.santahat, R.drawable.santahatbird, R.id.detailSanta)
        )
       val arrIt = arr.iterator()
        println(res.toString())
        // val help: Sequence<ImageView> = binding.shopLayout.

        val toli = binding.shopLayout.childCount
        val chichi = binding.shopLayout.children
        val track = 0
        for (i in 0..toli-1) {
            if(arr[i].stickerPrice <= points){
                binding.shopLayout[i].setBackgroundResource(arr[i].stickerId)
                binding.shopLayout[i].setOnClickListener{
                val res = arr[i].stickerBirdId
                    setFragmentResult("requestKey", bundleOf("bundleKey" to res))
                    findNavController().navigate(R.id.action_to_detail_screen)

                }
            }
        }

        var arrayIdk: ArrayList<StickerBundle> = arrayListOf()
        //var views: Array<ImageButton?> = arrayOfNulls<ImageButton>(5)
        val chilly = binding.shopLayout.childCount




        /*
        lateinit var realm: Realm
        realm = Realm.getDefaultInstance()
        realm.executeTransaction { r: Realm ->
            // Instantiate the class using the factory function.
            val turtle = r.createObject(Stickers::class.java, ObjectId())
            // Configure the instance.
            turtle.stickerName = "pinkboots"
            turtle.stickerPrice = 20
            turtle.birdWeaaringSticker = "pinkbootsbird"
            val bimbo = r.createObject(Stickers::class.java, ObjectId())
            bimbo.stickerName = "sunglasses"
            bimbo.stickerPrice = 15
            bimbo.birdWeaaringSticker = "sunglassesbird"

            val testing = r.createObject(Stickers::class.java, ObjectId())
            testing.stickerName = "hat"
            testing.stickerPrice = 30
            testing.birdWeaaringSticker ="hatbird"

            val beep = r.createObject(Stickers::class.java, ObjectId())
            beep.stickerName = "flag"
            beep.stickerPrice = 10
            beep.birdWeaaringSticker ="flagbird"
            val bop = r.createObject(Stickers::class.java, ObjectId())
            bop.stickerName = "bball"
            bop.stickerPrice = 45
            bop.birdWeaaringSticker ="bballbird"
            val boooop = r.createObject(Stickers::class.java, ObjectId())
            boooop.stickerName = "halloween"
            boooop.stickerPrice = 50
            boooop.birdWeaaringSticker ="halloweenbird"

        }

         */
        //  val taskOne = realm.where(Stickers::class.java).equalTo("stickerName", "pinkboots").findFirst()
      //  val taskTwo = realm.where(Stickers::class.java).lessThan("stickerPrice", 40 ).findAll()

        // binding..setImageDrawable(resID)


       // println(arr.get(2).toString())

       // list.forEach{ binding.linnyScrol }
     //   taskTwo.forEach { taskTwo -> taskTwo.stickerName?.let { list.add(it) } }
     //   val imgViewsval: Array<ImageButton> = Array<ImageButton>(7) {binding.sneakersButton; binding.bballButton; binding.flagButton; binding.halloweenButton; binding.hatButton; binding.easterButton; binding.pinkbootsButton}



      //  binding.linnyScroll.forEach { ImageButton -> context?.let { getDrawableByFileName(it, list.get()) } }

       // realm.close()


        //Log.v(ContentValues.TAG, "Successfully opened a realm at: ${realm.path}")

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

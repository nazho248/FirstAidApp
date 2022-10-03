package com.project.firstaid.fragments_main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.project.firstaid.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HomeFragment : Fragment() {

    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("drawable://"+R.drawable.logo_ini))
        list.add(CarouselItem("drawable://"+R.drawable.logo_ini))
        carousel.addData(list)*/

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val carousel: ImageCarousel = view.findViewById(R.id.carousel)

        list.add(
            CarouselItem(
                imageDrawable = R.drawable.citywall,
                caption = "Bienvenido a First Aid App"
            )
        )

        list.add(
            CarouselItem(
                imageDrawable = R.drawable.tunnelwall,
                caption = "Guia de Primeros Auxilios"
            )
        )

        list.add(
            CarouselItem(
                imageDrawable = R.drawable.catwall,
                caption = "Lorem Ipsum"
            )
        )

        carousel.autoPlay = true
        carousel.autoPlayDelay = 5000 // Milliseconds



        carousel.setData(list)


        val imagenPTB = view.findViewById<LinearLayout>(R.id.imagenPTB)
        imagenPTB.setOnClickListener {
            var intent = Intent(context, PautasBasicas::class.java)
            startActivity(intent)
        }

        val card_view_BPA = view.findViewById<LinearLayout>(R.id.card_view_Botiquin)
        card_view_BPA.setOnClickListener {
            var intent2 = Intent(context, BotiquinPAux::class.java)
            startActivity(intent2)
        }

        val card_view_Botiquin = view.findViewById<LinearLayout>(R.id.card_view_tecnicas_basicas)
        card_view_Botiquin.setOnClickListener {
            var intent = Intent(context, PautasBasicas::class.java)
            startActivity(intent)
        }





        return view
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = "First Aid App"
    }


}
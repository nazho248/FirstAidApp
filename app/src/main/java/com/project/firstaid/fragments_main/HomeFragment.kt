package com.project.firstaid.fragments_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.firstaid.MainActivity
import com.project.firstaid.R
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class Home2Fragment : Fragment() {

    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("drawable://"+R.drawable.logo_ini))
        list.add(CarouselItem("drawable://"+R.drawable.logo_ini))
        carousel.addData(list)*/

    }



/*    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

                // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }*/

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


        /*      carousel.addData(list)*/

        return view
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).supportActionBar?.title = "First Aid App"
    }


}
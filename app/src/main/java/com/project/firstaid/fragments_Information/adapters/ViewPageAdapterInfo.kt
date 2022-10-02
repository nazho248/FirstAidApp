package com.project.firstaid.fragments_Information.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class ViewPageAdapterInfo(supportFragmentManager: FragmentManager):
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTittleList = ArrayList<String>()



    //obtener la posicion de la lista
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    //obtener la cantidad de datos de la lista
    override fun getCount(): Int {
        return mFragmentList.size
    }

    //obtener el titulo de la lista
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTittleList[position]
    }


    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTittleList.add(title)
    }

}
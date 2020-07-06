package com.example.fastfood.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fastfood.MenuRecycleFragment.FragmentMenu
import com.example.fastfood.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment: Fragment(R.layout.home_fragment)  {
    companion object{
        const val TYPE_ID ="typeId"
        const val DRINK = 1
        const val PIZZA = 2
        const val LAVASH = 3
        const val BURGER = 4
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = FragmentMenu()
        val bundle = Bundle()
        bundle.putInt(TYPE_ID, DRINK)
        fragment.arguments = bundle
        childFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment ).commit()
        btnDrink.setImageResource(R.drawable.drink)
        btnBurger.setImageResource(R.drawable.burgerfocused)
        btnLavash.setImageResource(R.drawable.lavashfocused)
        btnPizza.setImageResource(R.drawable.pizzafocused)


        btnDrink.setOnClickListener {
            btnDrink.setImageResource(R.drawable.drink)
            btnBurger.setImageResource(R.drawable.burgerfocused)
            btnLavash.setImageResource(R.drawable.lavashfocused)
            btnPizza.setImageResource(R.drawable.pizzafocused)
            val mFragment = FragmentMenu()
            val mBundle = Bundle()
            mBundle.putInt(TYPE_ID, DRINK)
            mFragment.arguments = mBundle
            childFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment ).commit()

        }
        btnPizza.setOnClickListener {
            btnDrink.setImageResource(R.drawable.drinkfocused)
            btnBurger.setImageResource(R.drawable.burgerfocused)
            btnLavash.setImageResource(R.drawable.lavashfocused)
            btnPizza.setImageResource(R.drawable.pizza)
            val mFragment = FragmentMenu()
            val mBundle = Bundle()
            mBundle.putInt(TYPE_ID, PIZZA)
            mFragment.arguments = mBundle
            childFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment ).commit()

        }
        btnLavash.setOnClickListener {
            btnDrink.setImageResource(R.drawable.drinkfocused)
            btnBurger.setImageResource(R.drawable.burgerfocused)
            btnLavash.setImageResource(R.drawable.lavash)
            btnPizza.setImageResource(R.drawable.pizzafocused)
            val mFragment = FragmentMenu()
            val mBundle = Bundle()
            mBundle.putInt(TYPE_ID, LAVASH)
            mFragment.arguments = mBundle
            childFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment ).commit()

        }
        btnBurger.setOnClickListener {
            btnDrink.setImageResource(R.drawable.drinkfocused)
            btnBurger.setImageResource(R.drawable.burger)
            btnLavash.setImageResource(R.drawable.lavashfocused)
            btnPizza.setImageResource(R.drawable.pizzafocused)
            val mFragment = FragmentMenu()
            val mBundle = Bundle()
            mBundle.putInt(TYPE_ID, BURGER)
            mFragment.arguments = mBundle
            childFragmentManager.beginTransaction().replace(R.id.fragment_container, mFragment ).commit()

        }

    }

}
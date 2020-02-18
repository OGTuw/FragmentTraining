package com.example.fragmenttraining

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.mimikyu.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTitle = FragmentTitle()
        val fragmentButton = FragmentButton()

//        val container = findViewById<FrameLayout>(R.id.frame_fragment_container)
//        val button = findViewById<FrameLayout>(R.id.frame_button_container)

        supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container, fragmentTitle).commit()
        supportFragmentManager.beginTransaction().replace(R.id.frame_button_container, fragmentButton).commit()

    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        val id = data?.getSerializableExtra("buttonId") as? ButtonId
        val fragmentMimikyu = FragmentMimikyu()
        val fragmentDragovish = FragmentDragovish()
        val fragmentHatterene = FragmentHatterene()

        when(id){
            ButtonId.Mimikyu -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentMimikyu).commit()
            ButtonId.Dragovish -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentDragovish).commit()
            ButtonId.Hatterene -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentHatterene).commit()
            null -> TODO()
        }

    }
}

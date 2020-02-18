package com.example.fragmenttraining

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.mimikyu.*

class MainActivity : AppCompatActivity() {

    // Activityが作られる場所。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragmentのクラスをインスタンス化。
        val fragmentTitle = FragmentTitle()
        val fragmentButton = FragmentButton()

        // supportFragmentManager.beginTransaction() はおまじない。
        // replaceは置き換え。第一引数の場所に第二引数のFragmentをセットする。
        // commitもおまじない。
        supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container, fragmentTitle).commit()
        supportFragmentManager.beginTransaction().replace(R.id.frame_button_container, fragmentButton).commit()

    }

    // FragmentButtonクラスから押されたボタンの情報なんかをもらう。
    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        val id = data?.getSerializableExtra("buttonId") as? ButtonId

        // Fragmentクラスのインスタンス化。
        val fragmentMimikyu = FragmentMimikyu()
        val fragmentDragovish = FragmentDragovish()
        val fragmentHatterene = FragmentHatterene()

        when(id){
            // ButtonIdに応じてFragmentの入れ替え
            ButtonId.Mimikyu -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentMimikyu).commit()
            ButtonId.Dragovish -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentDragovish).commit()
            ButtonId.Hatterene -> supportFragmentManager.beginTransaction().replace(R.id.frame_fragment_container,fragmentHatterene).commit()
            null -> TODO()
        }

    }
}

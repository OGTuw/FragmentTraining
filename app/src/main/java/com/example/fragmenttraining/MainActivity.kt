package com.example.fragmenttraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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

        // dataのnullチェック
        if (data == null) return
        // 以降dataはnonnullであることが保証される

        // キャストできないなら何もせずにreturn
        val id = data.getSerializableExtra(FragmentButton.PARAM_BUTTON_ID) as? ButtonId ?: return

        // ButtonIdに応じて必要なFragmentクラスのインスタンス化。
        val fragment = when (id) {
            ButtonId.Mimikyu -> FragmentMimikyu()
            ButtonId.Dragovish -> FragmentDragovish()
            ButtonId.Hatterene -> FragmentHatterene()
        }

        // Fragmentの反映
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_fragment_container, fragment)
            .commit()
    }
}

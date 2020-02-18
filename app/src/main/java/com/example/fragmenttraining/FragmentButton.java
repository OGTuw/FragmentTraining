package com.example.fragmenttraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentButton extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // R.layout.Fragment(xml)のファイル名
        return inflater.inflate(R.layout.button, null);

    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ボタンを取得。
        ImageButton btnMimikyu = getView().findViewById(R.id.button_mimikyu);
        ImageButton btnDragovish = getView().findViewById(R.id.button_doragovish);
        ImageButton btnHatterene = getView().findViewById(R.id.button_hatterene);

        // ボタンイベントを作る。
        // Intentクラスの変数にbuttonIdとしてそれぞれのボタンをセット。
        // それをActivityのonActivityReeterに運ぶ。
        btnMimikyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId",ButtonId.Mimikyu );
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });

        btnDragovish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId",ButtonId.Dragovish );
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });

        btnHatterene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId",ButtonId.Hatterene );
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

}

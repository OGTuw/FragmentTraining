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
import androidx.fragment.app.FragmentActivity;

import org.jetbrains.annotations.NotNull;

public class ButtonHolderFragment extends Fragment {

    // bundleとかで渡すパラメータ名は定数化しておく
    public static final String PARAM_BUTTON_ID = "buttonId";


    // =============================================================================================
    //
    // Lifecycle
    //
    // =============================================================================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        // R.layout.Fragment(xml)のファイル名
        return inflater.inflate(R.layout.fragment_button_holder, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        setupButtonPattern1(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    // =============================================================================================
    //
    // Setup
    //
    // =============================================================================================
    private void setupButtonOriginal(View view) {
        // ボタンを取得。
        ImageButton btnMimikyu = view.findViewById(R.id.button_mimikyu);
        ImageButton btnDragovish = view.findViewById(R.id.button_doragovish);
        ImageButton btnHatterene = view.findViewById(R.id.button_hatterene);

        // ボタンイベントを作る。
        // Intentクラスの変数にbuttonIdとしてそれぞれのボタンをセット。
        // それをActivityのonActivityReeterに運ぶ。
        btnMimikyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId", ButtonId.Mimikyu);
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });

        btnDragovish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId", ButtonId.Dragovish);
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });

        btnHatterene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("buttonId", ButtonId.Hatterene);
                getActivity().onActivityReenter(Activity.RESULT_OK, data);
            }
        });
    }


    // =============================================================================================
    //
    // パターン１
    //
    // =============================================================================================
    private void setupButtonPattern1(View view) {
        // 共通のクリックリスナーを作る
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonId buttonId;
                switch (v.getId()) {
                    case R.id.button_mimikyu:
                        buttonId = ButtonId.Mimikyu;
                        break;
                    case R.id.button_doragovish:
                        buttonId = ButtonId.Dragovish;
                        break;
                    case R.id.button_hatterene:
                        buttonId = ButtonId.Hatterene;
                        break;
                    default:
                        return;
                }

                Intent data = new Intent();
                data.putExtra(PARAM_BUTTON_ID, buttonId);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.onActivityReenter(Activity.RESULT_OK, data);
                }
            }
        };

        // リスナーをそれぞれ登録
        view.findViewById(R.id.button_mimikyu).setOnClickListener(clickListener);
        view.findViewById(R.id.button_doragovish).setOnClickListener(clickListener);
        view.findViewById(R.id.button_hatterene).setOnClickListener(clickListener);
    }


    // =============================================================================================
    //
    // パターン２
    //
    // =============================================================================================
    private void setupButtonPattern2(View view) {
        view.findViewById(R.id.button_mimikyu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityReenter(ButtonId.Mimikyu);
            }
        });

        view.findViewById(R.id.button_doragovish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityReenter(ButtonId.Dragovish);
            }
        });

        view.findViewById(R.id.button_hatterene).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityReenter(ButtonId.Hatterene);
            }
        });
    }

    // 共通の処理はメソッド化しておいて、異なる部分だけ引数で受け取る
    private void activityReenter(ButtonId buttonId) {
        Intent data = new Intent();
        data.putExtra(PARAM_BUTTON_ID, buttonId);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onActivityReenter(Activity.RESULT_OK, data);
        }
    }

}

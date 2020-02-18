package com.example.fragmenttraining;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class FragmentHatterene extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // R.layout.Fragment(xml)のファイル名
        return inflater.inflate(R.layout.hatterene, null);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // FragmentにあるImageViewを取得。
        // FragmentクラスではR.Id.〜は使えないので、view.〜って書く。
        ImageView img = view.findViewById(R.id.imgHatterene);
        // 画像をいい感じにしてくれるGlide様。
        // withの引数は確定でgetContext()。
        // loadの引数は乗っけたい画像をR(res).drawable.画像名
        Glide.with(getContext()).load(R.drawable.img_9080).into(img);
    }
}

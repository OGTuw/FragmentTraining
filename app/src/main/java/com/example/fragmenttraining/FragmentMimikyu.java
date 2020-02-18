package com.example.fragmenttraining;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class FragmentMimikyu extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // R.layout.Fragment(xml)のファイル名
        return inflater.inflate(R.layout.mimikyu, null);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // FragmentにあるImageViewを取得。
        // FragmentクラスではR.Id.〜は使えないので、view.〜って書く。
        ImageView img = view.findViewById(R.id.imgMimikyu);
        // 画像をいい感じにしてくれるGlide様。
        // withの引数は確定でgetContext()。
        // loadの引数は乗っけたい画像をR(res).drawable.画像名
        Glide.with(getContext()).load(R.drawable.img_9078).into(img);

        // Glide様を使うときは、Gradleスクリプト>build.gradle(モジュール：app) に
        // implementation 'com.github.bumptech.glide:glide:4.4.0' を貼り付けて、
        // app > manifests > AndroidManifest.xmlに
        // <uses-permission android:name="android.permission.INTERNET" /> を
        // 貼り付けとかなきゃいけない。
    }
}

package com.example.android_ppe.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_ppe.R;

/**
 * Classe Logo_Animation.
 * @author : Julien. SEUX.
 * created on  26/01/2021.
 * modified on 10/02/2021.
 * Classe permettant l'annimation au lancement de l'application.
 */

public class Logo_Animation extends AppCompatActivity {

    Animation topAnim;
    ImageView logogsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo__animation);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logogsb = findViewById(R.id.logogsb);
        logogsb.setAnimation(topAnim);
        startActivity();
    }

    public void startActivity (){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        };
        new Handler().postDelayed(runnable, 1500);
    }
}
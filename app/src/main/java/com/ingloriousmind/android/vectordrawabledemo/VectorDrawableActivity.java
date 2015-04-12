package com.ingloriousmind.android.vectordrawabledemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * vector drawable demo activity
 *
 * @author lavong.soysavanh
 */
public class VectorDrawableActivity extends Activity {

    private ImageView vectorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawable);
        vectorImage = (ImageView) findViewById(R.id.activity_vector_drawable_image);
        vectorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) vectorImage.getDrawable()).start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vector_drawable, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AnimatorSet set;
        Object target;
        switch (item.getItemId()) {
            case R.id.action_rotate:
                set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.rotate360);
                target = vectorImage;
                break;
            case R.id.action_scale_down:
                set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.scaledown50);
                target = vectorImage;
                break;
            case R.id.action_scale_up:
                set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.scaleup100);
                target = vectorImage;
                break;
            case R.id.action_morph_pentagon:
                // apparently not supported
                set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.morph_star2pentagon);
                target = vectorImage;
                break;
            case R.id.action_morph_star:
                // apparently not supported
                set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.morph_pentagon2star);
                target = ((AnimatedVectorDrawable) vectorImage.getDrawable());
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        set.setTarget(target);
        set.start();
        return true;
    }
}

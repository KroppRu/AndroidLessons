package ru.startandroid.lesson020simpleanimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    final int MENU_ALPHA_ID = 1;
    final int MENU_ROTATE_ID = 2;
    final int MENU_SCALE_ID = 3;
    final int MENU_TRANS_ID = 4;
    final int MENU_COMBO_ID = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        registerForContextMenu(tv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,MENU_ALPHA_ID,1, R.string.alpha);
        menu.add(0,MENU_ROTATE_ID,2, R.string.rotate);
        menu.add(0,MENU_SCALE_ID,2, R.string.scale);
        menu.add(0,MENU_TRANS_ID,2, R.string.trans);
        menu.add(0,MENU_COMBO_ID,2, R.string.combo);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation currentAnimation = null;
        switch (item.getItemId()){
            case MENU_ALPHA_ID:
                currentAnimation = AnimationUtils.loadAnimation(this,R.anim.little_alpha);
                break;
            case MENU_ROTATE_ID:
                currentAnimation = AnimationUtils.loadAnimation(this,R.anim.little_rotation);
                break;
            case MENU_SCALE_ID:
                currentAnimation = AnimationUtils.loadAnimation(this,R.anim.little_scale);
                break;
            case MENU_TRANS_ID:
                currentAnimation = AnimationUtils.loadAnimation(this,R.anim.little_trance);
                break;
            case MENU_COMBO_ID:
                currentAnimation = AnimationUtils.loadAnimation(this,R.anim.little_combo);
                break;
        }
       // tv.setAnimation(currentAnimation);
        tv.startAnimation(currentAnimation);
        return super.onContextItemSelected(item);
    }
}
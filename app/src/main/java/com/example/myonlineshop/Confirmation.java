package com.example.myonlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.google.android.material.button.MaterialButton;

public class Confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        ImageView avatar = (ImageView) findViewById(R.id.userAvatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Gallery.this, "clicked", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(Confirmation.this, avatar);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        //Toast.makeText(Gallery.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        if(menuItem.getTitle().toString().equals("Logout")) {
                            Intent intent = new Intent(Confirmation.this, MainActivity.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });

        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Confirmation.this, ThankYou.class);
                startActivity(intent);

            }
        });
    }
}
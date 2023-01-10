package com.example.myonlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Bundle bundle = getIntent().getExtras();
        String currUser = bundle.getString("currUser");
        //Toast.makeText(Gallery.this, currUser, Toast.LENGTH_SHORT).show();

        TextView username = (TextView) findViewById(R.id.hello);
        username.setText("Hello, " + currUser);

        ImageView avatar = (ImageView) findViewById(R.id.userAvatar);

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Gallery.this, "clicked", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(Gallery.this, avatar);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        //Toast.makeText(Gallery.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        if(menuItem.getTitle().toString().equals("Logout")) {
                            Intent intent = new Intent(Gallery.this, MainActivity.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });


        TextView cartAmount = (TextView) findViewById(R.id.cartAmount);
        double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
        //Toast.makeText(Gallery.this, "cartAmountDouble: " + cartAmountDouble, Toast.LENGTH_SHORT).show();

        /******* Prod1 *******/
        ImageView addProd1 = (ImageView) findViewById(R.id.addProd1);
        TextView prod1 = (TextView) findViewById(R.id.prod1);
        double prod1Double = Double.parseDouble(prod1.getText().toString().substring(1));
        addProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Gallery.this, "Price: " + prod1.getText(), Toast.LENGTH_SHORT).show();
                cartAmount.setText(prod1.getText());
            }
        });

        /******* Prod2 *******/
        ImageView addProd2 = (ImageView) findViewById(R.id.addProd2);
        TextView prod2 = (TextView) findViewById(R.id.prod2);
        double prod2Double = Double.parseDouble(prod2.getText().toString().substring(1));
        addProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod2.getText());
            }
        });

        /******* Prod3 *******/
        ImageView addProd3 = (ImageView) findViewById(R.id.addProd3);
        TextView prod3 = (TextView) findViewById(R.id.prod3);
        double prod3Double = Double.parseDouble(prod3.getText().toString().substring(1));
        addProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod3.getText());
            }
        });

        /******* Prod4 *******/
        ImageView addProd4 = (ImageView) findViewById(R.id.addProd4);
        TextView prod4 = (TextView) findViewById(R.id.prod4);
        double prod4Double = Double.parseDouble(prod4.getText().toString().substring(1));
        addProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod4.getText());
            }
        });

        /******* Prod5 *******/
        ImageView addProd5 = (ImageView) findViewById(R.id.addProd5);
        TextView prod5 = (TextView) findViewById(R.id.prod5);
        double prod5Double = Double.parseDouble(prod5.getText().toString().substring(1));
        addProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod5.getText());
            }
        });

        /******* Prod6 *******/
        ImageView addProd6 = (ImageView) findViewById(R.id.addProd6);
        TextView prod6 = (TextView) findViewById(R.id.prod6);
        double prod6Double = Double.parseDouble(prod6.getText().toString().substring(1));
        addProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod6.getText());
            }
        });

        /******* Prod7 *******/
        ImageView addProd7 = (ImageView) findViewById(R.id.addProd7);
        TextView prod7 = (TextView) findViewById(R.id.prod7);
        double prod7Double = Double.parseDouble(prod7.getText().toString().substring(1));
        addProd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod7.getText());
            }
        });

        /******* Prod8 *******/
        ImageView addProd8 = (ImageView) findViewById(R.id.addProd8);
        TextView prod8 = (TextView) findViewById(R.id.prod8);
        double prod8Double = Double.parseDouble(prod8.getText().toString().substring(1));
        addProd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod8.getText());
            }
        });

        /******* Prod9 *******/
        ImageView addProd9 = (ImageView) findViewById(R.id.addProd9);
        TextView prod9 = (TextView) findViewById(R.id.prod9);
        double prod9Double = Double.parseDouble(prod9.getText().toString().substring(1));
        addProd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartAmount.setText(prod9.getText());
            }
        });



    }
}
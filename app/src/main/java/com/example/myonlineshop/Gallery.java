package com.example.myonlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        //double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
        //Toast.makeText(Gallery.this, "cartAmountDouble: " + cartAmountDouble, Toast.LENGTH_SHORT).show();

        Button checkoutbtn = (Button) findViewById(R.id.checkoutbtn);
        Bundle myCart = new Bundle();
        checkoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gallery.this, Cart.class);
                myCart.putString("currUser", currUser);
                myCart.putString("cartAmount", cartAmount.getText().toString());
                intent.putExtras(myCart);
                startActivity(intent);
            }
        });

        /******* Prod1 *******/
        ImageView addProd1 = (ImageView) findViewById(R.id.addProd1);
        TextView prod1 = (TextView) findViewById(R.id.prod1);
        double prod1Double = Double.parseDouble(prod1.getText().toString().substring(1));
        addProd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod1Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod1Price", prod1Double);
                myCart.putString("prod1Desc", "Cats yammi 1");
                //cartAmount.setText(prod1.getText());
            }
        });

        /******* Prod2 *******/
        ImageView addProd2 = (ImageView) findViewById(R.id.addProd2);
        TextView prod2 = (TextView) findViewById(R.id.prod2);
        double prod2Double = Double.parseDouble(prod2.getText().toString().substring(1));
        addProd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod2Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod2Price", prod2Double);
                myCart.putString("prod2Desc", "Cats yammi 2");
                //cartAmount.setText(prod2.getText());
            }
        });

        /******* Prod3 *******/
        ImageView addProd3 = (ImageView) findViewById(R.id.addProd3);
        TextView prod3 = (TextView) findViewById(R.id.prod3);
        double prod3Double = Double.parseDouble(prod3.getText().toString().substring(1));
        addProd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod3Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod3Price", prod3Double);
                myCart.putString("prod3Desc", "Cats yammi 3");
                //cartAmount.setText(prod3.getText());
            }
        });

        /******* Prod4 *******/
        ImageView addProd4 = (ImageView) findViewById(R.id.addProd4);
        TextView prod4 = (TextView) findViewById(R.id.prod4);
        double prod4Double = Double.parseDouble(prod4.getText().toString().substring(1));
        addProd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod4Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod4Price", prod4Double);
                myCart.putString("prod4Desc", "Cats yammi 4");
                //cartAmount.setText(prod4.getText());
            }
        });

        /******* Prod5 *******/
        ImageView addProd5 = (ImageView) findViewById(R.id.addProd5);
        TextView prod5 = (TextView) findViewById(R.id.prod5);
        double prod5Double = Double.parseDouble(prod5.getText().toString().substring(1));
        addProd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod5Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod5Price", prod5Double);
                myCart.putString("prod5Desc", "Cats yammi 5");
                //cartAmount.setText(prod5.getText());
            }
        });

        /******* Prod6 *******/
        ImageView addProd6 = (ImageView) findViewById(R.id.addProd6);
        TextView prod6 = (TextView) findViewById(R.id.prod6);
        double prod6Double = Double.parseDouble(prod6.getText().toString().substring(1));
        addProd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod6Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod6Price", prod6Double);
                myCart.putString("prod6Desc", "Cats yammi 6");
                //cartAmount.setText(prod6.getText());
            }
        });

        /******* Prod7 *******/
        ImageView addProd7 = (ImageView) findViewById(R.id.addProd7);
        TextView prod7 = (TextView) findViewById(R.id.prod7);
        double prod7Double = Double.parseDouble(prod7.getText().toString().substring(1));
        addProd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod7Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod7Price", prod7Double);
                myCart.putString("prod7Desc", "Cats yammi 7");
                //cartAmount.setText(prod7.getText());
            }
        });

        /******* Prod8 *******/
        ImageView addProd8 = (ImageView) findViewById(R.id.addProd8);
        TextView prod8 = (TextView) findViewById(R.id.prod8);
        double prod8Double = Double.parseDouble(prod8.getText().toString().substring(1));
        addProd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod8Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod8Price", prod8Double);
                myCart.putString("prod8Desc", "Cats yammi 8");
                //cartAmount.setText(prod8.getText());
            }
        });

        /******* Prod9 *******/
        ImageView addProd9 = (ImageView) findViewById(R.id.addProd9);
        TextView prod9 = (TextView) findViewById(R.id.prod9);
        double prod9Double = Double.parseDouble(prod9.getText().toString().substring(1));
        addProd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cartAmountDouble = Double.parseDouble(cartAmount.getText().toString().substring(1));
                cartAmountDouble += prod9Double;
                cartAmount.setText("$" + String.format("%.2f", cartAmountDouble));
                myCart.putDouble("prod9Price", prod9Double);
                myCart.putString("prod9Desc", "Cats yammi 9");
                //cartAmount.setText(prod9.getText());
            }
        });



    }
}
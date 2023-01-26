package com.example.myonlineshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Bundle bundle = getIntent().getExtras();
        String currUser = bundle.getString("currUser");
        String inputCartAmount = bundle.getString(("cartAmount"));

        TextView username = (TextView) findViewById(R.id.hello);
        username.setText("Hello, " + currUser);

        TextView cartAmount = (TextView) findViewById(R.id.cartAmount);
        cartAmount.setText(inputCartAmount);

        Button buy = findViewById(R.id.btnBuy);
        TextView cardholder = (TextView) findViewById(R.id.cardholder);
        TextView cardNumber = (TextView) findViewById(R.id.cardNumber);
        TextView expiration = (TextView) findViewById(R.id.expiration);
        TextView cvv = (TextView) findViewById(R.id.cvv);
        TextView phone = (TextView) findViewById(R.id.phone);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardholder.getText().toString() != null && cardNumber.getText().toString() != null && expiration.getText().toString() != null && cvv.getText().toString() != null && phone.getText().toString() != null) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Checkout.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card number: " + cardNumber.getText().toString() + "\n" +
                            "Card expiry date: " + expiration.getText().toString() + "\n" +
                            "Card CVV: " + cvv.getText().toString() + "\n" +
                            "Phone number: " + phone.getText().toString());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(Checkout.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }else {
                    Toast.makeText(Checkout.this, "Please complete the form", Toast.LENGTH_LONG).show();
                }
            }
        });




        ImageView avatar = (ImageView) findViewById(R.id.userAvatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Gallery.this, "clicked", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(Checkout.this, avatar);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        //Toast.makeText(Gallery.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        if(menuItem.getTitle().toString().equals("Logout")) {
                            Intent intent = new Intent(Checkout.this, MainActivity.class);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });

    }
}
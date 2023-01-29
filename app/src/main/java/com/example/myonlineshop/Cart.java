package com.example.myonlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Bundle bundle = getIntent().getExtras();
        String currUser = bundle.getString("currUser");
        String inputCartAmount = bundle.getString(("cartAmount"));

        TextView username = (TextView) findViewById(R.id.hello);
        username.setText("Hello, " + currUser);

        TextView cartAmount = (TextView) findViewById(R.id.cartAmount);
        cartAmount.setText(inputCartAmount);

        TableLayout tableCart = (TableLayout) findViewById(R.id.tableCart);
        tableCart.setStretchAllColumns(true);

        TableRow tr = new TableRow(this);
        tr.setBackgroundColor(ContextCompat.getColor(Cart.this, R.color.purple_700));
        tr.setPadding(10, 10, 10, 10);
        TextView tv = new TextView(this);
        tv.setText("Item");
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(26);
        TextView tv2 = new TextView(this);
        tv2.setText("Price");
        tv2.setTextColor(Color.WHITE);
        tv2.setTextSize(26);
        tr.addView(tv);
        tr.addView(tv2);
        tableCart.addView(tr);

        for(int i=1; i<10; i++){
            if(bundle.getString("prod" + i + "Desc") != null) {
                TableRow tableRow = new TableRow(this);
                tableRow.setBackgroundColor(ContextCompat.getColor(Cart.this, R.color.white));
                tableRow.setPadding(10, 10, 10, 10);
                TextView textViewDesc = new TextView(this);
                textViewDesc.setText(bundle.getString("prod" + i + "Desc"));
                textViewDesc.setTextSize(22);
                TextView textViewPrice = new TextView(this);
                textViewPrice.setText("$" + String.format("%.2f", bundle.getDouble(("prod" + i + "Price"))));
                textViewPrice.setTextSize(22);
                tableRow.addView(textViewDesc);
                tableRow.addView(textViewPrice);
                tableCart.addView(tableRow);
            }
        }

        double inputCartAmountDouble = Double.parseDouble(inputCartAmount.toString().substring(1));
        double vat = inputCartAmountDouble * 0.2;
        double finalTotal = inputCartAmountDouble + vat;

        TableRow tableRowSubTotal = new TableRow(this);
        tableRowSubTotal.setBackgroundColor(ContextCompat.getColor(Cart.this, R.color.teal_200));
        tableRowSubTotal.setPadding(10, 10, 10, 10);
        TextView textViewSubTotal = new TextView(this);
        textViewSubTotal.setText(inputCartAmount);
        textViewSubTotal.setTextSize(26);
        textViewSubTotal.setTextColor(Color.WHITE);
        TextView textViewSubTotalText = new TextView(this);
        textViewSubTotalText.setText("Subtotal");
        textViewSubTotalText.setTextSize(26);
        textViewSubTotalText.setTextColor(Color.WHITE);
        tableRowSubTotal.addView(textViewSubTotalText);
        tableRowSubTotal.addView(textViewSubTotal);
        tableCart.addView(tableRowSubTotal);

        TableRow tableRowVat = new TableRow(this);
        tableRowVat.setBackgroundColor(ContextCompat.getColor(Cart.this, R.color.teal_200));
        tableRowVat.setPadding(10, 10, 10, 10);
        TextView textViewVat = new TextView(this);
        textViewVat.setText("$" + String.format("%.2f", vat));
        textViewVat.setTextSize(26);
        textViewVat.setTextColor(Color.WHITE);
        TextView textViewVatText = new TextView(this);
        textViewVatText.setText("VAT");
        textViewVatText.setTextSize(26);
        textViewVatText.setTextColor(Color.WHITE);
        tableRowVat.addView(textViewVatText);
        tableRowVat.addView(textViewVat);
        tableCart.addView(tableRowVat);

        TableRow tableRowTotal = new TableRow(this);
        tableRowTotal.setBackgroundColor(ContextCompat.getColor(Cart.this, R.color.teal_700));
        tableRowTotal.setPadding(10, 10, 10, 10);
        TextView textViewTotal = new TextView(this);
        textViewTotal.setText("$" + String.format("%.2f", finalTotal));
        textViewTotal.setTextSize(28);
        textViewTotal.setTextColor(Color.WHITE);
        TextView textViewTotalText = new TextView(this);
        textViewTotalText.setText("Total");
        textViewTotalText.setTextSize(28);
        textViewTotalText.setTextColor(Color.WHITE);
        tableRowTotal.addView(textViewTotalText);
        tableRowTotal.addView(textViewTotal);
        tableCart.addView(tableRowTotal);

        Button checkoutbtn = (Button) findViewById(R.id.checkoutbtn);
        Bundle myCart = new Bundle();
        checkoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, Checkout.class);
                myCart.putString("currUser", currUser);
                myCart.putString("cartAmount", "$" + String.format("%.2f", finalTotal));
                intent.putExtras(myCart);
                startActivity(intent);
            }
        });

        ImageView avatar = (ImageView) findViewById(R.id.userAvatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Gallery.this, "clicked", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(Cart.this, avatar);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        //Toast.makeText(Gallery.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        if(menuItem.getTitle().toString().equals("Logout")) {
                            Intent intent = new Intent(Cart.this, MainActivity.class);
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
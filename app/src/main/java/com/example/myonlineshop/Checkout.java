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

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
        TextView email = (TextView) findViewById(R.id.email);

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
                            Toast.makeText(Checkout.this, "Thank you for purchase, confirmation code has been sent to your mailbox", Toast.LENGTH_LONG).show();
                            /********** EMAIL *******/
                            try {

                                String stringSenderEmail = "online.petshop13@gmail.com";
                                String stringReceiverEmail = email.getText().toString();
                                String stringPasswordSenderEmail = "hukm dpcl kylr tvmg";

                                String stringHost = "smtp.gmail.com";

                                Properties properties = System.getProperties();

                                properties.put("mail.smtp.host", stringHost);
                                properties.put("mail.smtp.port", "465");
                                properties.put("mail.smtp.ssl.enable", "true");
                                properties.put("mail.smtp.auth", "true");

                                javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                                    @Override
                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                                    }
                                });

                                MimeMessage mimeMessage = new MimeMessage(session);
                                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));
                                mimeMessage.setSubject("Subject: Your purchase on Online Pet Shop - confirmation code");
                                mimeMessage.setText("Please use this code to confirm: " + Math.floor(100000 + Math.random() * 900000));

                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Transport.send(mimeMessage);
                                        } catch (MessagingException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                thread.start();

                            } catch (AddressException e) {
                                e.printStackTrace();
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                            /****** EMAIL ********/

                            Intent intent = new Intent(Checkout.this, Confirmation.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("currUser", currUser);
                            intent.putExtras(bundle);
                            startActivity(intent);
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
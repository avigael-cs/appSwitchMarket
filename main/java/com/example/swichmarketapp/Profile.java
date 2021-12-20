//package com.example.swichmarketapp;
//
//import android.content.Intent;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.RatingBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.auth.api.signin.internal.Storage;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.squareup.picasso.Picasso;
//
//import java.io.InputStream;
//import java.net.URL;
//
//public class Profile extends AppCompatActivity {
//    TextView FullName;
//    TextView Email;
//    TextView Phone;
//    ImageView Image;
//    ImageView Picture;
//    RatingBar Rating;
//    DatabaseReference dbUserpicture;
//    String x2 ="";
//    //    String url = "https://firebasestorage.googleapis.com/v0/b/deliverme-fd8f8.appspot.com/o/uploads?alt=media&token=2e89bbd8-79eb-4edc-97c4-4622ab4cae5d";
//    private DatabaseReference mDatabaseRef;
//    Uri imageURI;
//    private static final int IMAGE_PICK_CODE = 1000;
//    private static final int PERMISSION_CODE = 1001;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        FullName = (TextView)findViewById(R.id.fullname);
//        Email = (TextView)findViewById(R.id.fullemail);
//        Phone = (TextView)findViewById(R.id.fullphone);
//        Picture = (ImageView)findViewById(R.id.upload_img);
//        Image = (ImageView)findViewById(R.id.upload_img);
//        Rating = (RatingBar)findViewById(R.id.rating);
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");
//
//
//        FirebaseUser take_id= FirebaseAuth.getInstance().getCurrentUser();
//        String userId= take_id.getUid();
//
//        DatabaseReference user = FirebaseDatabase.getInstance().getReference("users");
//        DatabaseReference user1 = user.child(userId);
//        DatabaseReference allname = user1.child("fullName");
//        DatabaseReference allemail = user1.child("Email");
//        DatabaseReference allphone = user1.child("Phone");
//        DatabaseReference allrat = user1.child("Rate");
//
//        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("Picture");
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                try {
//
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        x2 = snapshot.child("imageUrl").getValue().toString();
//                        Picasso.get().load(x2).into(Image);
//                        break;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//            }
//        });
//
//
//        allname.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String  x = dataSnapshot.getValue().toString();
//                FullName.setText(x);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        allemail.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String  x = dataSnapshot.getValue().toString();
//                Email.setText(x);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        allphone.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String  x = dataSnapshot.getValue().toString();
//                Phone.setText(x);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        allrat.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String  x = dataSnapshot.getValue().toString()+"";
//                int r = Integer.parseInt(x);
//                Toast.makeText(Profile.this,x+r, Toast.LENGTH_LONG).show();
//                Rating.setRating(r);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        Image.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Storage.class));
//                String uploadId = mDatabaseRef.push().getKey();
//
//            }});
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id=item.getItemId();
//        if(id==R.id.nav_home)
//        {
//            Intent intent=new Intent(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        if(id==R.id.nav_prof)
//        {
//            Intent intent=new Intent(this, Profile.class);
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        if(id==R.id.nav_mess)
//        {
//            Intent intent=new Intent(this, Delivery_Done.class);
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        if(id==R.id.nav_deli)
//        {
//            Intent intent=new Intent(this, Delivery_Details.class);
//            startActivity(intent);
//            finish();
//            return true;
//        }
//        if(id==R.id.nav_log)
//        {
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(getApplicationContext(), Login.class));
//            finish();
//
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        MenuInflater inflater = getMenuInflater();
////        inflater.inflate(R.menu.main_menu, menu);
////        return true;
////    }
//    public static Drawable LoadImageFromWebOperations(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}

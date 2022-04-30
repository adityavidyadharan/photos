package com.example.photosandroid;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.photosandroid.model.AppDatabase;
import com.example.photosandroid.model.User;

public class HomeActivity extends AppCompatActivity {

    private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = findViewById(R.id.userName);
    }
    public void handleLogin (View view) {
        Toast toast;
        String username = user.getText().toString().trim();
        if (username.equalsIgnoreCase("admin")) {
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);m
            return;
        } else if (username.isEmpty()) {
            toast = Toast.makeText(this, "Username Empty", Toast.LENGTH_SHORT);
        } else {
            User user = AppDatabase.admin.getUser(username);
            if (user != null) {
                AppDatabase.currentuser = user;
                // go to album
                return;
            }
            else{
                toast = Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT);
            }
        }
        toast.show();
    }
}
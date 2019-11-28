package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final UserAdapter userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);

        User u01 = new User("Hoa", 6);
        User u02 = new User("Huy", 8);
        User u03 = new User("Hang", 7);
        User u04 = new User("Hieu", 9);

        users = new ArrayList<User>();
        users.add(u01);
        users.add(u02);
        users.add(u03);
        users.add(u04);

        userAdapter.users = users;

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();

                users.add(new User("Mai", 7));
                userAdapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                users.get(0).name = "Hoa 02";
                userAdapter.notifyDataSetChanged();
            }
        });
    }

}

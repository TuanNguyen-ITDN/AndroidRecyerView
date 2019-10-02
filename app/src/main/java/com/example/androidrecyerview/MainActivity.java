package com.example.androidrecyerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerviewUser;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerviewUser = findViewById(R.id.recyclerview_id);
        recyclerviewUser.setLayoutManager(new LinearLayoutManager((this)));

        final UserAdapter userAdapter = new UserAdapter();
        recyclerviewUser.setAdapter(userAdapter);

        final User user_1 = new User("Tuan", 20);
        final User user_2 = new User("A", 19);
        final User user_3 = new User("Nga", 28);
        final User user_4 = new User("Vi", 21);

        users = new ArrayList<User>();
        users.add(user_1);
        users.add(user_2);
        users.add(user_3);
        users.add(user_4);

        userAdapter.users = users;

        final Button btn1 = (Button) findViewById(R.id.btn_Add);

        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                users.add(new User("Hung", 7));
                userAdapter.notifyDataSetChanged();
            }
        });


        final Button btn2 = (Button) findViewById(R.id.btn_Update);

        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                users.get(0).setName("Huy");
                users.get(0).setScore(10);
                userAdapter.notifyDataSetChanged();
            }
        });

    }
}

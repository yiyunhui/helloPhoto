package com.example.e.hellophoto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextID;
    private TextView mTextName;
    private TextView mTextStatus;
    private TextView mTextTitle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_photograph:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_quit:
                    mTextMessage.setText(R.string.title_quit);
                    Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        //Bundle bundle=new Bundle();
        Bundle bundle = intent.getExtras();

        mTextMessage = (TextView) findViewById(R.id.message);
        mTextID =(TextView)  findViewById(R.id.textViewIDC);
        mTextName =(TextView)  findViewById(R.id.textViewNameC);
        mTextStatus =(TextView)  findViewById(R.id.textViewStatC);
        mTextTitle =(TextView)  findViewById(R.id.textViewTitleC);

        mTextID.setText(String.format("%s",bundle.getString("ID")));
        mTextName.setText(String.format("%s",bundle.getString("Name")));
        mTextStatus.setText(String.format("%s",bundle.getString("Status")));
        mTextTitle.setText(String.format("%s",bundle.getString("Title")));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

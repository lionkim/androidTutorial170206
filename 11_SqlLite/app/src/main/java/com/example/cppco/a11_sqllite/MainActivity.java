package com.example.cppco.a11_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = (TextView) findViewById(R.id.myTextView);

        TestSQLiteHandler dbHandler = new TestSQLiteHandler(this);
    }
}

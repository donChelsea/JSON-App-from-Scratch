package android.example.com.json_app;

import android.content.Intent;
import android.example.com.json_app.models.Android;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent = getIntent();

        textView = findViewById(R.id.display_textview);
        textView.setText(intent.getStringExtra("android"));
    }
}

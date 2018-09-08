package com.example.dpolania.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateNoteActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "mensaje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(this.EXTRA_MESSAGE, message);
        setResult(RESULT_OK,intent);
        finish();
    }
}

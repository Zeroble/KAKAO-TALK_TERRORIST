package com.sup3rd3v3l0p3r.teamvetor.repeat_keyboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mStart(View v) {
        startService(new Intent(this,TopService.class));
    }

    public void mStop(View v) {
        stopService(new Intent(this,TopService.class));
    }
    public void Clear(View v){
        EditText editText = (EditText) findViewById(R.id.et);
        editText.setText("");
    }

}

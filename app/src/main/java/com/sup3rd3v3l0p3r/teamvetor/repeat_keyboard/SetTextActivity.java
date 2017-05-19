package com.sup3rd3v3l0p3r.teamvetor.repeat_keyboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class SetTextActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.set_text);
    }
    public void setText(View v){
        editText1= (EditText) findViewById(R.id.et1);
        editText2= (EditText) findViewById(R.id.et2);
        editText3= (EditText) findViewById(R.id.et3);
        editText4= (EditText) findViewById(R.id.et4);
        editText5= (EditText) findViewById(R.id.et5);
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();

        editor.putString("et1",editText1.getText().toString());
        editor.putString("et2",editText2.getText().toString());
        editor.putString("et3",editText3.getText().toString());
        editor.putString("et4",editText4.getText().toString());
        editor.putString("et5",editText5.getText().toString());

        editor.commit();

        finish();
    }
}

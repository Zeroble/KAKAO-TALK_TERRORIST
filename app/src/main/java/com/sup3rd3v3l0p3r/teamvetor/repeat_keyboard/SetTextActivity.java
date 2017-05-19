package com.sup3rd3v3l0p3r.teamvetor.repeat_keyboard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SetTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_text);

        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);

        EditText editText1 = (EditText) findViewById(R.id.et1);
        EditText editText2 = (EditText) findViewById(R.id.et2);
        EditText editText3 = (EditText) findViewById(R.id.et3);
        EditText editText4 = (EditText) findViewById(R.id.et4);
        EditText editText5 = (EditText) findViewById(R.id.et5);

        editText1.setText(save.getString("et1", ""));
        editText2.setText(save.getString("et2", ""));
        editText3.setText(save.getString("et3", ""));
        editText4.setText(save.getString("et4", ""));
        editText5.setText(save.getString("et5", ""));
    }

    public void TextSet(View v) {
        EditText editText1 = (EditText) findViewById(R.id.et1);
        EditText editText2 = (EditText) findViewById(R.id.et2);
        EditText editText3 = (EditText) findViewById(R.id.et3);
        EditText editText4 = (EditText) findViewById(R.id.et4);
        EditText editText5 = (EditText) findViewById(R.id.et5);
        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();

        editor.putString("et1", editText1.getText().toString());
        editor.putString("et2", editText2.getText().toString());
        editor.putString("et3", editText3.getText().toString());
        editor.putString("et4", editText4.getText().toString());
        editor.putString("et5", editText5.getText().toString());

        editor.commit();
        finish();
        Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
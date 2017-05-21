package com.sup3rd3v3l0p3r.teamvetor.repeat_keyboard;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetPermission();
    }

    public void SetPermission()
    {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getApplicationContext(), "화면 오버레이 권한 허가됨", Toast.LENGTH_SHORT).show();
//                startService(new Intent(getApplicationContext(),TopService.class));
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(getApplicationContext(), "화면 오버레이 권한 거부됨...\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("하라면 해!")
                .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
                .setPermissions(Manifest.permission.SYSTEM_ALERT_WINDOW)
                .check();
    }

    public void Clear(View v){
        EditText editText = (EditText) findViewById(R.id.et);
        editText.setText("");
    }
    public void showInfo(View v){
        startActivity(new Intent(this,ShowinfoActivity.class));
    }
    public void setText(View v){
        startActivity(new Intent(this,SetTextActivity.class));
    }

}

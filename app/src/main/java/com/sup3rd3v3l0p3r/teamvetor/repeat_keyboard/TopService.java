package com.sup3rd3v3l0p3r.teamvetor.repeat_keyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.inputmethodservice.InputMethodService;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;


public class TopService extends InputMethodService {
    private View mView;
    private WindowManager mManager;
    private WindowManager.LayoutParams mParams;
    boolean onoffCheck = false;

    private float mTouchX, mTouchY;
    private int mViewX, mViewY;

    private boolean isMove = false;

    private View.OnTouchListener mViewTouchListener = new View.OnTouchListener() {
        public void keyDownUp(int keyEventCode) {
            InputConnection inputConnection = getCurrentInputConnection();
            inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyEventCode));
            inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, keyEventCode));
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isMove = false;

                    mTouchX = event.getRawX();
                    mTouchY = event.getRawY();
                    mViewX = mParams.x;
                    mViewY = mParams.y;

                    break;

                case MotionEvent.ACTION_UP:
                    if (!isMove) {//터치시
                        onoffCheck = !onoffCheck;
                        Thread thread = new Thread() {
                            InputConnection ic = getCurrentInputConnection();
                            SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);

                            @Override
                            public void run() {
                                String text;
                                while (true) {
                                        switch ((int) (Math.random() * 10) % 3) {
                                            case 0:
                                                text = save.getString("et1","");
                                                if(text.equals(""));
                                                else
                                                    ic.commitText(save.getString("et1",""), 1);
                                            break;
                                        case 1:
                                            text = save.getString("et1","");
                                            if(text.equals(""));
                                            else
                                                ic.commitText(save.getString("et2",""), 1);
                                            break;
                                        case 2:
                                            text = save.getString("et1","");
                                            if(text.equals(""));
                                            else
                                                ic.commitText(save.getString("et3",""), 1);
                                            break;
                                        case 3:
                                            text = save.getString("et1","");
                                            if(text.equals(""));
                                            else
                                                ic.commitText(save.getString("et4",""), 1);
                                            break;
                                        case 4:
                                            text = save.getString("et1","");
                                            if(text.equals(""));
                                            else
                                                ic.commitText(save.getString("et5",""), 1);
                                            break;
                                    }
                                    ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));

                                    if (onoffCheck == false) {
                                        keyDownUp(66);
                                        break;
                                    }
                                    try {
                                        sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                        if (onoffCheck == true) {
                            Toast.makeText(getApplicationContext(), "실행됨", Toast.LENGTH_SHORT).show();
                            thread.start();
                        } else
                            Toast.makeText(getApplicationContext(), "종료됨", Toast.LENGTH_SHORT).show();

                    }
                    break;

                case MotionEvent.ACTION_MOVE:
                    isMove = true;

                    int x = (int) (event.getRawX() - mTouchX);
                    int y = (int) (event.getRawY() - mTouchY);

                    final int num = 5;
                    if ((x > -num && x < num) && (y > -num && y < num)) {
                        isMove = false;
                        break;
                    }
                    mParams.x = mViewX + x;
                    mParams.y = mViewY + y;

                    mManager.updateViewLayout(mView, mParams);

                    break;
            }

            return true;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mInflater.inflate(R.layout.alaways_top, null);
        mView.setOnTouchListener(mViewTouchListener);
        mParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        mParams.gravity = Gravity.TOP | Gravity.LEFT;

        mManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mManager.addView(mView, mParams);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mView != null) {
            mManager.removeView(mView);
            mView = null;
        }
    }
}

package jp.ac.kcska.s3a111.addactivitysample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("AnotherActivity");
        setContentView(textView);
    }
}

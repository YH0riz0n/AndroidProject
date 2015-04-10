package jp.ac.kcska.s3a111.getresourcesample;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView msg = (TextView)findViewById(R.id.msg_text);
        Resources res = getResources();
        String msg_string = res.getString(R.string.msg_text);
        msg.setText(msg_string);
        int msg_color = res.getColor(R.color.text_color);
        msg.setTextColor(msg_color);

    }
}

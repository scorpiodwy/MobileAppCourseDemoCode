package android.dwy.m0214;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_about, btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about = (Button) findViewById(R.id.btn_about);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        MyOnClickListener listener = new MyOnClickListener();

        btn_about.setOnClickListener(listener);
        btn_exit.setOnClickListener(listener);
    }

    private class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_about:
                    //jump from this act. to AboutAct.
                    Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(myIntent);
                    break;
                case R.id.btn_exit:
                    finish();
                    break;
            }
        }
    }
}

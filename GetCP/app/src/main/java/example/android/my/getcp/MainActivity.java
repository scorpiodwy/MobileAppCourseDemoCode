package example.android.my.getcp;


import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn_cp);
        btn.setOnClickListener(this);

        tv = (TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {

        String URL = "content://example.android.my.cptester/friends";
        Uri friends = Uri.parse(URL);
        Cursor c = getContentResolver().query(friends, null, null, null, "name");
        String result = "Results:";

        if (!c.moveToFirst()) {
            tv.setText(result + " no content yet!");
            //Toast.makeText(this, result + " no content yet!", Toast.LENGTH_LONG).show();
        }else{
            do{
                result = result + "\n" + c.getString(c.getColumnIndex("name")) +
                        " with id " +  c.getString(c.getColumnIndex("id")) +
                        " has birthday: " + c.getString(c.getColumnIndex("birthday"));
            } while (c.moveToNext());
            tv.setText(result);
            //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }


    }
}

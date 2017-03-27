package example.android.my.cptester;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void deleteAllBirthdays (View view) {
        // delete all the records and the table of the database provider
        String URL = "content://example.android.my.cptester/friends";
        Uri friends = Uri.parse(URL);
        int count = getContentResolver().delete(
                friends, null, null);
        String countNum = count +" records are deleted.";
        Toast.makeText(getBaseContext(),
                countNum, Toast.LENGTH_LONG).show();
    }

    public void addBirthday(View view) {
        // Add a new birthday record
        ContentValues values = new ContentValues();

        values.put(BirthProvider.NAME,
                ((EditText)findViewById(R.id.name)).getText().toString());

        values.put(BirthProvider.BIRTHDAY,
                ((EditText)findViewById(R.id.birthday)).getText().toString());

        Uri uri = getContentResolver().insert(
                BirthProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                 uri.toString() + " inserted!", Toast.LENGTH_LONG).show();
    }


    public void showAllBirthdays(View view) {
        // Show all the birthdays
        String URL = "content://example.android.my.cptester/friends";
        Uri friends = Uri.parse(URL);
        Cursor c = getContentResolver().query(friends, null, null, null, "name");
        String result = "Results:";

        if (!c.moveToFirst()) {
            Toast.makeText(this, result+" no content yet!", Toast.LENGTH_LONG).show();
        }else{
            do{
                result = result + "\n" + c.getString(c.getColumnIndex(BirthProvider.NAME)) +
                        " with id " +  c.getString(c.getColumnIndex(BirthProvider.ID)) +
                        " has birthday: " + c.getString(c.getColumnIndex(BirthProvider.BIRTHDAY));
            } while (c.moveToNext());
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }

    }
}

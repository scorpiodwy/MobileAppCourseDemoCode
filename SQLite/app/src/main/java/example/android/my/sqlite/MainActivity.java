package example.android.my.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //insert
        Log.d("SQLite", "Inserting ...");
        db.addContact(new Contact("AAA", "1233211232"));
        Log.d("SQLite", "Insert AAA Success!");
        db.addContact(new Contact("BBB", "32132131231"));
        Log.d("SQLite", "Insert BBB Success!");

        List<Contact> contacts = db.getAllContacts();

//        Log.d("SQLite", "AAA->CCC");
//        Contact contact1 = db.getContact(3);
//        contact1.setName("CCC");
//        contact1.setPhoneNumber("3213213121");
//        Log.d("SQLite", "New Contact: "+contact1.getName());
//        db.updateContact(contact1);


//        Log.d("Update", "BBB->CCC");
//        Contact contact2 = db.getContact(3);
//        Log.d("Old Contact", contact2.getName());
//        contact2.setName("CCC");
//        contact2.setPhoneNumber("3213213121");
//        Log.d("New Contact", contact2.getName());
//        db.updateContact(contact2);



        //delete
//        Log.d("deleting:", "Deleting all contacts..");
//        for (Contact c : contacts){
//            String log = "Id: " + c.getID() + " ,Name: " + c.getName() + " ,Phone: " + c.getPhoneNumber();
//            Log.d("Delete:", log);
//            db.deleteContact(c);
//        }

        //read
        Log.d("SQLite: ", "Reading all contacts..");
        contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() +
                    " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("SQLite: ", log);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

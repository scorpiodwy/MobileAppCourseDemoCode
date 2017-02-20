package example.android.my.color;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new GraphicsView(this));
    }

    static public class GraphicsView extends View {
        public GraphicsView(Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){
            int color1 = Color.argb(127, 255, 0, 255);

            int my_color = getResources().getColor(R.color.my_color);
            int my_color_1 = R.color.my_color;

            Paint cPaint = new Paint();
            cPaint.setColor(Color.LTGRAY);

            Paint tPaint = new Paint();
            tPaint.setColor(my_color);
            tPaint.setTextSize(20);

            Path path1 = new Path();
            path1.addCircle(300, 200, 150, Path.Direction.CW);

            Path path2 = new Path();
            path2.addRect(150,400,400,650,Path.Direction.CW);


            canvas.drawPath(path1, cPaint);

            canvas.drawTextOnPath("TEST", path1, 0, 20, tPaint);

            canvas.drawPath(path2, tPaint);

            //create a new canvas
            Bitmap bitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(bitmap);
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

package rs.aleph.android.example15.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.example15.R;
import rs.aleph.android.example15.model.Fruit;
import rs.aleph.android.example15.provider.CategoryProvider;
import rs.aleph.android.example15.provider.FruitProvider;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    private int position = 0;

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

        // Loads an URL into the WebView
        final int position = getIntent().getIntExtra("position", 0);

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getAssets().open(FruitProvider.getFruitById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(FruitProvider.getFruitById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(FruitProvider.getFruitById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FruitProvider.getFruitById(position).getCategory().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_rating);
        rbRating.setRating(FruitProvider.getFruitById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + FruitProvider.getFruitById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }
}

package com.example.splashscreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView textView,textViewLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.tvclick);
        textViewLong = findViewById(R.id.tvlong);
        textView.setOnClickListener(this);
        registerForContextMenu(textViewLong);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,50001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Guru Nanak College");
        menu.add(0,1,1,"contact us");
        menu.add(0,2,2,"mail");
        menu.add(0,3,3,"map");
        menu.add(0,4,4,"call us");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:{
                Toast.makeText(this,"contact us clicked",Toast.LENGTH_SHORT).show();
                break;
            }
            case 2:{
                Toast.makeText(getApplicationContext(),"mail clicked",Toast.LENGTH_SHORT).show();
                break;

            }
            case 3:{
                Toast.makeText(getApplicationContext(),"map clicked",Toast.LENGTH_SHORT).show();
                break;
            }
            case 4:{
                Toast.makeText(getApplicationContext(),"call us clicked",Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}

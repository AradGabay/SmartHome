package com.example.AlphaVersion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import static com.example.AlphaVersion.FBref.FBDB;
import static com.example.AlphaVersion.FBref.refText;

public class Showtext extends AppCompatActivity {
    EditText edtchild,edtvalue;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtext);
        edtvalue = (EditText)findViewById(R.id.edtvalue);
        edtchild = (EditText)findViewById(R.id.edtchild);
        txt = findViewById(R.id.txt);

    }

    public void upload(View view) {
        String edtchildcontent = edtchild.getText().toString();
        String edtvaluecontent = edtvalue.getText().toString();
        refText.child(edtchildcontent).setValue(edtvaluecontent);
    }


    public void download(View view) {
        String childPath;
        childPath="text/"+edtchild.getText().toString();
        Log.d("Showtext", "childPath: "+childPath);
        DatabaseReference refTextId = FBDB.getReference( childPath);

        refTextId.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String getValue;
               getValue=snapshot.getValue().toString();
               txt.setText(getValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }
    public boolean onOptionsItemSelected (MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.textstore) {
            Intent si = new Intent(Showtext.this,Showtext.class);
            startActivity(si);
        }
        else if (id==R.id.menuLogin) {
            SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("stayConnect",false);
            editor.commit();
            Intent si = new Intent(Showtext.this,MainActivity.class);
            startActivity(si);
        }
        else if (id==R.id.menuStoreimage) {
            Intent si = new Intent(Showtext.this,Storing.class);
            startActivity(si);
        }
        /*else if (id==R.id.menuStorefile) {
            Intent si = new Intent(Storing.this,Filestore.class);
            startActivity(si);
        }*/
        return true;
    }
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
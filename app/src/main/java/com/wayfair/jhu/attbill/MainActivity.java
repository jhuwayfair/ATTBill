package com.wayfair.jhu.attbill;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.wayfair.brickkit.BrickFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private BillFragment brickFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText subValue = (EditText) findViewById(R.id.subValue);
        final EditText mainValue = (EditText) findViewById(R.id.mainValue);

        fragmentManager = getSupportFragmentManager();
        brickFragment = new BillFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, brickFragment, BillFragment.FRAGMENT_NAME).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.caculate);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brickFragment.setSubOverValue(Float.valueOf(mainValue.getText().toString()),
                        Float.valueOf(subValue.getText().toString()));
                try {
                    brickFragment.updateData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

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

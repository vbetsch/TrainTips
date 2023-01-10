package com.example.traintips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

private const val MENU_ID_ELEMENTA = 1;
private const val MENU_ID_ELEMENTB = 2;
private const val MENU_ID_ELEMENTC = 3;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_ID_ELEMENTA, 1, "element A");
        menu.add(0, MENU_ID_ELEMENTB, 2, "element B");
        menu.add(0, MENU_ID_ELEMENTC, 3, "element C");
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_ID_ELEMENTA -> Toast.makeText(this, "$item", Toast.LENGTH_LONG).show();
            MENU_ID_ELEMENTB -> Toast.makeText(this, "$item", Toast.LENGTH_LONG).show();
            MENU_ID_ELEMENTC -> Toast.makeText(this, "$item", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item)
    }

}
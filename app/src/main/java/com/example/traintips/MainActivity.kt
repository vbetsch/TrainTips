package com.example.traintips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

private const val MENU_ID_MY_STATION = 1;
private const val MENU_ID_LEAVE_NOW = 2;
private const val MENU_ID_BOOK_TRIP = 3;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_ID_MY_STATION, 1, "My Station");
        menu.add(0, MENU_ID_LEAVE_NOW, 2, "Leave Now");
        menu.add(0, MENU_ID_BOOK_TRIP, 3, "Book A Trip");
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_ID_MY_STATION -> startActivity(Intent(this, MyStationActivity::class.java));
            MENU_ID_LEAVE_NOW -> startActivity(Intent(this, LeaveNowActivity::class.java));
            MENU_ID_BOOK_TRIP -> startActivity(Intent(this, BookTripActivity::class.java));
        }
        return super.onOptionsItemSelected(item)
    }

}
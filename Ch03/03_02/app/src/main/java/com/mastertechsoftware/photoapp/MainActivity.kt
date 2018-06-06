package com.mastertechsoftware.photoapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    /**
     * This is the onCreate Method
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // The "var" type means that a variable can be changed.
        var userName = "Fred"
        userName = "Sue"

        // Also unlike Java, variable types are defined after the variable name.
        val name: String = "Fred"

        /**
         * One of the unique features of Kotlin is nullable types. In
         * Android and Java, the null pointer exception is one of the biggest
         * headaches we deal with. Kotlin can tell the difference between a variable
         * that can be null, and one that can't.
         * To declare a variable as nullable, you need to add a question mark
         * after the type. Only "var" types can be nullable.
        */
        var name2: String? = null

        /**
         * To use variable methods safely, use the question mark after the
         * variable name, and then call the method
         */
        val length = name2?.length

        // length2 will either be the length, or -1 is length2 is null
        val length2 = name2?.length ?: -1
        /**
         * The double exclamation operator will evaluate the variable even
         * if it is null, causing a null pointer exception.
        */
        val length3 = name2!!.length

        /**
         * Kotlin has 2 ways to declare variables, val and var.
         * "val" designates a variable as an immutable type, meaning that
         * once a value is set, it cannot be changed. In Kotlin, we try
         * to use "val" as much as possible, as it promotes mutability.
         * This is considered a safer way to program as you don't have to
         * worry about the side effects of other methods changing a variable.
         */
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Variables in Kotlin do not need to be declared if the type is obvious
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
package com.mastertechsoftware.photoapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

/**
 * Classes are defined with the "class" keyword, just as in Java.
 * Classes are final by default, which means they cannot be sub-classed.
 * If you would like your class to be sub-classed, you need to use
 * the keyword "open". To create a new class, you no longer need to
 * use the "new" keyword, just use the class name with parenthesis.
 * To extend or implement a class or interface, you just use a colon
 * instead of the keyword, "extends" or "implements".
 */
class MainActivity : AppCompatActivity() {

    /**
     * Comments are the same in Kotlin as they are in Java,
     * you can use the two forward slashes or end of line comments.
     * This is the onCreate Method
     * @param savedInstanceState
     * Kotlin uses the special keyword "fun" to define a function.
     * Kotlin can have function modifiers like "public", "private", and "protected",
     * but the default modifier is "public". "internal" is a new modifier and
     * makes the variable visible in the same module.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}

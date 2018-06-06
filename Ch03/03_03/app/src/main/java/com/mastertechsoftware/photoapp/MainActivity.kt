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
     * To create a function in Kotlin, start with the keyword "fun".
     * Add a name to the function and put parameters inside of
     * parenthesis. The parameters start with a name, then a colon,
     * and then a type. A function ends with a return type, if there is
     * no return type, you can use a special class "unit", which is similar
     * to void, or not specify a return type.
     *
     * To override a function, use the "override" keyword. Kotlin
     * does not use the "@override" annotation. You can use the keyword
     * "inline" to have the function copied into the place it was called.
     *
     * This method receives a String "name", and returns
     * the length of the name if it isn't null, otherwise
     * returning "-1"
     */
    inline fun strLength(name: String?): Int {
        return name?.length ?: -1
    }
    /**
     * This is the onCreate method
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        var userName = "Fred"
        userName = "Sue"
        val name: String = "Fred"
        var name2: String? = null
        val length = name2?.length
        val length2 = name2?.length ?: -1
        val length3 = name2?.length!!

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        /**
         * Lambdas are called function literals, basically anything inside
         * of curly braces. Below, we have the following lambda. "view" is
         * the name we give for the View object passed in, and we can
         * use that in the code after the arrow.
         */
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    /**
     * The onCreateOptionsMenu() method takes a menu parameter and
     * returns a Boolean type.
     */
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

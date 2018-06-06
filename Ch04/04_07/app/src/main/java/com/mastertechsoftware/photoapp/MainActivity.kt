package com.mastertechsoftware.photoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.mastertechsoftware.photoapp.api.PhotoRetriever
import com.mastertechsoftware.photoapp.models.Photo
import com.mastertechsoftware.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Add nullable variables because we don't have a value
    // for them yet
    var photos : List<Photo>? = null
    var mainAdapter : MainAdapter? = null

    // Another way to use a nullable variable is to use
    // lateinit, which allows you to declare the variable here,
    // but initialize it in the onCreate() method
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        /**
         * Add code to retrieve the photos
         */

        // Instantiate RecyclerView
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Create RecyclerView's layout manager, passing the
        // MainActivity as the context
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create an instance of the REST API class
        var retriever = PhotoRetriever()

        // Create Callback object
        // The keyword 'object' is used to create anonymous
        // objects in Kotlin
        val callback = object : Callback<PhotoList> {

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {

                // Check that the response is successful
                // Use the "let" keyword to execute the code
                // only if the variable (response) is not null
                response?.isSuccessful.let {

                    // To reference an outer class, use Kotlin's @ symbol.
                    // Using this, we can reference our photos object.
                    // Assign the response's body to the list in the MainActivity
                    this@MainActivity.photos = response?.body()?.hits

                    // Create and instance of out MainAdapter, passing our
                    // list of photos, and the click listener
                    mainAdapter = MainAdapter(this@MainActivity.photos!!,
                            this@MainActivity)

                    // Set the MainAdapter on the RecyclerView
                    recyclerView.adapter = mainAdapter

                }
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {

                // Log failure message
                Log.e("MainActivity", "Problems calling API")
            }

        }

        // Make the call using the PhotoRetriever
        // This code creates a CallBack object that we can pass to
        // our retriever. Once the retriever finishes,out callback will
        // be called. If successful, it will call onResponse() or onFailure()
        // with an error, and onResponse() we receive a list of Photos.
        // To get the list we have to call response.body.hits, since
        // response is the response object. Once we have the list, we set
        // out adapter
        retriever.getPhotos(callback)

    }

    // Implement the onClick() method
    override fun onClick(view: View?) {

        // Create an Intent to the DetailActivity
        val intent = Intent(this, DetailActivity::class.java)

        // Get our Holder using the view's tag variable
        val holder = view?.tag as MainAdapter.PhotoViewHolder

        // Put the Photo into the Intent
        intent.putExtra(DetailActivity.PHOTO,
                mainAdapter?.getPhoto(holder.adapterPosition))

        // Start our Activity
        startActivity(intent)

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

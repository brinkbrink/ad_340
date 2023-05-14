package com.example.jazzrecyclerview
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jazzrecyclerview.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter(IntRange(0, 7).toList())
    }
}

class MyAdapter(val data: List<Int>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val textView: TextView = row.findViewById<TextView>(R.id.number)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_view, parent, false)
        return MyViewHolder(layout)
    }

    val jazzArtists = listOf("Abbey Lincoln", "Albert Ayler", "Alice Coltrane", "Wes Montgomery", "Weldon Irvine", "Tony Allen", "Miles Davis", "Max Roach")

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = jazzArtists.get(position)
    }
    override fun getItemCount(): Int = data.size
}

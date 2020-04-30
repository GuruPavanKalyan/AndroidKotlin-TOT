package com.example.newapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var img: ImageView
    lateinit var img1: ImageView
    var r = 0
    var r1 = 0
    var c = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.dice);
        img1 = findViewById(R.id.dice1);
    }

    fun showToast(view: View) {
        r = (1..6).random()
        r1 = (1..6).random()
        val tv: TextView = findViewById(R.id.result)
        tv.text = "Dice 1 : " + r.toString() + " Dice 2 : " + r1.toString()
        displayDice(r, r1);
        val toast: Toast = Toast.makeText(
            this,
            "The random number generated is " + r + " and " + r1,
            Toast.LENGTH_LONG
        );
        toast.show();
        c++
    }

    private fun displayDice(r: Int, r1: Int) {
        when (r) {
            1 -> img.setImageResource(R.drawable.dice_1);

            2 -> img.setImageResource(R.drawable.dice_2);

            3 -> img.setImageResource(R.drawable.dice_3);

            4 -> img.setImageResource(R.drawable.dice_4);

            5 -> img.setImageResource(R.drawable.dice_5);

            6 -> img.setImageResource(R.drawable.dice_6);

            else -> img.setImageResource(R.drawable.empty_dice);

        }
        when (r1) {
            1 -> img1.setImageResource(R.drawable.dice_1);

            2 -> img1.setImageResource(R.drawable.dice_2);

            3 -> img1.setImageResource(R.drawable.dice_3);

            4 -> img1.setImageResource(R.drawable.dice_4);

            5 -> img1.setImageResource(R.drawable.dice_5);

            6 -> img1.setImageResource(R.drawable.dice_6);

            else -> img1.setImageResource(R.drawable.empty_dice);

        }
    }

    fun upcount(view: View) {
        if (c == 1) {
            if (r < 6) {
                r = r + 1
            }
            if (r1 < 6) {
                r1 = r1 + 1
            }
            displayDice(r, r1);
            val toast: Toast = Toast.makeText(this,"The random number generated is " + r + " and " + r1,Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            displayDice(1,1);
        }
        c=0
    }
}

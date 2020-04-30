package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.database.DatabaseUtilsCompat
import androidx.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var r = 0
    var r1 = 0
    var c = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
    fun showToast(view: View) {
        r = (1..6).random()
        r1 = (1..6).random()

        val value = "Dice 1 : " + r.toString() + " Dice 2 : " + r1.toString()
        var v = Value(value)
        binding.result.text = v.toString()
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
            1 -> binding.dice.setImageResource(R.drawable.dice_1);

            2 -> binding.dice.setImageResource(R.drawable.dice_2);

            3 -> binding.dice.setImageResource(R.drawable.dice_3);

            4 -> binding.dice.setImageResource(R.drawable.dice_4);

            5 -> binding.dice.setImageResource(R.drawable.dice_5);

            6 -> binding.dice.setImageResource(R.drawable.dice_6);

            else -> binding.dice.setImageResource(R.drawable.empty_dice);

        }
        when (r1) {
            1 -> binding.dice.setImageResource(R.drawable.dice_1);

            2 -> binding.dice.setImageResource(R.drawable.dice_2);

            3 -> binding.dice.setImageResource(R.drawable.dice_3);

            4 -> binding.dice.setImageResource(R.drawable.dice_4);

            5 -> binding.dice.setImageResource(R.drawable.dice_5);

            6 -> binding.dice.setImageResource(R.drawable.dice_6);

            else -> binding.dice.setImageResource(R.drawable.empty_dice);

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
            val toast: Toast = Toast.makeText(this,"The random number generated is " + r + " and " + r1,
                Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            displayDice(1,1);
        }
        c=0
    }
}

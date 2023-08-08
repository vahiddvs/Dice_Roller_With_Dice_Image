package com.vahidseidi.projects.dicerollerwithdiceimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {

        // Find the ImageView in the layout
        val firstDiceImage: ImageView = findViewById(R.id.imageView)

        // Create new Dice object with 6 sides and roll the dice
        val firstDice = Dice(6)
        val resultFirstDiceRoll = firstDice.roll()

        // Determine which drawable resource ID to use based on the dice roll
        val firstDiceDrawableResource = when(resultFirstDiceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        firstDiceImage.setImageResource(firstDiceDrawableResource)

        // Update the content description
        firstDiceImage.contentDescription = resultFirstDiceRoll.toString()

        // Find the second ImageView in the layout
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        // Create another Dice object with 6 sides and roll the dice
        val secondDice = Dice(6)
        val resultSecondDiceRoll = secondDice.roll()

        // Determine which drawable resource ID to use based on the dice roll
        val secondDiceDrawableResource = when(resultSecondDiceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else ->R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        secondDiceImage.setImageResource(secondDiceDrawableResource)

        // Update the content description
        secondDiceImage.contentDescription = resultSecondDiceRoll.toString()
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
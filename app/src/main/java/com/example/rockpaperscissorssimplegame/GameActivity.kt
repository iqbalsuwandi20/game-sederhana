package com.example.rockpaperscissorssimplegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var resultImageView: ImageView
    lateinit var exitButton: Button

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        resultImageView = findViewById(R.id.resultImageView)
        exitButton = findViewById(R.id.exitButton)
    }

    private fun initListener() {
        rockImageButton.setOnClickListener { startGame("ROCK") }
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
        paperImageButton.setOnClickListener { startGame("PAPER") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initComponents()
        initListener()

    }
}
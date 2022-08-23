package com.example.animationcar

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		var position=18


		val listOfCars=mutableListOf(
			R.drawable.a1,
			R.drawable.a2,
			R.drawable.a3,
			R.drawable.a4,
			R.drawable.a5,
			R.drawable.a6,
			R.drawable.a7,
			R.drawable.a8,
			R.drawable.a9,
			R.drawable.a10,
			R.drawable.a11,
			R.drawable.a12,
			R.drawable.a13,
			R.drawable.a14,
			R.drawable.a15,
			R.drawable.a16,
			R.drawable.a17,
			R.drawable.a18,
			R.drawable.a19,
			R.drawable.a20,
			R.drawable.a21,
			R.drawable.a22,
			R.drawable.a23,
			R.drawable.a24,
			R.drawable.a25,
			R.drawable.a26,
			R.drawable.a27,
			R.drawable.a28,
			R.drawable.a29,
			R.drawable.a30,
			R.drawable.a31,
			R.drawable.a32,
			R.drawable.a33,
			R.drawable.a34,
			R.drawable.a35,
			R.drawable.a36
		)
		imageView.setImageResource(R.drawable.a19)
		testConstraints.bringToFront()


		testConstraints.setOnTouchListener(object:OnSwipeTouchListener(this@MainActivity){

			override fun onSwipeRight() {
				position+=1
				if (position==36){
					position=0
				}
				imageView.setZoomable(false)

				imageView.setImageResource(listOfCars[position])

				imageView.setZoomable(true)
				super.onSwipeRight()
			}

			override fun onSwipeLeft() {
				position-=1
				if (position==-1){
					position=35
				}
				imageView.setImageResource(listOfCars[position])
				super.onSwipeLeft()
			}

			override fun onSwipeTop() {
				/*if(position==0){
					val scaleDownX = ObjectAnimator.ofFloat(imageView, "scaleX", 0.5f)
					val scaleDownY = ObjectAnimator.ofFloat(imageView, "scaleY", 0.5f)
					scaleDownX.duration = 1000
					scaleDownY.duration = 1000
					val scaleDown = AnimatorSet()
					scaleDown.play(scaleDownX).with(scaleDownY)

					scaleDown.start()
				}
				super.onSwipeTop()*/
				if (position==18){
					val fadeOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, .1f)
					fadeOut.startDelay=1000
					fadeOut.duration = 2000
					val fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", .1f, 1f)
					fadeOut.duration = 2000

					val scaleUpX = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f)
					val scaleUpY = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f)
					scaleUpX.duration = 1000
					scaleUpY.duration = 1000

					val scaleDownX = ObjectAnimator.ofFloat(imageView, "scaleX", 0.1f)
					val scaleDownY = ObjectAnimator.ofFloat(imageView, "scaleY", 0.1f)
					scaleDownX.duration = 2000
					scaleDownY.duration = 2000

					val fadeOutSet = AnimatorSet()

					//mAnimationSet.play(fadeIn).after(fadeOut)
					fadeOutSet.playTogether(scaleDownX, scaleDownY,fadeOut)
					fadeOutSet.start()
					fadeOutSet.addListener(object : AnimatorListenerAdapter() {

						override fun onAnimationEnd(animation: Animator?) {
							super.onAnimationEnd(animation)
							imageView.setImageResource(R.drawable.a1)
							fadeOutSet.cancel()

							val zoomOut = AnimatorSet()
							zoomOut.play(scaleUpX).with(scaleUpY).after(fadeIn)
							zoomOut.start()
							zoomOut.addListener(object : AnimatorListenerAdapter() {
								override fun onAnimationEnd(animation: Animator?) {
									super.onAnimationEnd(animation)
									imageView.setImageResource(R.drawable.a33)
									position=32
								}
							})

						}
					})

					/*mAnimationSet.addListener(object : AnimatorListenerAdapter() {
						override fun onAnimationEnd(animation: Animator) {
							super.onAnimationEnd(animation)
							mAnimationSet.start()
						}
					})*/

				}
			}

			override fun onSwipeBottom() {
				if(position==0){
					val scaleUpX = ObjectAnimator.ofFloat(imageView, "scaleX", 2.0f)
					val scaleUpY = ObjectAnimator.ofFloat(imageView, "scaleY", 2.0f)
					scaleUpX.duration = 1000
					scaleUpY.duration = 1000
					val scaleUp = AnimatorSet()
					scaleUp.play(scaleUpX).with(scaleUpY)

					scaleUp.start()
				}
				super.onSwipeBottom()
			}

		})
	}
}
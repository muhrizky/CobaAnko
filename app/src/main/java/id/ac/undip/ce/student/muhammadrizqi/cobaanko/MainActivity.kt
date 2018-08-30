package id.ac.undip.ce.student.muhammadrizqi.cobaanko

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import id.ac.undip.ce.student.muhammadrizqi.cobaanko.R.color.colorAccent

import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
            verticalLayout {
                padding=dip(16)
                val name =  editText(){
                    hint = "whats your Name?"
                }
                button("say Hello") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("HEllo, ${name.text}!") }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("show alert") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        snackbar(name, "hello, ${name.text}!")
                    }
                }.lparams(width = matchParent){topMargin = dip(5)
                }
                button("Show Selector"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                        selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
                            toast("So you're love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE

                    onClick {
                        snackbar(name, "Hello, ${name.text}!")

                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("show Progres Bar") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Hello, ${name.text}! Please Wait....").show()
                    }
                }.lparams(width = matchParent){topMargin = dip(5)
                }
                button("GO to second Activity") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){topMargin = dip(5)
                }
            }
        }

    }
}

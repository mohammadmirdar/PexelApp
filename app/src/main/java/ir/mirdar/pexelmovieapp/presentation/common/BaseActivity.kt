package ir.mirdar.pexelmovieapp.presentation.common

import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class BaseActivity<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> :
    ComponentActivity() {
    private lateinit var viewState: STATE
    val mState get() = viewState


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
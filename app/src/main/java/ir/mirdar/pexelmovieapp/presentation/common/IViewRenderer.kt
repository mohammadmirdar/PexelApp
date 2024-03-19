package ir.mirdar.pexelmovieapp.presentation.common

/**
 * Created by Rim Gazzah on 8/20/20.
 **/
interface IViewRenderer<STATE> {
    fun render(state: STATE)
}
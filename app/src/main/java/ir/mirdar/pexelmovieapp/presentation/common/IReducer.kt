package ir.mirdar.pexelmovieapp.presentation.common


/**
 * Created by Rim Gazzah on 8/26/20.
 **/
interface IReducer<STATE, T :Any> {
    fun reduce(result: Result<T>, state: STATE,): STATE
}
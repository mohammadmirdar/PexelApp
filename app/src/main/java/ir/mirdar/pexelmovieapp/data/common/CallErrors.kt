package ir.mirdar.pexelmovieapp.data.common


/**
 * Created by Rim Gazzah on 8/28/20.
 **/
sealed class CallErrors {
    data object ErrorEmptyData : CallErrors()
    data object ErrorServer: CallErrors()
    data class ErrorException(val throwable: Throwable) : CallErrors()
}
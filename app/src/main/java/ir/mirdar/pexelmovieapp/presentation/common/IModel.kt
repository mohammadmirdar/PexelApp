package ir.mirdar.pexelmovieapp.presentation.common

import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Rim Gazzah on 8/20/20.
 **/

interface IModel<STATE, INTENT> {

    val state: StateFlow<STATE>

    fun dispatchIntent(intent: INTENT)
}
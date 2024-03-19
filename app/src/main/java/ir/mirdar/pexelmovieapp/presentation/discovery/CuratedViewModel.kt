package ir.mirdar.bazaarsample.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mirdar.pexelmovieapp.domain.GetUpcomingList
import ir.mirdar.pexelmovieapp.presentation.common.BaseViewModel
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeAction
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeIntent
import ir.mirdar.pexelmovieapp.presentation.discovery.HomeState
import ir.mirdar.pexelmovieapp.presentation.common.reduce
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CuratedViewModel @Inject constructor(
    private val getUpcomingList: GetUpcomingList
) : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    var currentPage = 0

    private val mState : MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    override val state: StateFlow<HomeState>
        get() = mState.asStateFlow()

    init {
        dispatchIntent(HomeIntent.LoadUpcomingList(1))
    }
    override fun intentToAction(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.LoadUpcomingList -> {
                currentPage = intent.page
                HomeAction.LoadList(intent.page)
            }
        }
    }

    override fun handleAction(action: HomeAction) {
        when(action) {
            is HomeAction.LoadList -> {
                fetchUpcomingList(action.page)
            }
        }
    }

    private fun fetchUpcomingList(page: Int) {
        viewModelScope.launch {
            getUpcomingList(page = page).collect {
                mState.value = it.reduce()
            }
        }
    }
}

data class Su(
    val int : Int
)
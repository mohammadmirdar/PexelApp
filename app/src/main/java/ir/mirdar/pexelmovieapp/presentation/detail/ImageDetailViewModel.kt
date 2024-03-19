package ir.mirdar.pexelmovieapp.presentation.detail

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mirdar.pexelmovieapp.domain.GetImageDetail
import ir.mirdar.pexelmovieapp.presentation.common.BaseViewModel
import ir.mirdar.pexelmovieapp.presentation.common.reduce
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    private val getImageDetail: GetImageDetail
) :
    BaseViewModel<DetailIntent, DetailAction, DetailState>() {
    private val mState : MutableStateFlow<DetailState> = MutableStateFlow(DetailState.Loading)
    override val state: StateFlow<DetailState>
        get() = mState.asStateFlow()

    override fun intentToAction(intent: DetailIntent): DetailAction {
        return when (intent) {
            is DetailIntent.LoadImageDetail -> DetailAction.LoadImage(intent.photoId)
        }
    }

    override fun handleAction(action: DetailAction) {
        when (action) {
            is DetailAction.LoadImage -> fetchImageDetail(action.photoId)
        }
    }

    private fun fetchImageDetail(photoId: Long) {
        viewModelScope.launch {
            getImageDetail(photoId).collect {
                mState.value = it.reduce()
            }
        }
    }


}
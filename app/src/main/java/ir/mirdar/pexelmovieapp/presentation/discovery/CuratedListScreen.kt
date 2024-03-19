package ir.mirdar.pexelmovieapp.presentation.discovery

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.mirdar.pexelmovieapp.R
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.domain.models.SourceModel
import ir.mirdar.pexelmovieapp.presentation.common.Utils

val sampleModel = PhotoModel(
    id = 1234,
    width = 4000,
    height = 6000,
    url = "",
    photographer = "Mohamamd mirdar",
    photographer_url = "",
    photographer_id = 12345,
    avg_color = "",
    alt = "",
    liked = true,
    src = SourceModel(
        original = "",
        large2x = "",
        medium = "",
        small = "",
        portrait = "",
        landscape = "",
        tiny = ""
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoveryScreen(
    navController: NavController,
    viewModel: CuratedViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val lazyMovieItem = remember {
        state
    }
    val upcomingList = remember { mutableStateListOf<PhotoModel>() }
    val listStat = rememberLazyGridState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Discover",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.pexel),
                            contentDescription = "pexel logo",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)
                        )
                    }
                },
            )
        }
    ) {
        if (lazyMovieItem.value is HomeState.Exception) {

        }

        LazyVerticalGrid(
            state = listStat,
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(it)
        ) {

            if (lazyMovieItem.value is HomeState.ResultAllUpcomingList) {
                val result = lazyMovieItem.value as HomeState.ResultAllUpcomingList
                upcomingList.addAll(result.data)
                items(upcomingList.size) { index ->
                    if (index >= upcomingList.size - 1 && !Utils.IS_LOADING && !Utils.END_OF_PAGE) {
                        viewModel.dispatchIntent(HomeIntent.LoadUpcomingList(viewModel.currentPage + 1))
                    }
                    MovieItem(
                        photoModel = upcomingList[index],
                        onClick = {
                            navController.navigate("detail/$it")
                        })
                }
            }


            item {
                if (lazyMovieItem.value is HomeState.Loading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
    val activity = (LocalContext.current as Activity)
    BackHandler {
        activity.finish()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MovieItem(photoModel: PhotoModel = sampleModel, onClick: (photoId: Long) -> Unit = {}) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(4.dp)
                .background(color = Color(0xFFEBF7FE)),
            shape = RoundedCornerShape(size = 12.dp),
            onClick = { onClick(photoModel.id) }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photoModel.src.medium)
                    .crossfade(true)
                    .build(), contentDescription = "Movie image",
                modifier = Modifier
                    .width(119.dp)
                    .height(154.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = photoModel.photographer,
            color = Color.Black,
            fontSize = TextUnit(12f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(19.dp),
            maxLines = 1
        )
    }


}
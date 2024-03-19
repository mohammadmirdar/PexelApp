package ir.mirdar.pexelmovieapp.presentation.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.mirdar.pexelmovieapp.R
import ir.mirdar.pexelmovieapp.domain.models.PhotoModel
import ir.mirdar.pexelmovieapp.domain.models.SourceModel

val samplePhotoModel = PhotoModel(
    id = 1234,
    width = 4000,
    height = 6000,
    url = "",
    photographer = "Mohammad Mirdar",
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
fun ImageDetailScreen(
    navHostController: NavHostController,
    photoId: Long,
    detailViewModel: ImageDetailViewModel = hiltViewModel()
) {
    detailViewModel.dispatchIntent(DetailIntent.LoadImageDetail(photoId))
    val photoState = detailViewModel.state.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Image Detail",
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
        if (photoState.value is DetailState.ResultImageDetail) {
            val result = photoState.value as DetailState.ResultImageDetail
            DetailContent(it, photoModel = result.data)
        }
    }

    BackHandler {
        navHostController.popBackStack()
    }
}

@Preview
@Composable
fun DetailContent(
    padding: PaddingValues = PaddingValues(2.dp),
    photoModel: PhotoModel? = samplePhotoModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    )
    {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(photoModel?.src?.landscape)
                .crossfade(true)
                .build(), contentDescription = "Movie image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )

        Text(
            text = photoModel?.photographer ?: "",
            color = Color.Black,
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(22f, TextUnitType.Sp)
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )

        Text(
            text = photoModel?.alt ?: "", color = Color.Black,
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(18f, TextUnitType.Sp)
        )
    }
}
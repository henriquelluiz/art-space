package me.henriquelluiz.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.henriquelluiz.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    ArtSpaceLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var identifier by remember { mutableIntStateOf(5) }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        when(identifier) {
            0 -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_1)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_1,
                    artist = R.string.artist_pic_1,
                    year = R.string.year_pic_1
                )
            }
            1 -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_2)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_2,
                    artist = R.string.artist_pic_2,
                    year = R.string.year_pic_2
                )
            }
            2 -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_3)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_3,
                    artist = R.string.artist_pic_3,
                    year = R.string.year_pic_3
                )
            }
            3 -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_4)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_4,
                    artist = R.string.artist_pic_4,
                    year = R.string.year_pic_4
                )
            }
            4 -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_5)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_5,
                    artist = R.string.artist_pic_5,
                    year = R.string.year_pic_5
                )
            }
            else -> {
                ElevatedImageWithPadding(painter = R.drawable.picture_6)
                Spacer(modifier = Modifier.height(48.dp))
                InformationCard(
                    title = R.string.title_pic_6,
                    artist = R.string.artist_pic_6,
                    year = R.string.year_pic_6
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        RowWithTwoButtons(
            onPreviousClick = { if (identifier > 0) identifier-- else identifier = 5 },
            onNextClick = { if (identifier < 5) identifier++ else identifier = 0 }
        )
    }
}

@Composable
fun ElevatedImageWithPadding(
    @DrawableRes painter: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(painter),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(0.8F)
            .shadow(elevation = 12.dp, shape = RectangleShape)
            .border(24.dp, color = Color.White, shape = RectangleShape)
    )
}

@Composable
fun InformationCard(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F1FF)
    ),
        modifier = modifier
    ) {
        Text(
            text = stringResource(title),
            fontWeight = FontWeight.Light,
            fontSize = 22.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp
                )
        ) {
            Text(
                text = stringResource(artist),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "(${ stringResource(year) })",
                fontWeight = FontWeight.Light,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun RowWithTwoButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.size(154.dp, 40.dp)
        ) {
            Text(
                text = "Previous",
            )
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.size(154.dp, 40.dp)
        ) {
            Text(
                text = "Next"
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = false
)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}
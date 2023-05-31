package com.jonystrins.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jonystrins.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val primerObra = R.drawable.luminekuki
    val segundaObra = R.drawable.lumineaether
    val tercerObra = R.drawable.kuki
    val cuartaObra = R.drawable.lumineku
    val quintaObra = R.drawable.luminerand

    var titulo by remember {
        mutableStateOf(R.string.primer_titulo)
    }

    var personaje by remember{
        mutableStateOf(R.string.Personaje_1)
    }

    var artePresentado by remember {
        mutableStateOf(primerObra)
    }

//    var imagenPresentada by remember {
//        mutableStateOf(artePresentado)
//    }
    
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArteDesplegado(artePresentado = artePresentado)
        Spacer(modifier = modifier.size(16.dp))
        TituloDelArte(titulo = titulo, personaje = personaje)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    when (artePresentado) {
                        primerObra -> {
                            artePresentado = quintaObra
                            titulo = R.string.quinto_titulo
                            personaje = R.string.Personaje_5
                        }
                        segundaObra -> {
                            artePresentado = primerObra
                            titulo = R.string.primer_titulo
                            personaje = R.string.Personaje_1
                        }
                        tercerObra -> {
                            artePresentado = segundaObra
                            titulo = R.string.segundo_titulo
                            personaje = R.string.Personaje_2
                        }
                        cuartaObra -> {
                            artePresentado = tercerObra
                            titulo = R.string.tercer_titulo
                            personaje = R.string.Personaje_3
                        }
                        else -> {
                            artePresentado = cuartaObra
                            titulo = R.string.cuarto_titulo
                            personaje = R.string.Personaje_4
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.gray_900)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.blue_300)
                )
            }
            
            Button(
                onClick = {
                    when (artePresentado) {
                        primerObra -> {
                            artePresentado = segundaObra
                            titulo = R.string.segundo_titulo
                            personaje = R.string.Personaje_2
                        }
                        segundaObra -> {
                            artePresentado = tercerObra
                            titulo = R.string.tercer_titulo
                            personaje = R.string.Personaje_3
                        }
                        tercerObra -> {
                            artePresentado = cuartaObra
                            titulo = R.string.cuarto_titulo
                            personaje = R.string.Personaje_4
                        }
                        cuartaObra -> {
                            artePresentado = quintaObra
                            titulo = R.string.quinto_titulo
                            personaje = R.string.Personaje_5
                        }
                        else -> {
                            artePresentado = primerObra
                            titulo = R.string.primer_titulo
                            personaje = R.string.Personaje_1
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_300)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.gray_900)
                )
            }
        }
    }
}

@Composable
fun ArteDesplegado(
    modifier: Modifier = Modifier,
    @DrawableRes artePresentado: Int
){
    Image(
        painter = painterResource(id = artePresentado),
        contentDescription = stringResource(id = R.string.segundo_titulo),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun TituloDelArte(
    @StringRes titulo: Int,
    @StringRes personaje: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = titulo),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp
        )
        Text(
            text = stringResource(id = personaje),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
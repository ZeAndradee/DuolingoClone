package com.example.compose1

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose1.ui.theme.dinRoundFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home",
            ){
                composable("home"){
                    HomeScreen(navController = navController)
                }
                composable("rank"){
                    RankScreen(navController = navController)
                }
            }
        }
    }
}
//Var App
val offensiveDays = mutableIntStateOf(335)



//Components
@Composable
fun BottomMenu(navController: NavHostController){
    Row( //Bottom Bar
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF141f23))
            .height(80.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()

                .background(Color(0xFF141f23))
                .drawBehind {
                    val strokeWidth = 2.dp.toPx() // Define a espessura da borda
                    val y = 0f // Define a posição y para a borda superior

                    drawLine(
                        Color(0xFF3a474d), // Define a cor da borda
                        Offset(0f, y), // Define o ponto inicial da linha
                        Offset(size.width, y), // Define o ponto final da linha
                        strokeWidth // Define a espessura da linha
                    )
                },

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (i in 1..6) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                ) {
                    when (i) {
                        1 -> Button(
                            onClick = { navController.navigate("home") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp)

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.house_icon),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                tint = Color.Unspecified
                            )
                        }

                        2 -> Icon(
                            painter = painterResource(id = R.drawable.dumbbell),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )

                        3 -> Button(
                            onClick = { navController.navigate("rank") },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shield),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                tint = Color.Unspecified
                            )
                        }

                        4 -> Icon(
                            painter = painterResource(id = R.drawable.chest),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )

                        5 -> Icon(
                            painter = painterResource(id = R.drawable.medium),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape),
                            tint = Color.Unspecified
                        )

                        6 -> Icon(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Unspecified
                        )

                    }

                }
            }
        }
    }
    }

@Composable
fun TopMenu(){
    Column( //Top Bar
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .background(Color(0xFF202f36))
            .padding(top = 13.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier //Inner Top Row 1
                .fillMaxSize()
                .height(23.dp)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 15.dp, end = 60.dp, bottom = 10.dp),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(23.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color.White)
                                .align(Alignment.Center)

                        )
                        Icon(
                            painter = painterResource(id = R.drawable.fr),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .height(20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_up),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .height(22.dp)
                    )

                }


            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 15.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    //Offensive Days
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.offensive_fire),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .padding(end = 8.dp)
                                .height(24.dp)
                        )
                        Text(
                            "${offensiveDays.intValue}",
                            color = Color.White,
                            fontFamily = dinRoundFamily,
                            fontWeight = FontWeight.W600,
                            fontSize = 17.sp
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.cristal),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .padding(end = 8.dp)
                                .height(24.dp)
                        )
                        Text(
                            "7615",
                            color = Color.White,
                            fontFamily = dinRoundFamily,
                            fontWeight = FontWeight.W600,
                            fontSize = 17.sp
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .padding(end = 8.dp)
                                .height(20.dp)
                        )
                        Text(
                            "4",
                            color = Color.White,
                            fontFamily = dinRoundFamily,
                            fontWeight = FontWeight.W600,
                            fontSize = 17.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 10.dp), verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "Seção 2: No ritmo certo",
                        fontSize = 19.sp,
                        color = Color.White,
                        fontFamily = dinRoundFamily,
                        fontWeight = FontWeight.W600
                    )
                }
            }
        }
    }
}

//Ranks
class Students(
    var nickname : String,
    var xp : Int
)





var Ranks = mutableListOf<Students>()








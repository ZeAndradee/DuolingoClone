package com.example.compose1

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose1.ui.theme.dinRoundFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Ranks
interface Student{
    var nickname : String
    var xp : Int
}
class MainStudent (
    override var nickname: String,
    override var xp: Int
) : Student

class Students (
    override var nickname : String,
    override var xp : Int
): Student

var Ranks = mutableStateListOf<Student>()
var You = MainStudent("ZeAndrade", 360)
var sortedRanks = mutableStateListOf<Student>()

//Beginning Screen
@Composable
fun RankScreen(navController: NavHostController){

    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF141f23))
    ){
        //BackScreen
        Box (modifier = Modifier
            .fillMaxSize()
            .padding(top = 96.dp, bottom = 81.dp)

        ){
            Column(modifier = Modifier
                .fillMaxSize()

                .verticalScroll(rememberScrollState())) {


                //List Declaration

                Ranks.clear()
                val student1 = Students("Zythee", 445)
                val student2 = Students("Randall", 220)
                val student3 = Students("Guilherme", 110)

                Ranks.add(You)
                Ranks.addAll(listOf(student1,student2,student3))

                LaunchedEffect(Unit) {
                    withContext(Dispatchers.Default) {
                        for (i in 5..30){
                            val student = Students("Student$i",i*10)
                            withContext(Dispatchers.Main){
                                Ranks.add(student)
                                sortedRanks = Ranks.sortedWith(
                                    compareByDescending {
                                        it.xp
                                    }
                                ).toMutableStateList()
                            }
                        }

                    }
                }



                //End List Declaration

                var position = 1

                for (i in sortedRanks){
                   if (position == 8){
                       Row (modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp), horizontalArrangement = Arrangement.Center){
                           Icon(painter = painterResource(id = R.drawable.green_arrow) , contentDescription = null, tint = Color.Unspecified, modifier = Modifier .height(18.dp))
                           Text("ZONA DE PROMOÇÃO", modifier=Modifier .padding(start=15.dp,end=15.dp), color = Color(0xFF79b933), fontFamily = dinRoundFamily, fontWeight = FontWeight.W600)
                           Icon(painter = painterResource(id = R.drawable.green_arrow) , contentDescription = null, tint = Color.Unspecified, modifier = Modifier .height(18.dp))
                       }
                   }
                    if (position == 24){
                        Row (modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), horizontalArrangement = Arrangement.Center){
                            Icon(painter = painterResource(id = R.drawable.red_arrow) , contentDescription = null, tint = Color.Unspecified, modifier = Modifier .height(18.dp))
                            Text("ZONA DE REBAIXAMENTO", modifier=Modifier .padding(start=15.dp,end=15.dp), color = Color(0xFFd84848), fontFamily = dinRoundFamily, fontWeight = FontWeight.W600)
                            Icon(painter = painterResource(id = R.drawable.red_arrow) , contentDescription = null, tint = Color.Unspecified, modifier = Modifier .height(18.dp))
                        }
                    }
                   Row (modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 15.dp, end = 15.dp),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.SpaceBetween
                   )
                   {
                        Row (modifier = Modifier .padding(top=10.dp, bottom = 10.dp), verticalAlignment = Alignment.CenterVertically){
                            Row (modifier = Modifier
                                .width(30.dp)
                                .padding(end = 10.dp),
                                horizontalArrangement = Arrangement.Center){

                                val color = when{
                                    position < 8 -> Color(0xFF79b933)
                                    position > 23 -> Color(0xFFd84848)
                                    else -> Color.White
                                }

                                Text("$position",
                                    color = color,
                                    fontSize = 17.sp,
                                    fontFamily = dinRoundFamily,
                                    fontWeight = FontWeight.W600
                                )
                            }

                            position+=1
                            Box(modifier = Modifier
                                .clip(CircleShape)
                                .height(42.dp)
                                .width(42.dp)
                                .background(Color.Cyan)
                                .padding(end = 18.dp)
                            )
                            Text("${i.nickname}",modifier= Modifier .padding(start = 17.dp),color = Color.White,fontSize = 18.sp, fontFamily = dinRoundFamily, fontWeight = FontWeight.W600)

                        }
                       Text("${i.xp} XP",modifier= Modifier ,color = Color.White,fontSize = 17.sp, fontFamily = dinRoundFamily, fontWeight = FontWeight.W600)
                   }

                }
            }

        }
        Box (modifier = Modifier .align(Alignment.TopCenter)){

        }

        Box (modifier = Modifier .align(Alignment.BottomCenter)){
            BottomMenu(navController = navController)
        }


    }
}
package com.example.jetpackage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))
        TopBar(name = "Arbaz kavathekar ", modifier = Modifier.padding(10.dp))
        ProfileSection()
        Spacer(modifier =Modifier.height(25.dp) )
        ButtonSection()
        Spacer(modifier = Modifier.height(25.dp))
        HightlightSection(
            highlights = listOf(
                ImageWithText(
                image = painterResource(
                    id = R.drawable.youtube),
                    text = "YouTube"
               ),
                ImageWithText(
                    image = painterResource(
                        id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(
                        id = R.drawable.discord),
                    text = "Discord"
                ), ImageWithText(
                    image = painterResource(
                        id = R.drawable.telegram)
                    ,text = "Telegram"
                )
            ),

        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0-> PostsSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
            1-> PostsSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }



    }
}

@Composable
fun TopBar(name:String
           ,modifier: Modifier=Modifier
){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()

    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }

}

@Composable
fun ProfileSection(
    modifier: Modifier=Modifier
){
    Column (
        modifier=Modifier.fillMaxWidth()
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        ){
            RoundImage(
                image = painterResource(id = R.drawable.arbaz),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))

            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDescription(
            displayname = "Android Developer",
            description ="2 years of coding experience \n"+
                    "Want me to make your app? Send me an email! \n" +
                    "Mobile Legends Superstar ? Subscribe to my channel!",
            url = "https:/youtube.com/c/Arbazkavathekar",
            followedBy = listOf("codingflow","miakhalifa"),
            otherCount =17
        )
    }

}

@Composable
fun RoundImage(
    image:Painter,
    modifier: Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border
                (
                width = 1.dp,
                shape = CircleShape,
                color = Color.Gray
            )
            .padding(3.dp)
            .clip(CircleShape)

    )

    
}
@Composable
fun StatSection(
    modifier: Modifier=Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
        ){
        ProfileStat(numberText = "610", text = "posts")
        ProfileStat(numberText = "2.5 M", text = "followers")
        ProfileStat(numberText = "0", text = "following")


    }

}

@Composable
fun ProfileStat(
    numberText:String,
    text:String,
    modifier: Modifier=Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(text =text,)

        

    }

}

@Composable
fun ProfileDescription(
    displayname:String,
    description:String,
    url:String,
    followedBy: List<String>,
    otherCount:Int
){
    val letterSpacing=0.5.sp
    val lineHeight= 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text =displayname,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text =description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text =url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle=SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size-1){
                            append(", ")
                        }
                    }
                    if (otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing=letterSpacing,
                lineHeight=lineHeight
            )
        }

    }


}
@Composable
fun ButtonSection(
    modifier: Modifier= Modifier
){
    val minWidth=95.dp
    val height=30.dp
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()

    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
             modifier = modifier
                 .defaultMinSize(minWidth)
                 .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = modifier
                .defaultMinSize(minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .size(height)
        )

    }

}



@Composable
fun ActionButton(
    modifier: Modifier,
    text:String? = null,
    icon:ImageVector?=null
){

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text!=null)
            Text(text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        
        if(icon!=null)
            Icon(imageVector = icon,
                contentDescription =null,
                tint = Color.Black
                )


    }
}
@Composable
fun HightlightSection(
    modifier: Modifier=Modifier,
    highlights: List<ImageWithText>
){
    LazyRow(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        items(highlights.size){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(end=15.dp)
            ) {
                RoundImage(image = highlights[it].image
                    , modifier =modifier.size(70.dp)
                )

                Text(text = highlights[it].text,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }

}

@Composable
fun PostTabView(
    imageWithText: List<ImageWithText>,
    modifier:Modifier = Modifier,
    onTabSelected:(selectedIndex:Int)->Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    val inactiveColor= Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
        ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == 0,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription =item.text,
                    tint = if (selectedTabIndex==index) Color.Black else inactiveColor,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostsSection(
    posts:List<Painter>,
    modifier: Modifier=Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier=modifier.scale(1.01f)
    ) {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.Gray
                    )
            )
        }
        
    }

}






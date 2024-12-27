package com.example.temupagedesignsample.ui.screen

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.temupagedesignsample.Category
import com.example.temupagedesignsample.R
import com.example.temupagedesignsample.data.entity.Toys
import com.example.temupagedesignsample.getAllCategories
import com.example.temupagedesignsample.ui.component.CategoryCircle
import com.example.temupagedesignsample.ui.theme.greenTextColor
import com.example.temupagedesignsample.ui.theme.selectedNavItemColor
import kotlin.math.max
import kotlin.math.truncate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    val rowScrollState = rememberScrollState()
    val rowScrollState2 = rememberScrollState()

    val toysList = remember {
        mutableStateListOf<Toys>()
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        val t1 = Toys(1,"toyship","980 adet Askeri 8 IN 1 Ordu Okyanus Kruvazörü Savaş Gemisi Yapı Taşları, Uçak Silah Gemisi Tuğlaları, Şehir Oyuncakları",114,"3,7bin+",262.74)
        val t2 = Toys(2,"toysuzhougarden","3000 adet Suzhou Bahçe Serisi Yapı Blokları Seti, 3'ü 1 arada Mimarlık Teması, ABS Plastik, Karışık Renk, Yetişkinler için DIY Model Oyuncak, Ev Dekoru, Tatil Hediyesi, Doğum Günü Hediyesi - Hediye Kutusu Yok",186,"1,1bin+",785.66)
        val t3 = Toys(3,"toyraptorplane","1 adet F-22 Raptor Savaş Uçağı Modeli, Yüksek Hassasiyetli Metal Koleksiyon, Akustik-Optik Alaşım, Ev Dekorasyonu Sergisi, Askeri Uçak Tutkunları Koleksiyonu",75,"8,5bin+",390.17)
        val t4 = Toys(4,"toyblacktower","1089 Parça Film İlhamlı Siyah Kule Yapı Blokları Seti - Hayranlar İçin Mükemmel, Koleksiyonluk Oda Dekoru & Yetişkinler İçin Hediye Fikri - Dayanıklı ABS Malzeme",11,"1,8bin+",977.32)
        val t5 = Toys(5,"toysportcar","Şık, Koleksiyonluk Alaşımlı Spor Araba Modeli Açılır Kapılarla - Karışık Renkler, Sergi & Oyun için Metal Oyuncak Araç",17,"100bin+",184.92)
        val t6 = Toys(6,"toylegocar","455 Parça Spor Araba Yapım Blokları: Yarış Arabası Montaj Oyuncak Seti, Araç Temalı, 6-8 Yaş Aralığına Uygun, ABS Malzemeden",70,"100bin+",297.40)
        val t7 = Toys(7,"toyblockpuzzle","120 Seviye Gizli Blok Bulmaca: 3+ Yaş, ABS Malzeme, Mantık ve Uzamsal Düşünme Yeteneğini Geliştirir, 3-8 Yaş Arası Çocuklar İçin Uygundur",1146,"28bin+",115.51)
        val t8 = Toys(8,"toyblocksset","1 Set Mıknatıslı Yapı Blokları Seti, Depolama Kutulu Dönüştürülebilir Mühendislik Araçları, 3-5 Yaş Çocuklar İçin Eğitici Oyuncak, Yaratıcı Açık Hava Oyunu, Yeşil Plastik Yapım Seti",27,"976",1039.50)
        toysList.add(t1)
        toysList.add(t2)
        toysList.add(t3)
        toysList.add(t4)
        toysList.add(t5)
        toysList.add(t6)
        toysList.add(t7)
        toysList.add(t8)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                content = {
                    NavigationBarItem(
                        selected = false,
                        label = { Text("Ana Sayfa", color = selectedNavItemColor) },
                        onClick = {},
                        icon = { Icon(painterResource(R.drawable.home_icon), "", Modifier.size(28.dp), selectedNavItemColor) }
                    )
                    NavigationBarItem(
                        selected = false,
                        label = { Text("Kategoriler") },
                        onClick = {},
                        icon = { Icon(painterResource(R.drawable.categories_icon), "", Modifier.size(28.dp), Color.Black) }
                    )
                    NavigationBarItem(
                        selected = false,
                        label = { Text("Siz") },
                        onClick = {},
                        icon = { Icon(painterResource(R.drawable.person_icon), "", Modifier.size(28.dp), Color.Black) }
                    )
                    NavigationBarItem(
                        selected = false,
                        label = { Text("Sepet") },
                        onClick = {},
                        icon = { Icon(painterResource(R.drawable.cart_icon), "", Modifier.size(28.dp), Color.Black) }
                    )
                },
                containerColor = Color.White,
                modifier = Modifier.height((screenHeight/9).dp),
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp, start = 18.dp, end = 18.dp).height((screenHeight/20).dp).background(Color.White).border(color = Color.Black, width = 1.dp, shape = RoundedCornerShape(30.dp)).clip(
                    RoundedCornerShape(30.dp)
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {}) {
                        Icon(painterResource(R.drawable.camera_icon),"", modifier = Modifier.fillMaxHeight().padding(all = 7.dp))
                    }
                    FilledIconButton (
                        onClick = {},
                        modifier = Modifier.width((screenWidth/8).dp).padding(top = 3.dp, bottom = 3.dp, end = 3.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = IconButtonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            disabledContainerColor = Color.White,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Icon(painterResource(R.drawable.search_icon),"", modifier = Modifier.fillMaxHeight().padding(all = 7.dp))
                    }
                }
            }
            Row(
                modifier = Modifier.horizontalScroll(rowScrollState).height((screenHeight/15).dp).padding(top = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                for (category in getAllCategories()) {
                    if(category == Category.OYUNCAK) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = category.value,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                fontWeight = FontWeight.W400,
                                fontSize = 16.sp,
                            )
                            Box(
                                modifier = Modifier.width((screenWidth/23).dp).height(3.dp).border(2.dp, color = Color.Black)
                            )
                        }

                    } else {
                        Text(
                            text = category.value,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            fontWeight = FontWeight.W400,
                            fontSize = 16.sp
                        )
                    }

                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().height((screenHeight/20).dp).background(color = Color(0xFFFEEEE0)).padding(top = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("✓ Ücretsiz kargo", color = greenTextColor, fontSize = 14.sp, fontWeight = FontWeight.W500)
                Text(" | ", color = Color(0xFFD1C7BA), fontSize = 17.sp)
                Text(" ✓ 30 gün içinde fiyat ayarlaması", color = greenTextColor, fontSize = 14.sp, fontWeight = FontWeight.W500)
            }
            Row(
                modifier = Modifier.padding(start = 3.dp, end = 3.dp, top = 10.dp, bottom = 10.dp).horizontalScroll(rowScrollState2),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.padding(start = 13.dp, end = 13.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(R.drawable.tumu_img),
                        "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(60.dp).clip(CircleShape).border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    )
                    Text("Tümü", fontSize = 13.sp, color = Color.Black, modifier = Modifier.padding(top = 10.dp))
                }
                CategoryCircle(R.drawable.secimler_img, "Şeçimler")
                CategoryCircle(R.drawable.oyuncaklar_img, "Oyuncaklar")
                CategoryCircle(R.drawable.parti_img, "Parti")
                CategoryCircle(R.drawable.kumandali_img, "Kumandalı")
                CategoryCircle(R.drawable.kostum_img, "Kostümler")
                CategoryCircle(R.drawable.sanat_img, "Sanat")
            }
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(0.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(
                    count = toysList.count(),
                    itemContent = {
                        val toy = toysList[it]
                        Card(
                            shape = RoundedCornerShape(0.dp),
                            modifier = Modifier.padding(all = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                            ) {
                                val activity = (LocalContext.current as Activity)
                                Image(
                                    bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(toy.image,"drawable", activity.packageName)),
                                    contentDescription = "",
                                    modifier = Modifier.size(200.dp, 200.dp)
                                )
                                Text("${toy.name}", fontSize = 12.sp, maxLines = 1, color = Color.Black)
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(start = 2.dp),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(painterResource(R.drawable.star_icon),"", modifier = Modifier.height(16.dp).width(16.dp))
                                    Icon(painterResource(R.drawable.star_icon),"", modifier = Modifier.height(16.dp).width(16.dp))
                                    Icon(painterResource(R.drawable.star_icon),"", modifier = Modifier.height(16.dp).width(16.dp))
                                    Icon(painterResource(R.drawable.star_icon),"", modifier = Modifier.height(16.dp).width(16.dp))
                                    Icon(painterResource(R.drawable.star_icon),"", modifier = Modifier.height(16.dp).width(16.dp))
                                    Text("${toy.commentNumber}", fontSize = 13.sp, color = Color.Gray, modifier = Modifier.padding(start = 4.dp))
                                }
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(start = 2.dp),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("${toy.price} TL", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(start = 2.dp))
                                    Text("${toy.numberOfSales} adet satıldı", fontSize = 9.sp, color = Color.Gray, modifier = Modifier.padding(start = 5.dp))
                                    Box(
                                        modifier = Modifier.height((screenHeight/24).dp).width((screenWidth/10).dp).padding(3.dp).background(Color.White).border(color = Color.Black, width = 1.dp, shape = RoundedCornerShape(30.dp)).clip(
                                            RoundedCornerShape(30.dp)
                                        ),
                                    ) {
                                        FilledIconButton (
                                            onClick = {},
                                            modifier = Modifier.fillMaxSize(),
                                            shape = RoundedCornerShape(30.dp),
                                            colors = IconButtonColors(
                                                containerColor = Color.White,
                                                contentColor = Color.Black,
                                                disabledContainerColor = Color.White,
                                                disabledContentColor = Color.White
                                            )
                                        ) {
                                            Icon(painterResource(R.drawable.add_cart_icon),"", modifier = Modifier.fillMaxHeight().padding(all = 6.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}
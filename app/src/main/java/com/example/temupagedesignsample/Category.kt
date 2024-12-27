package com.example.temupagedesignsample

enum class Category(val value: String) {
    OYUNCAK("Oyuncak"),
    OTOMOTIV("Otomotiv"),
    OFIS("Ofis"),
    ELSANATLARI("El Sanatları"),
    BEBEK("Bebek"),
    SAGLIK("Sağlık"),
    EV("Ev"),
    BAHCE("Bahçe"),
    EVCILHAYVANLAR("Evcil Hayvanlar"),
    MUZIKAL("Müzikal"),
    CIHAZLAR("Cihazlar")
}

fun getAllCategories() : List<Category> {
    return listOf(
        Category.OYUNCAK,
        Category.OTOMOTIV,
        Category.OFIS,
        Category.ELSANATLARI,
        Category.BEBEK,
        Category.SAGLIK,
        Category.EV,
        Category.BAHCE,
        Category.EVCILHAYVANLAR,
        Category.MUZIKAL,
        Category.CIHAZLAR)
}
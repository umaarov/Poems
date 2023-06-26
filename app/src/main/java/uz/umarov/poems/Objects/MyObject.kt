package uz.umarov.poems.Objects

import uz.umarov.poems.Models.PoemsData

object MyObject {

    val new_poems = ArrayList<PoemsData>()
    val fav_poems = ArrayList<PoemsData>()
    val love_poems = ArrayList<PoemsData>()
    val cringe_poems = ArrayList<PoemsData>()

    fun load() {

        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )
        new_poems.add(
            PoemsData("", "")
        )

        love_poems.add(
            PoemsData("", "")
        )
        love_poems.add(
            PoemsData("", "")
        )
        love_poems.add(
            PoemsData("", "")
        )
        love_poems.add(
            PoemsData("", "")
        )
        love_poems.add(
            PoemsData("", "")
        )
        love_poems.add(
            PoemsData("", "")
        )

        cringe_poems.add(
            PoemsData("", "")
        )
        cringe_poems.add(
            PoemsData("", "")
        )
        cringe_poems.add(
            PoemsData("", "")
        )
        cringe_poems.add(
            PoemsData("", "")
        )
        cringe_poems.add(
            PoemsData("", "")
        )
        cringe_poems.add(
            PoemsData("", "")
        )
    }
}
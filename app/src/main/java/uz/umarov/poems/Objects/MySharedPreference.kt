package uz.umarov.poems.Objects


import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.umarov.poems.Models.PoemsData

object MySharedPreference {
    private const val NAME = "poem"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply(

        )
    }

    var list: ArrayList<PoemsData>
        get() = stringToArray(sharedPreferences.getString("list", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("list", arrayToString(value))
        }

    private fun stringToArray(str:String):ArrayList<PoemsData>{
        val gson = Gson()
        val list = ArrayList<PoemsData>()

        val type = object : TypeToken<ArrayList<PoemsData>>(){}.type
        list.addAll(gson.fromJson(str, type))

        return list
    }

    private fun arrayToString(list: ArrayList<PoemsData>): String {
        return Gson().toJson(list)
    }
}
package kg.example.hm_07_m03

import android.media.Image
import java.io.Serializable

data class CarModel (
    val image: String,
    val description: String,
    val name: String) : Serializable
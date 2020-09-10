package com.example.coronaapp

object CoronaData {
    private val heroNames = arrayOf("Ahmad Dahlan",
        "Ahmad Yani",
        "Sutomo",
        "Gatot Soebroto",
        "Ki Hadjar Dewantarai",
        "Mohammad Hatta",
        "Soedirman",
        "Soekarno",
        "Soepomo",
        "Tan Malaka")


    private  val provinsi = listOf<String>(
        "DKI Jakarta",
        "Jawa Barat",
        "Jawa Timur",
        "Banten",
        "Jawa Tengah",
        "Sulawesi Selatan",
        "Bali",
        "Sumatera Utara",
        "DIY Yogya",
        "Papua"
    )

    private val totalCases = arrayOf(
        1706, 376, 223, 218, 144,138, 63, 59, 41, 38
    )

    private val deathCases = arrayOf<Int>(
        82, 19, 49, 7, 18,  23, 18, 0, 6 , 3
    )

    private val recoveriesCases = arrayListOf<Int>(
       142, 40, 17, 20, 22, 8,2, 4, 7, 2
    )


    private val provinsiImages = intArrayOf(
        R.drawable.jakarta,
        R.drawable.jabar,
        R.drawable.jatim,
        R.drawable.banten,
        R.drawable.jateng,
        R.drawable.sulsel,
        R.drawable.bali,
        R.drawable.sumut,
        R.drawable.jogja,
        R.drawable.papua
    )

    val listData: ArrayList<Corona>
        get() {
         val list = arrayListOf<Corona>()

            for (i in provinsi.indices){
                val corona = Corona()
                corona.name = provinsi[i]
                corona.total = totalCases[i]
                corona.death = deathCases[i]
                corona.recoveries = recoveriesCases[i]
                corona.photo = provinsiImages[i]

                list.add(corona)
            }
            return list
        }

}
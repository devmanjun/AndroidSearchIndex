package com.mvs.androidsearchindex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class MainActivity : AppCompatActivity(), AlphabetClickListener {

    private val alphabetsList = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    private val contentSampleList = listOf<String>("unreverberated", "bobble", "postmeiotic", "syndiotactic", "islamize", "enone", "desalination",
            "gasthauses", "gendarmerie", "intractability", "reidentified", "heartthrob", "isolative", "avowed", "headstrong",
            "hyrnetho", "colorationally", "unrefractive", "luces", "stumpiness", "vixenishness", "doisy", "fishiest", "misesteem",
            "felicitated", "lesbianism", "escutcheoned", "unroll", "revacating", "aphrodite", "antetype", "ophoric", "gist",
            "stockateer", "sugary", "fmn", "cordial", "partialising", "kistvaen", "fortaleza", "obad", "hagiographer", "maidenship",
            "marasmus", "fissureless", "airt", "noncondensibility", "kinematics", "indecipherability", "monophysitic",
            "heshvan", "purusha", "fixt", "morpho", "languidness", "electrolysed", "overflowingly", "dodecastylos", "bowdlerize", "wager",
            "unassailable", "nowel", "impactite", "echinoid", "dankness", "cooner", "parentalia", "chemonite", "factitive", "lunch", "unscanty",
            "dianthuses", "drover", "squintingly", "oscitancy", "barbarity", "consentient", "princess", "transpleural", "sceptical",
            "unpargeted", "joyfulness", "algy", "discolor", "feeling", "nonadjacency", "corpse", "tuberculoid", "cirque", "konstantin",
            "lobstick", "bafflingness", "appellatively", "unperiphrastically", "redecay", "menshevik", "vidicon", "manta", "snakily"
    )

    private val contentList = contentSampleList.sorted()
    var recyclerViewContent: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("mvs" + contentList.size)
        println("mvs" + alphabetsList)
        intiViews()

    }

    private fun intiViews() {

        val recyclerView: RecyclerView = findViewById(R.id.rv_alphabets)
        val alphabetAdapter = AlphabetAdapter(alphabetsList, this, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = alphabetAdapter


        recyclerViewContent = findViewById(R.id.rv__main_list)
        val contentListAdapter = MainListAdapter(contentList, this)

        recyclerViewContent?.layoutManager = LinearLayoutManager(this)
        recyclerViewContent?.adapter = contentListAdapter
    }

    override fun onAlphabetClicked(alphabet: Char) {
        Log.i("MVS", alphabet + "")
        Log.i("MVS", contentList.toString())
        var data = contentList.indexOfFirst { it -> it.startsWith(alphabet, ignoreCase = true) }
        if (data >= 0) {
//            recyclerViewContent?.layoutManager?.scrollToPosition(data)

            var childCount: Int? = recyclerViewContent?.layoutManager?.childCount
            val totalChildren = contentList.size
            if (childCount != null) {
                childCount /= 4
                if (childCount + data < totalChildren && data-childCount > 0) {
                    data += childCount
                }
            }
            recyclerViewContent?.layoutManager?.smoothScrollToPosition(recyclerViewContent, RecyclerView.State(), data)

        }

    }


}

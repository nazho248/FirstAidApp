package com.project.firstaid.fragments_Information

data class ParentData(
    val parentTitle:String?=null,
    var type:Int = Constants.PARENT,
    var subList : MutableList<ChildData> = ArrayList(),
    var isExpanded:Boolean = false
)


object Constants {
    const val PARENT = 0
    const val CHILD = 1
}
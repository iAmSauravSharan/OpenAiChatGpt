package com.sauravsharan.response.edit

data class EditChoice(

    /**
     * The edited text.
     */
    var text: String? = null,

    /**
     * This index of this completion in the returned list.
     */
    var index: Int = 0

)

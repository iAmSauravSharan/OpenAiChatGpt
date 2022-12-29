package com.sauravsharan.request.moderation

data class ModerationRequest(

    /**
     * The input text to classify.
     */
    var input: String,

    /**
     * The name of the model to use, defaults to text-moderation-stable.
     */
    var model: String? = null

)

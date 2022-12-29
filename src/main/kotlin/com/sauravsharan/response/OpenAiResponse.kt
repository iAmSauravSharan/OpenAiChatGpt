package com.sauravsharan.response

data class OpenAiResponse<T>(
    /**
     * A list containing the actual results
     */
    var data: List<T>? = null,

    /**
     * The type of object returned, should be "list"
     */
    var `object`: String? = null
)
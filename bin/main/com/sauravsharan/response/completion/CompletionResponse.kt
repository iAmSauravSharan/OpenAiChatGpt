package com.sauravsharan.response.completion


data class CompletionResponse(
    /**
     * A unique id assigned to this completion.
     */
    var id: String? = null,

    /**
     * The type of object returned, should be "text_completion"
     */
    var `object`: String? = null,

    /**
     * The creation time in epoch seconds.
     */
    var created: Long = 0,

    /**
     * The GPT-3 model used.
     */
    var model: String? = null,

    /**
     * A list of generated completions.
     */
    var choices: List<CompletionChoice>? = null,

    /**
     * The API usage for this request
     */
    var usage: Usage? = null
)

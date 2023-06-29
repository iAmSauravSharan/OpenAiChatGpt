package com.sauravsharan.response.edit

import com.sauravsharan.response.completion.Usage

data class EditResponse(
    /**
     * The type of object returned, should be "edit"
     */
    var `object`: String? = null,

    /**
     * The creation time in epoch milliseconds.
     */
    var created: Long = 0,

    /**
     * A list of generated edits.
     */
    var choices: List<EditChoice>? = null,

    /**
     * The API usage for this request
     */
    var usage: Usage? = null
)

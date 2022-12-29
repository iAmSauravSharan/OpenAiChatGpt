package com.sauravsharan.response.moderation

data class ModerationResponse(
    /**
     * A unique id assigned to this moderation.
     */
    var id: String? = null,

    /**
     * The GPT-3 model used.
     */
    var model: String? = null,

    /**
     * A list of moderation scores.
     */
    var results: List<Moderation>? = null
)
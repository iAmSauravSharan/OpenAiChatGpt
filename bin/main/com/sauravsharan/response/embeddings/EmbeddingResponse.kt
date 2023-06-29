package com.sauravsharan.response.embeddings

import com.sauravsharan.response.completion.Usage

data class EmbeddingResponse (
    /**
     * The GPT-3 model used for generating embeddings
     */
    var model: String? = null,

    /**
     * The type of object returned, should be "list"
     */
    var `object`: String? = null,

    /**
     * A list of the calculated embeddings
     */
    var data: List<Embedding>? = null,

    /**
     * The API usage for this request
     */
    var usage: Usage? = null
)

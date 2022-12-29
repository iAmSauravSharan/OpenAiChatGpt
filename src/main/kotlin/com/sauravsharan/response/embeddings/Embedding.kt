package com.sauravsharan.response.embeddings

data class Embedding(

    /**
     * The type of object returned, should be "embedding"
     */
    var `object`: String? = null,

    /**
     * The embedding vector
     */
    var embedding: List<Double>? = null,

    /**
     * The position of this embedding in the list
     */
    var index: Int = 0

)

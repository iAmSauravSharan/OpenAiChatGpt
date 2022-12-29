package com.sauravsharan.response.model

data class Permission (
    /**
     * An identifier for this model permission
     */
    var id: String? = null,

    /**
     * The type of object returned, should be "model_permission"
     */
    var `object`: String? = null,

    /**
     * The creation time in epoch seconds.
     */
    var created: Long = 0,
    var allowCreateEngine: Boolean = false,
    var allowSampling: Boolean = false,
    var allowLogProbs: Boolean = false,
    var allowSearchIndices: Boolean = false,
    var allowView: Boolean = false,
    var allowFineTuning: Boolean = false,
    var organization: String? = null,
    var group: String? = null,
    var isBlocking: Boolean = false
)

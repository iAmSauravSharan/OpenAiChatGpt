package com.sauravsharan.response.model


/**
 * GPT-3 model details
 *
 * https://beta.openai.com/docs/api-reference/models
 */
data class Model(
    /**
     * An identifier for this model, used to specify the model when making completions, etc
     */
    var id: String,

    /**
     * The type of object returned, should be "model"
     */
    var `object`: String? = null,

    /**
     * The owner of the GPT-3 model, typically "openai"
     */
    var ownedBy: String? = null,

    /**
     * List of permissions for this model
     */
    var permission: List<Permission>? = null,

    /**
     * The root model that this and its parent (if applicable) are based on
     */
    var root: String? = null,

    /**
     * The parent model that this is based on
     */
    var parent: String? = null
)
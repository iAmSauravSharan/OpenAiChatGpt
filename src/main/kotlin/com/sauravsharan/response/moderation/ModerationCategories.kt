package com.sauravsharan.response.moderation

import com.fasterxml.jackson.annotation.JsonProperty


data class ModerationCategories(
    var hate: Boolean = false,

    @JsonProperty("hate/threatening")
    var hateThreatening: Boolean = false,

    @JsonProperty("self-harm")
    var selfHarm: Boolean = false,

    var sexual: Boolean = false,

    @JsonProperty("sexual/minors")
    var sexualMinors: Boolean = false,

    var violence: Boolean = false,

    @JsonProperty("violence/graphic")
    var violenceGraphic: Boolean = false
)

package com.sauravsharan.response.moderation

import com.fasterxml.jackson.annotation.JsonProperty

data class ModerationCategoryScores(

    var hate: Double? = null,

    @JsonProperty("hate/threatening")
    var hateThreatening: Double? = null,

    @JsonProperty("self-harm")
    var selfHarm: Double? = null,

    var sexual: Double? = null,

    @JsonProperty("sexual/minors")
    var sexualMinors: Double? = null,

    var violence: Double? = null,

    @JsonProperty("violence/graphic")
    var violenceGraphic: Double? = null
)

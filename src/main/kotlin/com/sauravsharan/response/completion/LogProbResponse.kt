package com.sauravsharan.response.completion

import com.sauravsharan.request.completion.CompletionRequest




data class LogProbResponse(
    /**
     * The tokens chosen by the completion api
     */
    var tokens: List<String>? = null,

    /**
     * The log probability of each token in [tokens]
     */
    var tokenLogprobs: List<Double>? = null,

    /**
     * A map for each index in the completion result.
     * The map contains the top [CompletionRequest.logprobs] tokens and their probabilities
     */
    var topLogprobs: List<Map<String, Double>>? = null,

    /**
     * The character offset from the start of the returned text for each of the chosen tokens.
     */
    var textOffset: List<Int>? = null
)
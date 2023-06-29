package com.sauravsharan.response.completion

import com.sauravsharan.request.completion.CompletionRequest


data class CompletionChoice(
    /**
     * The generated text. Will include the prompt if [CompletionRequest.echo] is true
     */
    var text: String? = null,

    /**
     * This index of this completion in the returned list.
     */
    var index: Int? = null,

    /**
     * The log probabilities of the chosen tokens and the top [CompletionRequest.logprobs] tokens
     */
    var logprobs: LogProbResponse? = null,

    /**
     * The reason why GPT-3 stopped generating, for example "length".
     */
    var finish_reason: String? = null
)

package com.sauravsharan.response.fine_tune

data class HyperParameters (
    /**
     * The batch size to use for training.
     */
    var batchSize: String? = null,

    /**
     * The learning rate multiplier to use for training.
     */
    var learningRateMultiplier: Double? = null,

    /**
     * The number of epochs to train the model for.
     */
    var nEpochs: Int? = null,

    /**
     * The weight to use for loss on the prompt tokens.
     */
    var promptLossWeight: Double? = null
)

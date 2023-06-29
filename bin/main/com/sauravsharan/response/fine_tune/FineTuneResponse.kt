package com.sauravsharan.response.fine_tune

import com.sauravsharan.response.file.File

data class FineTuneResponse (
    /**
     * The ID of the fine-tuning job.
     */
    var id: String? = null,

    /**
     * The type of object returned, should be "fine-tune".
     */
    var `object`: String? = null,

    /**
     * The name of the base model.
     */
    var model: String? = null,

    /**
     * The creation time in epoch seconds.
     */
    var createdAt: Long? = null,

    /**
     * List of events in this job's lifecycle. Null when getting a list of fine-tune jobs.
     */
    var events: List<FineTuneEvent>? = null,

    /**
     * The ID of the fine-tuned model, null if tuning job is not finished.
     * This is the id used to call the model.
     */
    var fineTunedModel: String? = null,

    /**
     * The specified hyper-parameters for the tuning job.
     */
    var hyperparams: HyperParameters? = null,

    /**
     * The ID of the organization this model belongs to.
     */
    var organizationId: String? = null,

    /**
     * Result files for this fine-tune job.
     */
    var resultFiles: List<File>? = null,

    /**
     * The status os the fine-tune job. "pending", "succeeded", or "cancelled"
     */
    var status: String? = null,

    /**
     * Training files for this fine-tune job.
     */
    var trainingFiles: List<File>? = null,

    /**
     * The last update time in epoch seconds.
     */
    var updatedAt: Long? = null,

    /**
     * Validation files for this fine-tune job.
     */
    var validationFiles: List<File>? = null
)

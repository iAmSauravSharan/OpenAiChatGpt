package com.sauravsharan.request.images

import com.fasterxml.jackson.annotation.JsonProperty

data class ImageEditRequest(

    /**
     * The image to edit. Must be a valid PNG file, less than 4MB, and square.
     * If mask is not provided, image must have transparency, which will be used as the mask.
     */
    val image: String,

    /**
     * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where image should be edited.
     * Must be a valid PNG file, less than 4MB, and have the same dimensions as image
     */
    val mask: String? = null,

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    val n: Int = 1,

    /**
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024
     */
    val size: String = "1024x1024",

    /**
     * The format in which the generated images are returned. Must be one of
     * url or b64_json
     */
    @JsonProperty("response_format")
    val responseFormat: String = "url",

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor
     * and detect abuse
     */
    var user: String? = null

)

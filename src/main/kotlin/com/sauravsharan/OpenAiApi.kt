package com.sauravsharan

import com.sauravsharan.OpenAi
import com.sauravsharan.request.completion.CompletionRequest
import com.sauravsharan.request.edit.EditRequest
import com.sauravsharan.request.embeddings.EmbeddingRequest
import com.sauravsharan.request.fine_tune.FineTuneRequest
import com.sauravsharan.request.images.ImageEditRequest
import com.sauravsharan.request.images.ImageGenerationRequest
import com.sauravsharan.request.images.ImageVariationRequest
import com.sauravsharan.request.moderation.ModerationRequest
import com.sauravsharan.response.completion.CompletionResponse
import com.sauravsharan.response.edit.EditResponse
import com.sauravsharan.response.embeddings.EmbeddingResponse
import com.sauravsharan.response.file.DeleteResponse
import com.sauravsharan.response.file.File
import com.sauravsharan.response.fine_tune.FineTuneEvent
import com.sauravsharan.response.fine_tune.FineTuneResponse
import com.sauravsharan.response.images.ImageResponse
import com.sauravsharan.response.model.Model
import com.sauravsharan.response.moderation.ModerationResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

class OpenAiApi(private val api: OpenAi) {


    fun listModels(): List<Model>? {
        return api.listModels().blockingGet().data
    }

    fun getModel(modelId: String): Model {
        return api.getModel(modelId).blockingGet()
    }

    fun createCompletion(request: CompletionRequest): CompletionResponse {
        return api.createCompletion(request).blockingGet()
    }

    fun createEdit(request: EditRequest): EditResponse {
        return api.createEdit(request).blockingGet()
    }

    @POST("images/generations")
    fun generateImages(@Body request: ImageGenerationRequest):
            ImageResponse {
        return api.generateImages(request).blockingGet()
    }

    @Multipart
    @POST("images/edits")
    fun editImage(@Body request: ImageEditRequest):
            ImageResponse {
        val image = java.io.File(request.imagePath)
        val prompt = request.prompt.toRequestBody(MultipartBody.FORM)
        val imageBody = image.asRequestBody("text".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("image", image.name, imageBody)

        return api.editImage(
            image = body,
            prompt = prompt
        ).blockingGet()
    }

    @Multipart
    @POST("images/variations")
    fun generateImageVariations(
        @Body request: ImageVariationRequest
    ): ImageResponse {
        val image = java.io.File(request.imagePath)
        val imageBody: RequestBody = image.asRequestBody("image/*".toMediaType())
        val body = MultipartBody.Part.createFormData("image", image.name, imageBody)

        return api.generateImageVariations(
            image = body
        ).blockingGet()
    }

    fun createEmbeddings(request: EmbeddingRequest): EmbeddingResponse {
        return api.createEmbeddings(request).blockingGet()
    }

    fun listFiles(): List<File>? {
        return api.listFiles().blockingGet().data
    }

    fun uploadFile(purpose: String, filepath: String): File? {
        val file = java.io.File(filepath)
        val purposeBody = purpose.toRequestBody(MultipartBody.FORM)
        val fileBody = file.asRequestBody("text".toMediaTypeOrNull())
        val body = MultipartBody.Part.createFormData("file", filepath, fileBody)
        return api.uploadFile(purposeBody, body).blockingGet()
    }

    fun deleteFile(fileId: String): DeleteResponse {
        return api.deleteFile(fileId).blockingGet()
    }

    fun retrieveFile(fileId: String): File {
        return api.retrieveFile(fileId).blockingGet()
    }

    fun createFineTune(request: FineTuneRequest): FineTuneResponse {
        return api.createFineTune(request).blockingGet()
    }

    fun createFineTuneCompletion(request: CompletionRequest): CompletionResponse {
        return api.createFineTuneCompletion(request).blockingGet()
    }

    fun listFineTunes(): List<FineTuneResponse>? {
        return api.listFineTunes().blockingGet().data
    }

    fun retrieveFineTune(fineTuneId: String): FineTuneResponse {
        return api.retrieveFineTune(fineTuneId).blockingGet()
    }

    fun cancelFineTune(fineTuneId: String): FineTuneResponse {
        return api.cancelFineTune(fineTuneId).blockingGet()
    }

    fun listFineTuneEvents(fineTuneId: String): List<FineTuneEvent>? {
        return api.listFineTuneEvents(fineTuneId).blockingGet().data
    }

    fun deleteFineTune(fineTuneId: String): DeleteResponse {
        return api.deleteFineTune(fineTuneId).blockingGet()
    }

    fun createModeration(request: ModerationRequest): ModerationResponse {
        return api.createModeration(request).blockingGet()
    }
}
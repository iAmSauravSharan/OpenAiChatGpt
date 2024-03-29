/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.sauravsharan

import com.sauravsharan.request.completion.CompletionRequest
import com.sauravsharan.request.edit.EditRequest
import com.sauravsharan.request.images.ImageEditRequest
import com.sauravsharan.request.images.ImageGenerationRequest
import com.sauravsharan.request.images.ImageVariationRequest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ChatGPTTest {

    private val API_TOKEN = "ENTER_YOUR_API_KEY_HERE";
    private val api = OpenAiService(API_TOKEN, 502).build();
    private val openAi = OpenAiApi(api)

    @Test
    fun shouldRetrieveAllModels() {
        val list = openAi.listModels();
        println("result -> $list")
        assertTrue { !list.isNullOrEmpty() };
    }

    @Test
    fun shouldRetrieveModelByModelID() {
        val modelId = "babbage";
        val result = openAi.getModel(modelId);
        println("result -> $result")
        assertEquals(modelId, result.id);
    }

    @Test
    fun shouldCreateCompletions() {
        val completionRequest = CompletionRequest(
            model = "babbage",
            prompt = "I am getting silent exception in eclipse debugger",
            temperature = 0.8,
            maxTokens = 100
        )
        val result = openAi.createCompletion(completionRequest);
        println("result -> $result")
        assertTrue { !result.id.isNullOrEmpty() };
    }

    @Test
    fun shouldCreateEditInSentence() {
        val editRequest = EditRequest(
            model = "text-davinci-edit-001",
            instruction = "fix the spelling mistake",
            input = "What day of the wek is it?"
        )
        val result = openAi.createEdit(editRequest);
        println("result -> $result")
        assertTrue { !result.choices.isNullOrEmpty() };
    }

    @Test
    fun shouldGenerateImage() {
        val request = ImageGenerationRequest(
            prompt = "show me a beautiful girl"
        )
        val result = openAi.generateImages(request)
        println(result)
        assertTrue { !result.data.isNullOrEmpty() }
        val data = result.data!![0]
        assertTrue { !data!!.url.isNullOrEmpty() }
    }

    @Test
    fun shouldEditImage() {
        val request = ImageEditRequest(
            imagePath = "C:\\Users\\saukum\\Documents\\Saurav\\Projects\\openAi\\openAiLibrary\\src\\test\\resources\\binarycode.png",
            prompt = "make it look like this photo is digital art"
        )
        val result = openAi.editImage(request)
        println("result -> $result")
        assertTrue { !result.data.isNullOrEmpty() };
    }

    @Test
    fun shouldCreateImageVariations() {
        val request = ImageVariationRequest(
            imagePath = "C:\\Users\\saukum\\Documents\\Saurav\\Projects\\openAi\\openAiLibrary\\src\\test\\resources\\binarycode.png"
        )
        val result = openAi.generateImageVariations(request)
        println("result -> $result")
        assertTrue { !result.data.isNullOrEmpty() };
    }
}

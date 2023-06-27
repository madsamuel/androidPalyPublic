package com.seattledevcamp.samplerecyckeview

public class MyItems(
    private var name: String?,
    private var email: String?,
    private var imageId: Int
) {

    // Getter for the `name` property
    fun getName() = name

    // Setter for the `name` property
    fun setName(newName: String) {
        name = newName
    }

    // Getter for the `email` property
    fun getEmail() = email

    // Setter for the `email` property
    fun setEmail(newEmail: String) {
        email = newEmail
    }

    // Getter for the `imageId` property
    fun getImage() = imageId

    // Setter for the `imageId` property
    fun setImageId(newImageId: Int) {
        imageId = newImageId
    }
}
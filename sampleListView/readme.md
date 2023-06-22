Sample 3-tier layout Kotlin application

This application demonstrates a sample 3-tier layout in Kotlin. The view layer is hardcoded with data, but it can be rewritten to come from a Room database. There are a lot of things that need to be fixed in this application, but it is a working example of a three-tier layout.

The 3-tier layout consists of the following layers:

Presentation layer: This layer is responsible for displaying data to the user and handling user input.
Data access layer: This layer is responsible for accessing data from a persistent storage such as a database.
Repository layer: This layer provides an abstraction layer for accessing data from the database.
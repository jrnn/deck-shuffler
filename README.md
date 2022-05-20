# Deck Shuffler

Quick exercise in shuffling a standard 52-card deck in Java. Resorting to good old Fisher-Yates.

Might be superfluous, but Gradle is used for building and dependency management.

Build the application (incl. tests) with:

    $ ./gradlew clean build

Run the application with:

    $ ./gradlew run

Note: if `gradlew` complains about missing permissions, it might be because I created this project
on Windows and it might be missing the execution flag. It *should* be set, but I didn't get around
to verifying. Just in case, here's how to set it:

    $ chmod +x gradlew

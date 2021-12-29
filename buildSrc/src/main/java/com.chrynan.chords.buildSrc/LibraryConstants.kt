@file:Suppress("MemberVisibilityCanBePrivate")

package com.chrynan.chords.buildSrc

object LibraryConstants {

    const val group = "com.chrynan.chords"
    const val owner = "chrynan"
    const val repoName = "chords"
    const val versionName = "2.4.1"
    const val versionCode = 6
    const val versionDescription = "Release $versionName ($versionCode)"
    const val license = "Apache-2.0"
    const val vcsUrl = "https://github.com/chRyNaN/chords.git"

    object Android {

        const val compileSdkVersion = 31
        const val minSdkVersion = 24
        const val targetSdkVersion = 31
    }
}

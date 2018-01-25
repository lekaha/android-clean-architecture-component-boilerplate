package com.lekaha.android.boilerplate.common

class Preconditions private constructor() {

    init {
        throw AssertionError("Don't create instances of this object")
    }

    companion object {

        /**
         * Checks if the reference is not null.
         *
         * @param reference an object reference
         * @return the non-null reference
         * @throws NullPointerException if `reference` is null
         */
        operator fun <T> get(reference: T?): T {
            if (reference == null) {
                throw NullPointerException("Assertion for a nonnull object failed.")
            }
            return reference
        }

        /**
         * Checks if the reference is not null.
         *
         * @param reference object reference
         * @return non-null reference
         * @throws NullPointerException if `reference` is null
         */
        fun <T> checkNotNull(reference: T?): T {
            if (reference == null) {
                throw NullPointerException()
            }
            return reference
        }

        /**
         * Checks if the reference is not null.
         *
         * @param reference    object reference
         * @param errorMessage message used if the check fails
         * @return non-null reference
         * @throws NullPointerException if `reference` is null
         */
        fun <T> checkNotNull(reference: T?, errorMessage: String): T {
            if (reference == null) {
                throw NullPointerException(get(errorMessage))
            }
            return reference
        }
    }
}
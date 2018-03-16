package com.playone.mobile.ext

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class BooleanTest {

    @Mock
    lateinit var mockObj: MockObject

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_iftrue_true() {

        val test = true
        test.ifTrue {
            mockObj.action()
        }

        verify(mockObj).action()
    }

    @Test
    fun test_iftrue_false() {

        val test = false
        test.ifTrue {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    @Test
    fun test_iftrue_null() {

        val test: Boolean? = null
        test.ifTrue {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    @Test
    fun test_iffalse_true() {

        val test = true
        test.ifFalse {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    @Test
    fun test_iffalse_false() {

        val test = false
        test.ifFalse {
            mockObj.action()
        }

        verify(mockObj, times(1)).action()
    }

    @Test
    fun test_iffalse_null() {

        val test: Boolean? = null
        test.ifFalse {
            mockObj.action()
        }

        verify(mockObj, times(1)).action()
    }

    @Test
    fun test_iffalse_otherwise_true() {

        val test = true
        test.ifFalse {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, times(1)).action()
    }

    @Test
    fun test_iffalse_otherwise_false() {

        val test = false
        test.ifFalse {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    @Test
    fun test_iftrue_otherwise_true() {

        val test = true
        test.ifTrue {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    @Test
    fun test_iftrue_otherwise_false() {

        val test = false
        test.ifTrue {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, times(1)).action()
    }

    @Test
    fun test_iftrue_otherwise_null() {

        val test: Boolean? = null
        test.ifTrue {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, times(1)).action()
    }

    @Test
    fun test_iffalse_otherwise_null() {

        val test: Boolean? = null
        test.ifFalse {
            mockObj.none()
        } otherwise {
            mockObj.action()
        }

        verify(mockObj, never()).action()
    }

    open class MockObject {
        open fun action() {}
        open fun none() {}
    }
}
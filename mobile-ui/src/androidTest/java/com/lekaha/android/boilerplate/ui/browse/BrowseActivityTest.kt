package com.lekaha.android.boilerplate.ui.browse

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.lekaha.android.boilerplate.domain.model.Bufferoo
import com.lekaha.android.boilerplate.ui.R
import com.lekaha.android.boilerplate.ui.test.TestApplication
import com.lekaha.android.boilerplate.ui.test.factory.AndroidTestBufferooFactory
import com.lekaha.android.boilerplate.ui.test.util.RecyclerViewMatcher
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BrowseActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<BrowseActivity>(BrowseActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        stubBufferooRepositoryGetBufferoos(Single.just(AndroidTestBufferooFactory.makeBufferooList(2)))
        activity.launchActivity(null)
    }

    @Test
    fun bufferoosDisplay() {
        val bufferoos = AndroidTestBufferooFactory.makeBufferooList(1)
        stubBufferooRepositoryGetBufferoos(Single.just(bufferoos))
        activity.launchActivity(null)

        checkBufferooDetailsDisplay(bufferoos[0], 0)
    }

    @Test
    fun bufferoosAreScrollable() {
        val bufferoos = AndroidTestBufferooFactory.makeBufferooList(20)
        stubBufferooRepositoryGetBufferoos(Single.just(bufferoos))
        activity.launchActivity(null)

        bufferoos.forEachIndexed { index, bufferoo ->
            onView(withId(R.id.recycler_browse)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index)
            )
            checkBufferooDetailsDisplay(bufferoo, index)
        }
    }

    private fun checkBufferooDetailsDisplay(bufferoo: Bufferoo, position: Int) {
        onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_browse).atPosition(position))
            .check(matches(hasDescendant(withText(bufferoo.name))))
        onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_browse).atPosition(position))
            .check(matches(hasDescendant(withText(bufferoo.title))))
    }

    private fun stubBufferooRepositoryGetBufferoos(single: Single<List<Bufferoo>>) {
        whenever(TestApplication.appComponent().bufferooRepository().getBufferoos())
            .thenReturn(single)
    }

}
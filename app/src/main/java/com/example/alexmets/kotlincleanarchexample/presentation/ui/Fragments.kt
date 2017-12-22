package com.example.alexmets.kotlincleanarchexample.presentation.ui

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.text.TextUtils
import java.util.ArrayList

class Fragments {

    fun from(fragmentManager: FragmentManager): Builder {
        return Builder(fragmentManager)
    }

    class Builder (private val mFragmentManager: FragmentManager) {
        private val mReplacements = ArrayList<Replacement>()

        private var mClearBackStack = false
        private var mAnimate = false

        fun clearBackStack(): Builder {
            mClearBackStack = true
            return this
        }

        @JvmOverloads
        fun replace(@IdRes containerViewId: Int,
                    fragment: Fragment,
                    tag: String? = null): Builder {
            mReplacements.add(Replacement(containerViewId, fragment, tag))
            return this
        }

        fun animate(): Builder {
            mAnimate = true
            return this
        }

        fun commit() {
            if (mClearBackStack) {
                mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }

            for (r in mReplacements) {
                val ft = mFragmentManager.beginTransaction()
                if (mAnimate) {
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                }
                if (!TextUtils.isEmpty(r.mTag)) {
                    ft.addToBackStack(r.mTag)
                }
                ft.replace(r.mContainerViewId, r.mFragment, r.mTag)
                ft.commit()
            }
        }
    }

    private class Replacement internal constructor(@param:IdRes internal var mContainerViewId: Int,
                                                   internal var mFragment: Fragment,
                                                   internal var mTag: String?)

    fun pop(fragmentManager: FragmentManager,
            tag: String): Fragment? {
        val fragment = fragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            fragmentManager.popBackStack(tag, 0)
        }
        return fragment
    }

}
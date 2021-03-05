package com.srg.pruebamarvel.common.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Created by sebrodgar on 27/02/2021.
 */
abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout)
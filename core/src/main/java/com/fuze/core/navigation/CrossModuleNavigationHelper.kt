package com.fuze.core.navigation

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.fuze.core.extensions.putEnumExtra
import com.fuze.core.navigation.feature.MatchesModuleConstants


object CrossModuleNavigationHelper {

    @JvmStatic
    fun navigateToMatches(context: Context) =
        Intent(MatchesModuleConstants.MODULE_ACTION).takeIf { intent ->
            canNavigate(context, intent)
        }?.also { intent ->
            intent.putEnumExtra(
                DefaultConstants.NAVIGATION_FEATURE_KEY,
                MatchesModuleConstants.FeaturesEnum.MATCHES
            )
        }

    private fun canNavigate(context: Context, intent: Intent) =
        context.packageManager
            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            .isNotEmpty()
}
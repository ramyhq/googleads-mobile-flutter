package io.flutter.plugins.googlemobileads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.Nullable;

/** Class that helps detect whether the news or game template is being used. */
class FlutterRequestAgentProvider {

  private static final String GAME_VERSION_KEY =
      "io.flutter.plugins.googlemobileads.FLUTTER_GAME_TEMPLATE_VERSION";
  private static final String TEMPLATE_VERSION_KEY =
      "io.flutter.plugins.googlemobileads.FLUTTER_NEWS_TEMPLATE_VERSION";

  private final Context context;
  @Nullable private String newsTemplateVersion;
  @Nullable private String gameTemplateVersion;

  FlutterRequestAgentProvider(Context context) {
    this.context = context;
    processGameAndNewsTemplateVersions(context);
  }

  private void processGameAndNewsTemplateVersions(Context context) {
    try {
      ApplicationInfo info =
          context
              .getApplicationContext()
              .getPackageManager()
              .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
      Bundle metaData = info.metaData;
      if (metaData != null) {
        gameTemplateVersion = info.metaData.getString(GAME_VERSION_KEY);
        newsTemplateVersion = info.metaData.getString(TEMPLATE_VERSION_KEY);
      }
    } catch (NameNotFoundException | ClassCastException e) {
      // Do nothing
    }
  }

  String getRequestAgent() {
    StringBuilder sb = new StringBuilder();
    sb.append(Constants.REQUEST_AGENT_PREFIX_VERSIONED);
    if (newsTemplateVersion != null) {
      sb.append("_");
      sb.append(Constants.REQUEST_AGENT_NEWS_TEMPLATE_PREFIX);
      sb.append(newsTemplateVersion);
    }
    if (gameTemplateVersion != null) {
      sb.append("_");
      sb.append(Constants.REQUEST_AGENT_GAME_TEMPLATE_PREFIX);
      sb.append(gameTemplateVersion);
    }
    return sb.toString();
  }
}

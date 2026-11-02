package com.capacitorjs.plugins.localnotifications;

import android.content.Context;
import com.getcapacitor.plugin.util.AssetUtil;

/**
 * Resolves optional notification small-icon resources for Live Activities / timer notifications.
 */
final class NotificationIconHelper {

    private NotificationIconHelper() {}

    /**
     * @return drawable/mipmap resource id, or 0 if name is absent or not found
     */
    static int resolveSmallIconResource(Context context, String smallIconName) {
        if (smallIconName == null || smallIconName.isEmpty()) {
            return 0;
        }
        String name = AssetUtil.getResourceBaseName(smallIconName);
        int resId = AssetUtil.getResourceID(context, name, "drawable");
        if (resId == AssetUtil.RESOURCE_ID_ZERO_VALUE) {
            resId = AssetUtil.getResourceID(context, name, "mipmap");
        }
        return resId == AssetUtil.RESOURCE_ID_ZERO_VALUE ? 0 : resId;
    }

    static int effectiveSmallIcon(int customResId, boolean exceededAlert) {
        if (customResId != 0) {
            return customResId;
        }
        return exceededAlert ? android.R.drawable.ic_dialog_alert : android.R.drawable.ic_dialog_info;
    }
}

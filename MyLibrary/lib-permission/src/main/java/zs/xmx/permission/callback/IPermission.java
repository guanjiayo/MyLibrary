package zs.xmx.permission.callback;

import java.util.List;

/**
 * 权限结果回调
 */
public interface IPermission {
    //同意权限
    void PermissionGranted();

    //拒绝权限并且选中不再提示
    void PermissionDenied(int requestCode, List<String> denyList);

    //取消权限
    void PermissionCanceled(int requestCode);
}

package zs.xmx;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import zs.xmx.permission.PermissionActivity;
import zs.xmx.permission.R;
import zs.xmx.permission.callback.IPermission;
import zs.xmx.permission.constant.PermissionConstants;
import zs.xmx.permission.utils.SettingUtils;

/**
 * 使用方法类
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String TAG = "PERMISSION";

    private void intPermission() {
        /**
         * @Context 上下文
         * @PermissionArray 权限数组
         * @requestCode 请求码, 我们可以自定义的
         *
         */
        PermissionActivity.PermissionRequest(this, PermissionConstants.requestPermissions, 0, new IPermission() {
            @Override
            public void PermissionGranted() {
                Log.e(TAG, "PermissionGranted: ");
            }

            @Override
            public void PermissionDenied(int requestCode, List<String> denyList) {
                //多个权限申请返回结果
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < denyList.size(); i++) {
                    Log.e(TAG, "PermissionDenied: 被拒绝权限数" + denyList.get(i));
                    if (Manifest.permission.CALL_PHONE.equals(denyList.get(i))) {
                        builder.append("电话");
                    } else if (Manifest.permission.CAMERA.equals(denyList.get(i))) {
                        builder.append("相机");
                    }
                }
                builder.append("权限被禁止，需要手动打开");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("提示")
                        .setMessage(builder)
                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                SettingUtils.go2Setting(MainActivity.this);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();
            }

            @Override
            public void PermissionCanceled(int requestCode) {
                Log.e(TAG, "PermissionCanceled: ");
            }
        });
    }

    public void requestPermissions(View view) {
        intPermission();
    }
}

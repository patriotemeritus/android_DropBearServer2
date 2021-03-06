package me.shkschneider.dropbearserver2.task;

import android.content.Context;

import me.shkschneider.dropbearserver2.util.ServerUtils;
import me.shkschneider.dropbearserver2.util.ShellUtils;

public class Remover extends Task {

	public Remover(Context context, Callback<Boolean> callback) {
		super(Callback.TASK_REMOVE, context, callback, false);

		if (mProgressDialog != null) {
			mProgressDialog.setTitle("Remover");
		}
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		publishProgress("Dropbear binary");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/dropbear");

		publishProgress("Dropbearkey binary");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/dropbearkey");

		publishProgress("SSH binary");
		ShellUtils.rm("/system/xbin/ssh");

		publishProgress("SCP binary");
		ShellUtils.rm("/system/xbin/scp");

		publishProgress("DBClient binary");
		ShellUtils.rm("/system/xbin/dbclient");

		publishProgress("Banner");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/banner");

		publishProgress("Authorized keys");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/authorized_keys");

		publishProgress("Host RSA key");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/host_rsa");

		publishProgress("Host DSS key");
		ShellUtils.rm(ServerUtils.getLocalDir(mContext) + "/host_dss");

		return true;
	}
}
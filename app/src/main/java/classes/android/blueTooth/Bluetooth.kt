package classes.android.blueTooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService

fun main() {
    /**
     * Before your app can communicate over Bluetooth or Bluetooth Low Energy,
     * you need to verify that Bluetooth is supported on the device
     *
     * The first step is adding the Bluetooth permissions to your manifest file in order to use the following APIs.
     *
     * Once the permissions are in place, Bluetooth setup is accomplished in two steps using the BluetoothAdapter:
     * */
}

class Bluetooth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        => 1=> Get the BluetoothAdapter.
        The BluetoothAdapter is required for any and all Bluetooth activity.
        The BluetoothAdapter represents the device's own Bluetooth adapter (the Bluetooth radio).
        To get a BluetoothAdapter, you first need to have a Context.
        Use this context to obtain an instance of the BluetoothManager system service.
        Calling BluetoothManager#getAdapter will give you a BluetoothAdapter object.
        If getAdapter() returns null, then the device doesn't support Bluetooth.
        * */
        val bluetoothManager: BluetoothManager? = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager?.adapter
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }

        /*
        => 2=> Enable Bluetooth.
        Next, you need to ensure that Bluetooth is enabled. Call isEnabled()
        * to check whether Bluetooth is currently enabled. If this method returns false,
        * then Bluetooth is disabled. To request that Bluetooth be enabled,
        * call startActivityForResult(), passing in an ACTION_REQUEST_ENABLE intent action.
        * This call issues a request to enable Bluetooth through the system settings
        * (without stopping your app).
        * */
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            startActivityForResult(enableBtIntent, 1)
        }
    }
}

/**
 * If bluetooth is enabled then we can listen the Bluetooth using broadcast by providing IntentFilter.
 *
 * Optionally, your app can also listen for the ACTION_STATE_CHANGED broadcast intent,
 * which the system broadcasts whenever the Bluetooth state changes.
 * This broadcast contains the extra fields EXTRA_STATE and EXTRA_PREVIOUS_STATE,
 * containing the new and old Bluetooth states, respectively.
 * Possible values for these extra fields are STATE_TURNING_ON, STATE_ON,
 * STATE_TURNING_OFF, and STATE_OFF. Listening for this broadcast can be useful
 * if your app needs to detect runtime changes made to the Bluetooth state.
 * */
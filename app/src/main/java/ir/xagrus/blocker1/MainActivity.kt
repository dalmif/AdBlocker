package ir.xagrus.blocker1

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import ir.xagrus.blocker1.R
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent != null && intent.action == Intent.ACTION_VIEW)  {
           // Toast.makeText(this,"")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                appnamee.text =  referrer?.host
                val pm = packageManager.getPackageInfo(referrer?.host ?: "",0)
                appname.text = pm.applicationInfo.name
                linkLabel.text = URL(intent.data.scheme, intent.data.host, intent.data.path).toString()
                                        val packageName = referrer?.host ?: ""
                val packageManager= packageManager
                val appName = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA));
                textView.text = appName

            }

            //callingActivity
          //  println("HELLO " + callingPackage + parentActivityIntent?.component?.packageName + "ad: "+ intent.component?.packageName+ "   bb: "+ callingActivity?.packageName + "xccc: " + supportParentActivityIntent?.component?.packageName  + "action : "+intent.action)
        }

    }
}

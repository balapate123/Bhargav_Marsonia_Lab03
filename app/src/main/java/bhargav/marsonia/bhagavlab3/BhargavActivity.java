package bhargav.marsonia.bhagavlab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Bhargav Marsonia
 * 301108254
 * 002
 */

public class BhargavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhargav);

        BottomNavigationView bottomNav = findViewById(R.id.bhargavBottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.bhargavFragment,
                new BhargavFragment()).commit();

    }
    @Override
    public void onBackPressed() {

        backPressed(getResources().getString(R.string.sure));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.bhargavDraw:
                            selectedFragment = new BhargavFragment();
                            break;

                        case R.id.bhargavImageAnim:
                            selectedFragment = new MarsoniaFragment();
                            break;

                        case R.id.bhargavRotate:
                            selectedFragment = new S301108254Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.bhargavFragment,
                            selectedFragment).commit();
                    return true;
                }
            };

    public void backPressed(String alertmessage) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        android.os.Process.killProcess(android.os.Process.myPid());

                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(BhargavActivity.this);
        builder.setMessage(alertmessage)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, dialogClickListener)
                .setNegativeButton(R.string.no, dialogClickListener)
                .setTitle(R.string.close)
                .setIcon(R.drawable.ic_alert);
        AlertDialog alert = builder.create();
        alert.show();

    }
}
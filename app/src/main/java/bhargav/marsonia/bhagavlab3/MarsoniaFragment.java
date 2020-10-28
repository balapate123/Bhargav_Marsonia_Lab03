package bhargav.marsonia.bhagavlab3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * Bhargav Marsonia
 * 301108254
 * 002
 */
public class MarsoniaFragment extends Fragment {

    Button mPermission, mStart, mStop;
    ImageView mAnimImage;
    RadioGroup radioGroup;
    AnimationDrawable mframeAnimation = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_marsonia, container, false);

        mPermission = v.findViewById(R.id.bhargavPermission);
        mPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.CAMERA, 200);
            }
        });

        radioGroup = v.findViewById(R.id.bhargavRadioGroup);

        mStart = v.findViewById(R.id.bhargavStart);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame0);
                BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame1);
                BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame2);
                BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame3);


                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);
                String selectedText = (String) radioButton.getText();


                float timeInMiliseconds = Float.parseFloat(selectedText) * 100;
                int reasonableDuration = (int) timeInMiliseconds;
                Log.i("Time ", "" + reasonableDuration);


                mframeAnimation = new AnimationDrawable();
                mframeAnimation.setOneShot(false);
                mframeAnimation.addFrame(frame1, reasonableDuration);
                mframeAnimation.addFrame(frame2, reasonableDuration);
                mframeAnimation.addFrame(frame3, reasonableDuration);
                mframeAnimation.addFrame(frame4, reasonableDuration);


                mAnimImage.setBackground(mframeAnimation);

                mframeAnimation.setVisible(true, true);
                mframeAnimation.start();
            }
        });
        mStop = v.findViewById(R.id.bhargavStop);
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mframeAnimation.stop();
                mframeAnimation.setVisible(false, false);
            }
        });
        mAnimImage = v.findViewById(R.id.bhargavImage);

        return v;
    }

    public void checkPermission(String permission, int requestCode) {


        if (ContextCompat.checkSelfPermission(
                getActivity(),
                permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat
                    .requestPermissions(
                            getActivity(),
                            new String[]{permission},
                            requestCode);
        } else {
            Toast
                    .makeText(getActivity(),
                            R.string.permissionAlready,
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
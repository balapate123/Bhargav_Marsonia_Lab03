package bhargav.marsonia.bhagavlab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Bhargav Marsonia
 * 301108254
 * 002
 */

public class S301108254Fragment extends Fragment {

    ImageView sEarth, sMoon;
    TextView sFirstName, sLastName;
    Button sStop, sStart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_s301108254, container, false);

        sFirstName = v.findViewById(R.id.bhargavFname);
        sLastName = v.findViewById(R.id.bhargavLname);

        RotateAnimation rotateLeft= (RotateAnimation)AnimationUtils.loadAnimation(getActivity(), R.anim.left_rotation);
        sFirstName.setAnimation(rotateLeft);

        RotateAnimation rotateRight= (RotateAnimation)AnimationUtils.loadAnimation(getActivity(), R.anim.right_rotation);
        sLastName.setAnimation(rotateRight);

        sEarth = v.findViewById(R.id.bhargavEarth);
        sMoon = v.findViewById(R.id.bhargavMoon);

        final Animation animEarth =  AnimationUtils.loadAnimation(container.getContext(), R.anim.rotation);
        sEarth.startAnimation(animEarth);

        final Animation animMoon =  AnimationUtils.loadAnimation(container.getContext(), R.anim.revolving);
        sMoon.startAnimation(animMoon);

        sStop = v.findViewById(R.id.bhargavStop);
        sStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sEarth.clearAnimation();
                sMoon.clearAnimation();
                animEarth.cancel();
                animMoon.cancel();

            }
        });

        sStart = v.findViewById(R.id.bhargavStart);
        sStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEarth.startAnimation(animEarth);
                sMoon.startAnimation(animMoon);
            }
        });
        return v;
    }
}
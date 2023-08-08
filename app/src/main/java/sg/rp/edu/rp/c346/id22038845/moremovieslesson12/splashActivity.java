package sg.rp.edu.rp.c346.id22038845.moremovieslesson12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.content.Intent;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    private MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        motionLayout = findViewById(R.id.motionLayout);

        motionLayout.setTransitionListener(new MotionLayout.TransitionListener(){
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                // Animation started
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                // Animation in progress
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                // Animation completed, start Mainactivity
                Intent intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                // Transition trigger
            }
        });


    }
}
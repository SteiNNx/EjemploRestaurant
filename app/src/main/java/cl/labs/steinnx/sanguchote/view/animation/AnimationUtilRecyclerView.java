package cl.labs.steinnx.sanguchote.view.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by DUOC on 18-11-2017.
 */

public class AnimationUtilRecyclerView {
    public static void animate(RecyclerView.ViewHolder holder , boolean goesDown){


        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown==true ? 200 : -200, 0);
        animatorTranslateY.setDuration(1000);


        animatorSet.playTogether(animatorTranslateY);

        //animatorSet.playTogether(animatorTranslateY);
        animatorSet.start();

    }
}

package net.bote.ggbooster.api;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

@NoArgsConstructor
@Getter
public class BoosterManager {

    private ArrayList<Boost> activeBoosts = Lists.newArrayList();

    public boolean isActive(Boost boost) {
        return activeBoosts.contains(boost);
    }

    public void startBoost(Boost boost) {
        if(isActive(boost)) return;
        boost.onStart();
    }


}

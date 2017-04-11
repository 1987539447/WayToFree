package com.github.siemen.effective.enumandannotion;
/**
 * Created by Zhan on 2017-04-05.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 使用EnumMap索引
 * 双重索引
 */
public enum Phase {
    SOLID,LIQUID,GAS;

    public enum Transition{
        MELT(SOLID,LIQUID),
        FREEZE(LIQUID,SOLID),
        BOIL(LIQUID,GAS),CONDENES(GAS,LIQUID);

        private final Phase src;
        private final Phase dest;

        Transition(Phase src, Phase dest) {
            this.src = src;
            this.dest = dest;
        }

        private static final Map<Phase,Map<Phase,Transition>> m = new HashMap<>();
        static {
            for (Phase phase : Phase.values()) {
                m.put(phase,new HashMap<>());
            }
            for (Transition transition : Transition.values()) {
                m.get(transition.src).put(transition.dest,transition);
            }
        }
        public static Transition from(Phase src,Phase dest){
            return m.get(src).get(dest);
        }
    }
}

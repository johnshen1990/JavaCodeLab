package io.github.johnshen1990.javacodelab.javabasic.mvt;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MvtUtil {

    public static int mvt(String key, Experiment experiment) {
        int hashCode = hash(key);
        int mod = hashCode % 100;
        List<ExperimentGroup> experimentGroupList = experiment.getExperimentGroupList();
        for(ExperimentGroup experimentGroup : experimentGroupList) {
            if(experimentGroup.getRatioRange().inBound(mod)) {
                return experimentGroup.getValue();
            }
        }
        return 0;
    }


    public static int hash(String key){
        return Math.abs(key.hashCode());
//        return Math.abs(Hashing.murmur3_32().hashString(key, Charset.forName("UTF-8")).asInt());
    }

    public static void main(String[] args) {

        Experiment experiment = new Experiment();
        ExperimentGroup group1 = new ExperimentGroup(new RatioRange(0, 49), 0);
        ExperimentGroup group2 = new ExperimentGroup(new RatioRange(50, 99), 1);
        List<ExperimentGroup> experimentGroupList = new ArrayList<>();
        experimentGroupList.add(group1);
        experimentGroupList.add(group2);

        experiment.setExperimentGroupList(experimentGroupList);

        List<String> keyList = new ArrayList<>();
        for(int i = 0; i < 2000000; i++) {
            keyList.add(UUID.randomUUID().toString());
        }


        int result0Counter = 0;
        int result1Counter = 0;
        for(String key : keyList) {
            int mvtResult = mvt(key, experiment);
            switch (mvtResult) {
                case 0 : result0Counter++; break;
                case 1 : result1Counter++; break;
            }
        }
        System.out.println("result0Counter = " + result0Counter);
        System.out.println("result1Counter = " + result1Counter);
    }
}

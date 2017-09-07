package io.github.johnshen1990.javacodelab.javabasic.mvt;

import java.util.List;

public class Experiment {
    private int id;
    private String name;
    private List<ExperimentGroup> experimentGroupList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExperimentGroup> getExperimentGroupList() {
        return experimentGroupList;
    }

    public void setExperimentGroupList(List<ExperimentGroup> experimentGroupList) {
        this.experimentGroupList = experimentGroupList;
    }
}

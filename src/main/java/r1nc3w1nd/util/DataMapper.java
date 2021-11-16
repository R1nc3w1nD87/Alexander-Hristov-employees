package r1nc3w1nd.util;


import r1nc3w1nd.data.Record;
import r1nc3w1nd.data.Tuple;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMapper {

    List<Record> data;
    Map<Tuple, Long> collaborationData = new HashMap<>();

    public DataMapper(List<Record> data){
        this.data = data;
    }

    public Map<Tuple, Long> mapData(){
        for (int i = 0; i < data.size(); i++) {
            int currentEmployeeId = data.get(i).getEmployeeId();
            int currentProjectId = data.get(i).getProjectId();
            long daysOnProject = data.get(i).daysOnProject();

            for (Record datum : data) {
                if (datum.getEmployeeId() != currentEmployeeId
                        && datum.getProjectId() == currentProjectId) {
                    Tuple employeePair = new Tuple(currentEmployeeId, datum.getEmployeeId());
                    long collaborationDaysCount = Math.min(daysOnProject, datum.daysOnProject());
                    if (!collaborationData.containsKey(employeePair)) {
                        collaborationData.put(employeePair, collaborationDaysCount);
                    } else {
                        collaborationData.put(employeePair, collaborationData.get(employeePair) + collaborationDaysCount);
                    }
                }
            }
        }
        return collaborationData;
    }


}

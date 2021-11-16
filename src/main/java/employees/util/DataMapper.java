package employees.util;


import employees.data.Record;
import employees.data.Tuple;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMapper {

    public Map<Tuple, Long> mapData(List<Record> data){
        Map<Tuple, Long> collaborationData = new HashMap<>();
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

package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LineRepository {
    private static final Map<Line,List<Station>> lines = new HashMap<>();

    public static Map<Line,List<Station>> lines() {
        return Collections.unmodifiableMap(lines);
    }

    public static void addLine(Line line,Station upTrainStation, Station downTrainStation) {
        List<Station> stationList = new ArrayList<>();
        stationList.add(upTrainStation);
        stationList.add(downTrainStation);
        lines.put(line,stationList);
    }

    public static boolean deleteLineByName(String name) {
        Optional<Line> findLine = findByName(name);

        if(findLine.isPresent()){
            lines.remove(findLine);
            return true;
        }
        return false;
    }

    public static Optional<Line> findByName(String name){
        return lines.keySet()
            .stream()
            .filter(line -> line.getName().equals(name))
            .findAny();
    }
}

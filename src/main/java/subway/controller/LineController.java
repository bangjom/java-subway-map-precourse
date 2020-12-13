package subway.controller;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.LineService;
import subway.view.OutputView;

public class LineController {
    public static boolean registerLine(String lineName
        , String upTrainLastStationName, String downTrainLastStationName) {
        try {
            LineService.register(lineName, upTrainLastStationName, downTrainLastStationName);
            subway.view.OutputView.print(OutputView.SUCCESS_TO_REGISTER_LINE_MESSAGE);
            return false;
        } catch (Exception e) {
            subway.view.OutputView.print(e.getMessage());
            return true;
        }
    }

    public static boolean deleteLine(String lineName) {
        try {
            LineService.delete(lineName);
            subway.view.OutputView.print(OutputView.SUCCESS_TO_DELETE_LINE_MESSAGE);
            return false;
        } catch (Exception e) {
            subway.view.OutputView.print(e.getMessage());
            return true;
        }
    }

    public static Map<Line, List<Station>> searchLine() {
        return LineService.search();
    }

    public static boolean registerSection(String lineName, String stationName, int sequence) {
        try {
            LineService.join(lineName, stationName, sequence);
            subway.view.OutputView.print(OutputView.SUCCESS_TO_REGISTER_SECTION_MESSAGE);
            return false;
        } catch (Exception e) {
            subway.view.OutputView.print(e.getMessage());
            return true;
        }
    }

    public static boolean deleteSection(String lineName, String stationName) {
        try {
            LineService.deleteStationInLine(lineName, stationName);
            subway.view.OutputView.print(OutputView.SUCCESS_TO_DELETE_SECTION_MESSAGE);
            return false;
        } catch (Exception e) {
            subway.view.OutputView.print(e.getMessage());
            return true;
        }
    }
}

import java.util.Map;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RoomScheduler {
    private Map<String, MeetingRoom> meetingRooms;

    public RoomScheduler() {
        this.meetingRooms = new HashMap<>();
    }

    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.getRoomId(), room);
        System.out.println("Room added: " + room.getRoomName() + ", ID: " + room.getRoomId());
    }

    public String bookRoom(String roomId, EnumSet<RoomFeature> requiredFeatures) {
        MeetingRoom room = meetingRooms.get(roomId);
        if (room != null && room.getFeatures().containsAll(requiredFeatures)) {
            return "Room " + roomId + " booked successfully.";
        } else {
            return "Room " + roomId + " does not meet the requirements.";
        }
    }
    public List<String> listAvailableRooms(EnumSet<RoomFeature> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : meetingRooms.values()) {
            if (room.getFeatures().containsAll(requiredFeatures)) {
                availableRooms.add(room.getRoomName());
            }
        }
        return availableRooms;
    }

    public static void main(String[] args) {
        RoomScheduler scheduler = new RoomScheduler();
        scheduler.addMeetingRoom(new MeetingRoom("001", "Boardroom", 20, EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE, RoomFeature.AIR_CONDITIONING)));
        scheduler.addMeetingRoom(new MeetingRoom("002", "Strategy Room", 10, EnumSet.of(RoomFeature.WHITEBOARD, RoomFeature.AIR_CONDITIONING)));
        System.out.println(scheduler.bookRoom("001", EnumSet.of(RoomFeature.PROJECTOR, RoomFeature.CONFERENCE_PHONE)));
        System.out.println("Available rooms with AIR_CONDITIONING: " + scheduler.listAvailableRooms(EnumSet.of(RoomFeature.AIR_CONDITIONING)));
    }
}

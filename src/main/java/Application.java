import com.clearfit.model.enums.Activity;
import com.clearfit.model.enums.model.Slot;
import com.clearfit.model.enums.response.WorkoutAvailabilityResponse;
import com.clearfit.service.AdminService;
import com.clearfit.service.CenterService;
import com.clearfit.service.UserService;
import com.clearfit.service.impl.AdminServiceImpl;
import com.clearfit.service.impl.CenterServiceImpl;
import com.clearfit.service.impl.UserServiceImpl;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        CenterService centerService = new CenterServiceImpl();
        AdminService adminService = new AdminServiceImpl();

        String centerName = "Koramangala";
        centerService.addCenter(centerName);
        centerService.addCenterTimings(centerName, List.of(new Slot(6, 9), new Slot(18, 21)));

        centerService.addCenterActivities(centerName, List.of(new Activity("weights"), new Activity("cardio"), new Activity("yoga"), new Activity("weights")));
        adminService.addWorkout(centerName, "weights", new Slot(6, 7), 100);
        adminService.addWorkout(centerName, "cardio", new Slot(7, 8), 100);
        adminService.addWorkout(centerName, "yoga", new Slot(8, 9), 100);

        centerName = "Bellandur";
        centerService.addCenterTimings(centerName, List.of(new Slot(7, 10), new Slot(19, 22)));
        centerService.addCenterActivities(centerName, List.of(new Activity("weights"), new Activity("cardio"), new Activity("yoga")));
        adminService.addWorkout(centerName, "weights", new Slot(18, 19), 100);
//        adminService.addWorkout(centerName, "swimming", new Slot(19, 20), 100);
        adminService.addWorkout(centerName, "cardio", new Slot(19, 20), 20);
        adminService.addWorkout(centerName, "cardio", new Slot(20, 21), 100);

        userService.register("Hitesh");
        List<WorkoutAvailabilityResponse> workoutDetails = userService.viewWorkoutAvailability("weights");
        for (WorkoutAvailabilityResponse workoutDetail : workoutDetails) {
            System.out.println(workoutDetail.getCenterName() + " - " + workoutDetail.getActivity().getName() + " - " + workoutDetail.getActivity().getSlot().getStart() + " - " + workoutDetail.getActivity().getSlot().getEnd() + " - " + workoutDetail.getActivity().getAvailable());
        }
        userService.bookASession("Hitesh", "Koramangala", "weights", new Slot(6, 7));

    }
}

package main.java.edu.narxoz.galactic.dispatcher;
import main.java.edu.narxoz.galactic.task.*;
import main.java.edu.narxoz.galactic.drones.*;
public class Dispatcher {
    public Result assignTask(DeliveryTask task, Drone drone) {
        if (task == null || drone == null) {
            return new Result(false, "Null arguments");
        }
        if (drone.getStatus() != DroneStatus.IDLE) {
            return new Result(false, "Drone is not IDLE");
        }
        if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg()) {
            return new Result(false, "Cargo too heavy for this drone");
        }
        if (task.getState() != TaskState.CREATED) {
            return new Result(false, "Task is not in created state");
        }
        drone.setStatus(DroneStatus.IN_FLIGHT); 
        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        return new Result(true, "Success");
    }
    public Result completeTask(DeliveryTask task) {
        if (task == null || task.getState() != TaskState.ASSIGNED || task.getAssignedDrone() == null) {
             return new Result(false, "Invalid task for completion");
        }
        Drone drone = task.getAssignedDrone();
        if (drone.getStatus() != DroneStatus.IN_FLIGHT) {
            return new Result(false, "Drone not in flight");
        }
        task.setState(TaskState.DONE);
        drone.setStatus(DroneStatus.IDLE);
        
        return new Result(true, "Task completed");
    }
}

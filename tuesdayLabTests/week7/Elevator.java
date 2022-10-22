import java.util.*;

enum Direction { UP, DOWN, IDLE }
enum Position { INSIDE_ELEVATOR, OUTSIDE_ELEVATOR }

class Call {
    int currFloorNumber;
    int calledFloorNumber;
    Direction direction;
    Position position;
    
    /**
     * A call is a request for calling the elevator, that is made by an individual
     * @param currFloorNumber The floor at which the elevator is present
     * @param calledFloorNumber The desired floor number
     * @param direction The direction in which the elevator is desired to move
     * @param position The position from where an individual has pressed for the `calledFloorNumber`
     */
    public Call(int currFloorNumber, int calledFloorNumber, Direction direction, Position position) {
        this.currFloorNumber = currFloorNumber;
        this.calledFloorNumber = calledFloorNumber;
        this.direction = direction;
        this.position = position;
    }
}

class Elevator {
    int currFloorNumber;
    Direction direction;
    PriorityQueue<Call> upQueue;
    PriorityQueue<Call> downQueue;
    
    public Elevator(int currFloorNumber) {
        this.currFloorNumber = currFloorNumber;
        this.direction = Direction.IDLE;
        
        // Use default, which is a min heap
        /* WRITE YOUR CODE HERE - Initialize */
        upQueue = new PriorityQueue<>((a, b) -> a.calledFloorNumber - b.calledFloorNumber);
        
        // Use a max heap
        /* WRITE YOUR CODE HERE - Initialize */
        downQueue =  new PriorityQueue<>((a, b) -> b.calledFloorNumber - a.calledFloorNumber);
    }
    
    public void sendUpCall(Call upCall) {
        /*
         * If the call is sent from outside of the elevator,
         * stop at the current floor of the requester to pick up,
         * and then go the the called floor number.
         */
        if (upCall.position == Position.OUTSIDE_ELEVATOR) {
            // Go pick up the requester who is outside of the elevator
            upQueue.offer(new Call(upCall.currFloorNumber,
                    upCall.currFloorNumber,
                    Direction.UP,
                    Position.OUTSIDE_ELEVATOR));
            
            System.out.println("Append up request to go to floor number " + upCall.currFloorNumber + ".");
        }
        
        // Go to the called floor number
        upQueue.offer(upCall);
        
        System.out.println("Append up request to go to floor number " + upCall.calledFloorNumber + ".");
    }
    
    public void sendDownCall(Call downCall) {
        // Similar to the sendUpCall logic
        /*
         * If the call is sent from outside of the elevator,
         * stop at the current floor of the requester to pick up,
         * and then go the the called floor number.
         */
        if (downCall.position == Position.OUTSIDE_ELEVATOR) {
            downQueue.offer(new Call(downCall.currFloorNumber,
                    downCall.currFloorNumber,
                    Direction.DOWN,
                    Position.OUTSIDE_ELEVATOR));
            
            System.out.println("Append down request to go to floor number " + downCall.currFloorNumber + ".");
        }
        
        // Go to the called floor number
        downQueue.offer(downCall);
        
        System.out.println("Append down request to go to floor number " + downCall.calledFloorNumber + ".");
    }
    
    public void simulate() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processCalls();
        }
        
        System.out.println("Finished all requests.");
        this.direction = Direction.IDLE;
    }
    
    /**
     * If the elevator is moving in direction UP or is IDLE,
     * `processUpCall()` followed by `processDownCall()`, vice versa otherwise
     */
    private void processCalls() {
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpCall();
            processDownCall();
        } else {
            processDownCall();
            processUpCall();
        }
    }
    
    private void processUpCall() {
        /* Process all upCalls in the upQueue */
        while (!upQueue.isEmpty()) {
            Call upCall = upQueue.poll();
            // Communicate with hardware
            this.currFloorNumber = upCall.calledFloorNumber;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currFloorNumber + ".");
        }
        if (!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }
    
    private void processDownCall() {
        /* Process all downCalls in the downQueue */
        while (!downQueue.isEmpty()) {
            Call downCall = downQueue.poll();
            // Communicate with hardware
            this.currFloorNumber = downCall.calledFloorNumber;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currFloorNumber + ".");
        }
        if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }
    
    
    public static void main(String[] args) {
        Elevator elevator = new Elevator(0);
        
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Call> upCalls = new ArrayList<>();
        ArrayList<Call> downCalls = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            String callInfo = sc.nextLine();
            String[] callInfoToParse = callInfo.split(",");
            Position position;
            if(callInfoToParse[0].equals("INSIDE_ELEVATOR"))
                position = Position.INSIDE_ELEVATOR;
            else
                position = Position.OUTSIDE_ELEVATOR;
            Direction direction;
            if(callInfoToParse[1].equals("UP"))
                direction = Direction.UP;
            else if(callInfoToParse[1].equals("DOWN"))
                direction = Direction.DOWN;
            else
                direction = Direction.IDLE;
            
            int calledFloorNumber = Integer.parseInt(callInfoToParse[2]);
            int currFloorNumber = elevator.currFloorNumber;
            if(callInfoToParse[0].equals("OUTSIDE_ELEVATOR"))
                currFloorNumber = Integer.parseInt(callInfoToParse[3]);
            
            Call call = new Call(currFloorNumber, calledFloorNumber, direction, position);
            if(callInfoToParse[1].equals("UP"))
                upCalls.add(call);
            else if(callInfoToParse[1].equals("DOWN"))
                downCalls.add(call);
        }
        
        for(Call upCall : upCalls)
            elevator.sendUpCall(upCall);
        
        for(Call downCall : downCalls)
            elevator.sendDownCall(downCall);
        
        elevator.simulate();
    }
}

package FirstWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Task{
	String uniqueID;
	String description;
	int priority;
	public Task(String uniqueID, String description, int priority) {
		super();
		this.uniqueID = uniqueID;
		this.description = description;
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Task [uniqueID=" + uniqueID + ", description=" + description + ", priority=" + priority + "]";
	}
}
class TaskManager{
	Queue<Task> priorityQueue=new PriorityQueue<>((t1,t2) -> Integer.compare(t2.priority, t1.priority));
	Map<String,Task> map=new HashMap<>();
	public void addTask(String id, String description, int priority) {
		if(map.containsKey(id)) {
			System.out.println("Id already exists");
			return;
		}
		Task t=new Task(id, description, priority);
		map.put(id, t);
		priorityQueue.add(t);
	}
	public void removeTask(String id) {
		if(!map.containsKey(id)) {
			System.out.println("There is no such Id");
			return;
		}
		priorityQueue.remove(map.get(id));
		map.remove(id);
	}
	public void getHighestPriorityTask() {
		System.out.println(priorityQueue.peek());
	}
}
public class First {
      public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		TaskManager t=new TaskManager();
		while(b) {
			System.out.println("1.addTask \n2.removeTask \n3.getHighestPriorityTask");
			int option=sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:
				System.out.println("Enter Task Id: ");
				String id=sc.next();
				System.out.println("Enter Priority: ");
				int priority=sc.nextInt();
				System.out.println("Enter Description: ");
				sc.nextLine();
				String des=sc.nextLine();
				t.addTask(id, des, priority);
				break;
			case 2:
				System.out.println("Enter Id to be removed: ");
				String id2=sc.next();
				t.removeTask(id2);
				break;
			case 3:
				System.out.println("Get highest priority task:");
				t.getHighestPriorityTask();
				break;
			default:
				b=false;
				break;
			}
		}
	}
}

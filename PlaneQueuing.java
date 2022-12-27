/*
Description: airport simulator
*/
public class PlaneQueuing
{
	private Node front;	// head of the list
	private Node rear;

	private class Node
	{
		int item; // number of the flight
		Node link; // link to the next node
		
		Node (int i, Node n)
		{
			item =i;
			link = n;
		}
	}

	// inserting new node at rear of the queue list
	void enqueue(int item)
	{
		Node newNode = new Node(item, null); // making a new node

		if(rear == null)
		{
			front = rear = newNode;
		}
		else
		{
			rear = rear.link = newNode;
		}
	}
 
	// deleting the flight number at front of the queue list
	void dequeue(int item)
	{
		if(front == null)
		{
			System.out.println("empty");
		}
		else if (front.item == item)   // if the item at the front is the same as the user input delete it
		{
			front = front.link;
			System.out.println("Flight " + item + " has departed from the runway at the front.");
		}
		else // if user input is not at the front of the queue list, do not delete it
		{
			System.out.println("Flight " + item + " is not the plane ready for takeoff.");
		}
		if(front == null) // if front is null, both rear and front should point to null
		{
			rear = front = null;
		}
	}
	
	// check if queue list is empty
	boolean isEmpty()
	{
		if(front == null && rear == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// printing Queue list
	void print()
	{
		if(isEmpty()) // if the list is empty
		{
			System.out.println("Cannot print empty queue.");
		}
		else
		{
			for (Node temp = front; temp != null; temp = temp.link)
			{
				System.out.print("[" + temp.item + "]-->");
			}
			System.out.println();
		}
		System.out.println();
	}
}
public class MyQueue
{
    private Node<String> head;
    private Node<String> tail;
    private int size;


    public boolean isEmpty()
    {
        return head == null;
    }

    public void add(String data)
    {
        Node node = new Node(data);

        if(tail != null)
        {
            tail.setNext(node);
        }

        tail = node;

        if(head == null)
        {
            head = node;
        }

        size++;
    }

    public String peek()
    {
        return head.getData();
    }

    public void remove()
    {
        String data = head.getData();
        head = head.getNext();

        if(head == null)
        {
            tail = null;
        }
        size--;
    }

    public String getHead()
    {
        return head.getData();
    }

    public String getTail()
    {
        return tail.getData();
    }

    public int getSize()
    {
        return size;
    }


}

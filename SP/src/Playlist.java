public class Playlist
{
    private Node<Song> head;
    private Node<Song> tail;

    public void add(Song song)
    {
        Node node = new Node(song);

        if(tail != null)
        {
            tail.setNext(node);
        }

        tail = node;

        if(head == null)
        {
            head = node;
        }
    }

    public void peek()
    {
        System.out.println(head.getData().getSongName());
    }

    public void remove()
    {
        Song data = head.getData();
        head = head.getNext();

        if(head == null)
        {
            tail = null;
        }

    }
}

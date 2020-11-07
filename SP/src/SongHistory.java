public class SongHistory
{
    private Node<Song> top;

    public void push(Song song)
    {
        Node node = new Node(song);
        node.setNext(top);
        top = node;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void pop()
    {
        top.setNext(top.getNext());
    }
}

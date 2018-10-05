package interfaces;

public interface Queue<X> {

    public void enQueue(X item);

    public X deQueue();

    public boolean contains(X item);

    public X access(int position);

    public int size();

}

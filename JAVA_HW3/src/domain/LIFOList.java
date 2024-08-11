package domain;
import java.util.ArrayList;

public class LIFOList <T> implements IList<T>{
    ArrayList<T> list;

    public LIFOList() {
        list = new ArrayList<T>();
    }
    
    public LIFOList(ArrayList<T> list) {
        this.list = list;
    }

    public LIFOList(LIFOList<T> lifoList) {
        list = new ArrayList<T>();
        lifoList.list.forEach((element) -> {
            list.add(element);
        });
    }

    public void add(T item) {
        list.add(item);
    }
    
    public T remove() {
        T temp =list.remove(list.size()-1);
        return temp;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
       
        return  (T[]) list.toArray();
    }

    public void remove(T object){
        list.remove(list.lastIndexOf(object));
    }

    @Override
    public IList<T> clone() {
        return new LIFOList<T>(this);
    }

    public T seek(){
        T temp = list.get(list.size()-1); 
        return temp;
    }
    
}
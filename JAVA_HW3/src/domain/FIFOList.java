package domain;
import java.util.ArrayList;

public class FIFOList <T> implements IList<T>{
    ArrayList<T> list;

    public FIFOList(ArrayList<T> list) {
        this.list = list;
    }

    public FIFOList() {
        list = new ArrayList<T>();
    }

    public FIFOList(FIFOList<T> fifoList) {
        list = new ArrayList<T>();
        fifoList.list.forEach((element) -> {
            list.add(element);
        });
    }

   
    @Override
    public void add(T item) {
        list.add((T) item);
        
    }


    @Override
    public T remove() {
        T temp = list.remove(0);
        return temp;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
        
    }

    @Override
    public void remove(T object) {
        list.remove(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) list.toArray();
    }

    public String toString(){
        String result = "";
        for(T element: list){
            result+= element.toString();
        }
        return result;
    }

    public IList<T> clone(){
        return new FIFOList<T>(this);
    }

    @Override
    public T seek() {

        T temp = list.get(0);
        return temp;
    }
    
   
    
}
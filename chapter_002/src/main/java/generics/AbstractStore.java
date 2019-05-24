package generics;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 23.05.2019
 * @version 1
 * @param <T> - param
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> storage;
    private int index = 0;

    public AbstractStore(int size) {
        this.storage = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.storage.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        } else {
            storage.set(index, model);
            return storage.get(index) == model;
        }
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        var model = storage.get(index);
        storage.remove(index);
        return storage.get(index) != model;
    }

    @Override
    public T findById(String id) {
        if (getIndex(id) == -1) {
            return null;
        } else {
            return storage.get(getIndex(id));
        }
    }
    public int getIndex(String id) {
        int count = 0;
        int indx = 0;
        for (T element : storage) {
            if (element.getId().equals(id)) {
                indx = count;
                break;
            }
            count++;
        }
        return indx;
    }
}

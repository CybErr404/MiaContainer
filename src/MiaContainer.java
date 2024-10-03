public class MiaContainer <T>{
    private T[] data;
    private int currentPosition;
    public MiaContainer() {
        data = (T[]) new Object[10];
        currentPosition = 0;
    }

    public void increaseSize() {
        if(currentPosition == data.length) {
            T[] temp = (T[]) new Object[data.length * 2];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    public void addData(T newData) {
        if(currentPosition == data.length) {
            increaseSize();
        }
        data[currentPosition] = newData;
        currentPosition++;
    }

    public void addData(int position, T newData) {
        if(position == 0) {
            addFirst(newData);
        }
        else if(position == data.length - 1) {
            addData(newData);
        }
        else {
            if(currentPosition == data.length) {
                increaseSize();
            }
            for(int i = data.length - 1; i > position; i--) {
                data[i] = data[i - 1];
            }
            data[position] = newData;
            currentPosition++;
        }
    }

    public void addFirst(T newData) {
        if(currentPosition == data.length) {
            increaseSize();
        }
        for(int i = data.length - 1; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = newData;
        currentPosition++;
    }

    public void addAll(T newData) {
        for(int i = 0; i < data.length; i++) {
            if(!(data[i] == newData)) {
                data[i] = newData;
            }
        }
    }

    public void replace(int position, T newData) {
        data[position] = newData;
    }

    public void remove(int positionToRemove) {
        if(positionToRemove == 0) {
            removeFirst();
        }
        else if(positionToRemove == data.length - 1) {
            data[positionToRemove] = null;
            currentPosition--;
        }
        else {
            data[positionToRemove] = null;
            for(int i = positionToRemove; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            data[data.length - 1] = null;
            currentPosition--;
        }
    }

    public void removeFirst() {
        data[0] = null;
        for(int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = null;
        currentPosition--;
    }

    public int[] clearContainer() {
        int[] clearedContainer = new int[]{};
        return clearedContainer;
    }

    public int checkSize() {
        return currentPosition;
    }

    public int getElement(int position) {
        return (int) data[position];
    }

    public boolean contains(T userData) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == userData) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T userData) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == userData) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentPosition == 0;
    }

    @Override
    public String toString() {
        String newString = "";
        for(int i = 0; i < currentPosition; i++) {
            newString = newString + data[i] + " ";
        }
        return newString;
    }
}
